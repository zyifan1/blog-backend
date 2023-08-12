package com.yifan.blogbackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章信息表
 * @TableName articleInfo
 */
@TableName(value ="articleInfo")
@Data
public class Articleinfo implements Serializable {
    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Integer articleID;

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

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除（0-删除，1-存在）
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}