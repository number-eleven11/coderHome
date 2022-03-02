package com.example.demo.controller;
import com.example.demo.dto.FileDTO;
import com.example.demo.provider.UcloudProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 文件上传方式 （以图片为例）
 * 1. 使用一个文件夹（nginx）映射出地址 缺点：依赖于主机迁移
 * 2.将图片转化为二进制存放在数据库，之后在前端序列化
 * 3.使用云存储
 */
@Controller
public class FileController {

    @Autowired
    private UcloudProvider ucloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody //json形式返回
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; //强制类型转换
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String filename = ucloudProvider.upload(file.getInputStream(), file.getContentType(),file.getOriginalFilename());
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            fileDTO.setUrl(filename);
            return fileDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/wechat.png");
        return fileDTO;
    }
}
