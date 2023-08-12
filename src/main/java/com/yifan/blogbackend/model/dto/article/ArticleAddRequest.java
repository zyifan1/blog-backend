package com.yifan.blogbackend.model.dto.article;


import lombok.Data;

/**
 * @author 周逸凡
 *
 * 添加请求
 */

@Data
public class ArticleAddRequest {

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
}
