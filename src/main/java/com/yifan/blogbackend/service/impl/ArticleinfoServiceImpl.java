package com.yifan.blogbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yifan.blogbackend.common.ErrorCode;
import com.yifan.blogbackend.exception.BusinessException;
import com.yifan.blogbackend.exception.ThrowUtils;
import com.yifan.blogbackend.mapper.ArticleinfoMapper;
import com.yifan.blogbackend.model.entity.Articleinfo;
import com.yifan.blogbackend.model.vo.ArticleVO;
import com.yifan.blogbackend.service.ArticleinfoService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周逸凡
 * @description 针对表【articleInfo(文章信息表)】的数据库操作Service实现
 * @createDate 2023-08-09 14:38:59
 */
@Service
public class ArticleinfoServiceImpl extends ServiceImpl<ArticleinfoMapper, Articleinfo>
        implements ArticleinfoService {


    @Resource
    ArticleinfoMapper articleinfoMapper;

    @Override
    public long addArticle(String title, String introduction, String content) {
        if (!StringUtils.isAnyEmpty(title, introduction, content)) {
            return -1;
        }


        return 0;
    }

    @Override
    public void validArticle(Articleinfo articleinfo, boolean add) {
        if (articleinfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String title = articleinfo.getTitle();
        String introduction = articleinfo.getIntroduction();
        String content = articleinfo.getContent();
        String label = articleinfo.getLabel();
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(title, introduction, content, label), ErrorCode.PARAMS_ERROR);
        }

        //在参数存在的情况加进行长度校验
        if (StringUtils.isNotBlank(title) && title.length() > 40) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }
        if (StringUtils.isNotBlank(introduction) && introduction.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "简介过长");
        }
        if (StringUtils.isNotBlank(content) && introduction.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
    }

    @Override
    public List<ArticleVO> queryArticle(String fieldName, Articleinfo articleinfo) throws IllegalAccessException {

        System.out.println(fieldName);
        if (StringUtils.isBlank(fieldName)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Class<Articleinfo> articleinfoClass = Articleinfo.class;
        Field[] articleinfoClassDeclaredFields = articleinfoClass.getDeclaredFields();
        String value = "";
        for (Field field : articleinfoClassDeclaredFields) {
            if (fieldName.equals(field.getName())) {
                field.setAccessible(true);
                value = field.get(articleinfo).toString();
            }
        }
        System.out.println(value);


        
        if(StringUtils.isAnyBlank(value)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<Articleinfo> articleinfoQueryWrapper = new QueryWrapper<>();
        articleinfoQueryWrapper.eq(fieldName,value);
        List<Articleinfo> articleinfoList = articleinfoMapper.selectList(articleinfoQueryWrapper);
        List<ArticleVO> articleVOList = new ArrayList<>();
        for(Articleinfo articleinfo_ : articleinfoList){
            ArticleVO articleVO = new ArticleVO();
            BeanUtils.copyProperties(articleinfo_,articleVO);
            articleVOList.add(articleVO);
        }
        return articleVOList;

    }
}




