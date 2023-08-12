package com.yifan.blogbackend;

import com.yifan.blogbackend.mapper.ArticleinfoMapper;
import com.yifan.blogbackend.model.entity.Articleinfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogBackendApplicationTests {

    @Resource
    private ArticleinfoMapper articleinfoMapper;


    @Test
    void contextLoads() {
        Articleinfo articleinfo = articleinfoMapper.selectById(1);
        System.out.println(articleinfo.toString());
    }



}
