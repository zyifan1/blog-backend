package com.yifan.blogbackend.model.dto.article;

import lombok.Data;

import java.util.Date;

/**
 * @author 周逸凡
 *
 * 查询请求
 */

@Data
public class ArticleQueryRequest {


    /**
     * 查询字段
     */
    private String queryField;

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
