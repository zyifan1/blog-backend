package com.yifan.blogbackend.model.dto.article;


import lombok.Data;

/**
 * @author 周逸凡
 *
 * 更新请求
 */


@Data
public class ArticleUpdateRequest {

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
