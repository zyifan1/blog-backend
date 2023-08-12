package com.yifan.blogbackend.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleVO {

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章简介
     */
    private String introduction;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章标签
     */
    private String label;

    /**
     * 创建时间
     */
    private Date createTime;
}
