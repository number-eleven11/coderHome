package com.example.demo.dto;

import lombok.Data;

/**
 * Created by syh on 2022/2/1.
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String sort;
    private Long time;
    private String tag;
    private Integer page;
    private Integer size;
}
