-- 文章信息表
create table if not exists `articleInfo`
(
    `articleID` int not null auto_increment comment '文章id' primary key,
    `title` varchar(256) not null comment '文章标题',
    `introduction` tinytext not null comment '文章简介',
    `content` text not null comment '文章内容',
    `label` varchar(256) null comment '文章标签',
    `createTime` datetime not null comment '创建时间',
    `updateTime` datetime not null on update CURRENT_TIMESTAMP comment '修改时间',
    `isDelete` int default 0  not null DEFAULT CURRENT_TIMESTAMP comment '是否删除（0-删除，1-存在）'
) comment '文章信息表';

