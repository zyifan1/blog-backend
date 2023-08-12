package com.yifan.blogbackend.mapper;

import com.yifan.blogbackend.model.dto.article.ArticleAddRequest;
import com.yifan.blogbackend.model.entity.Articleinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
* @author 周逸凡
* @description 针对表【articleInfo(文章信息表)】的数据库操作Mapper
* @createDate 2023-08-09 14:38:59
* @Entity com.yifan.blogbackend.model.entity.Articleinfo
*/
public interface ArticleinfoMapper extends BaseMapper<Articleinfo> {

}




