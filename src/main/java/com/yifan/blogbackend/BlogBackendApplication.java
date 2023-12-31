package com.yifan.blogbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yifan.blogbackend.mapper")
//@EnableElasticsearchRepositories(basePackages = "com.yifan.blogbackend.esdao")
public class BlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendApplication.class, args);
    }

}
