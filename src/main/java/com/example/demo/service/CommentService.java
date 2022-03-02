package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.enums.CommentTypeEnum;
import com.example.demo.enums.NotificationStatusEnum;
import com.example.demo.enums.NotificationTypeEnum;
import com.example.demo.exception.CustomizeErrorCode;
import com.example.demo.exception.CustomizeException;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    @Autowired
    private NotificationMapper notificationMapper;

    @Transactional //事务注解
    public void insert(Comment comment, User commentator) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);

            // 回复问题(强行复制)
            Question question = questionMapper.selectByPrimaryKey( Integer.parseInt(String.valueOf(comment.getParentId())));
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }

            //增加评论数
            Comment parentComment = new Comment();
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            commentExtMapper.incCommentCount(parentComment);
            //if (dbComment.getCommentator().longValue() == comment.getCommentator()) {
            //    return;
            //}
            Notification notification = new Notification();
            notification.setGmtCreate(System.currentTimeMillis());
            notification.setType(NotificationTypeEnum.REPLY_COMMENT.getType());
            notification.setOuterid(comment.getParentId());
            notification.setNotifier(comment.getCommentator().longValue());//转化为Long型
            notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
            notification.setReceiver(dbComment.getCommentator().longValue()); //db是查出来的
            notification.setNotifierName(commentator.getName());
            notification.setOuterTitle(question.getTitle());
            notificationMapper.insert(notification);
        } else {
            // 回复问题
            Question question = questionMapper.selectByPrimaryKey( Integer.parseInt(String.valueOf(comment.getParentId())));
            //f (question == null) {
            //    throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            //}
            comment.setCommentCount(0);
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
            if (question.getCreator().longValue() == comment.getCommentator()) {
                return;
            }
            Notification notification = new Notification();
            notification.setGmtCreate(System.currentTimeMillis());
            notification.setType(NotificationTypeEnum.REPLY_QUESTION.getType());
            notification.setOuterid(comment.getParentId());
            notification.setNotifier(comment.getCommentator().longValue());//转化为Long型
            notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
            notification.setReceiver(question.getCreator().longValue()); //回复与问题不同
            notification.setNotifierName(commentator.getName());
            notification.setOuterTitle(question.getTitle());
            notificationMapper.insert(notification);
        }
    }

    public List<CommentDTO> listByTargetId(Integer id, CommentTypeEnum type) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                        .andParentIdEqualTo(id.longValue())
                        .andTypeEqualTo(type.getType());

        commentExample.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        if(comments.size()==0){
            return null;
        }
        //获取去重的评论人Id
        Set<Integer> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());

        List<Integer> userIds = new ArrayList();

        userIds.addAll(commentators);


        //获取评论人，并且转换为map
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                        .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(new UserExample());

        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        //转化COMMENT为CommentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);

            commentDTO.setUser(userMap.get(comment.getCommentator()));
            //System.out.println(userMap.get(comment.getCommentator()));
            //System.out.println(commentDTO);
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;
    }
}
