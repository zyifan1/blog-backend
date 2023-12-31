package com.yifan.blogbackend.controller;


import com.yifan.blogbackend.common.BaseResponse;
import com.yifan.blogbackend.common.ErrorCode;
import com.yifan.blogbackend.common.ResultUtils;
import com.yifan.blogbackend.exception.BusinessException;
import com.yifan.blogbackend.exception.ThrowUtils;
import com.yifan.blogbackend.model.dto.article.ArticleAddRequest;
import com.yifan.blogbackend.model.dto.article.ArticleQueryRequest;
import com.yifan.blogbackend.model.dto.article.ArticleUpdateRequest;
import com.yifan.blogbackend.model.entity.Articleinfo;
import com.yifan.blogbackend.model.vo.ArticleVO;
import com.yifan.blogbackend.service.ArticleinfoService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {


    @Resource
    private ArticleinfoService articleinfoService;


    /**
     * 创建文章
     *
     * @param articleAddRequest
     * @param request
     */
    @PostMapping("/addArticle")
    public BaseResponse<Long> addArticle(@RequestBody ArticleAddRequest articleAddRequest, HttpServletRequest request) {
        if (articleAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Articleinfo articleinfo = new Articleinfo();
        BeanUtils.copyProperties(articleAddRequest, articleinfo);

        articleinfoService.validArticle(articleinfo, true);

        boolean result = articleinfoService.save(articleinfo);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long articleID = articleinfo.getArticleID();
        return ResultUtils.success(articleID);
    }


    /**
     * 查询文章
     *
     * @param articleQueryRequest
     * @param request
     * @return
     * @throws IllegalAccessException
     */
    @PostMapping("/queryArticle")
    public BaseResponse<List<ArticleVO>> queryArticle(@RequestBody ArticleQueryRequest articleQueryRequest, HttpServletRequest request) throws IllegalAccessException {
        if (articleQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Articleinfo articleinfo = new Articleinfo();
        BeanUtils.copyProperties(articleQueryRequest, articleinfo);
        System.out.println(articleQueryRequest);
        List<ArticleVO> articleVOList = articleinfoService.queryArticle(articleQueryRequest.getQueryField(), articleinfo);


        return ResultUtils.success(articleVOList);
    }


    /**
     * 查询所有文章
     *
     * @param request
     * @return
     */
    @PostMapping("/queryAllArticle")
    public BaseResponse<List<ArticleVO>> queryAllArticle(HttpServletRequest request) {
        List<ArticleVO> articleVOList = new ArrayList<>();
        articleinfoService.list().forEach(item -> {
            ArticleVO articleVO = new ArticleVO();
            BeanUtils.copyProperties(item, articleVO);
            articleVOList.add(articleVO);
        });
        articleVOList.forEach(System.out::println);
        return ResultUtils.success(articleVOList);
    }


    /**
     * 修改文章
     *
     * @param articleUpdateRequest
     * @param request
     * @return
     */
    @PostMapping("/updateArticle")
    public BaseResponse<Boolean> updateArticle(@RequestBody ArticleUpdateRequest articleUpdateRequest, HttpServletRequest request) {
        if (articleUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Articleinfo articleinfo = new Articleinfo();
        BeanUtils.copyProperties(articleUpdateRequest, articleinfo);

        //参数校验
        articleinfoService.validArticle(articleinfo, false);

        Long oldId = articleUpdateRequest.getId();
        Articleinfo oldArticle = articleinfoService.getById(oldId);
        ThrowUtils.throwIf(oldArticle == null, ErrorCode.NOT_FOUND_ERROR);
        boolean result = articleinfoService.updateById(articleinfo);

        return ResultUtils.success(result);
    }


    @PostMapping("/getById/vo")
    public BaseResponse<ArticleVO> getArticleVOById(long id, HttpServletRequest request) {
        if (StringUtils.isBlank(String.valueOf(id))) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Articleinfo articleinfo = articleinfoService.getById(id);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(articleinfo, articleVO);
        return ResultUtils.success(articleVO);
    }


}
