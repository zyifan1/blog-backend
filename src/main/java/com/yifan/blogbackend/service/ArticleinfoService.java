package com.yifan.blogbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yifan.blogbackend.model.entity.Articleinfo;
import com.yifan.blogbackend.model.vo.ArticleVO;

import java.util.List;

/**
* @author 周逸凡
* @description 针对表【articleInfo(文章信息表)】的数据库操作Service
* @createDate 2023-08-09 14:38:59
*/
public interface ArticleinfoService extends IService<Articleinfo> {

    long addArticle(String title,String introduction,String content);


    /**
     * 参数校验
     * @param articleinfo entity
     * @param add 是否是插入数据时进行的校验
     */
    void validArticle(Articleinfo articleinfo,boolean add);


    /**
     * 查询
     * @param field 需要查询的字段名
     * @param articleinfo 对象
     * @return List<ArticleVO>
     */
    List<ArticleVO> queryArticle(String field,Articleinfo articleinfo) throws IllegalAccessException;




}
