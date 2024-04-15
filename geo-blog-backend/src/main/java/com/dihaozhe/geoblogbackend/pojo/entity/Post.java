package com.dihaozhe.geoblogbackend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (Post)实体类
 *
 * @author 邸浩哲
 *
 */
@Data
@TableName(value ="tb_post")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 2934536775655113536L;

    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 文章地址
     */
    private String postUrl;

    /**
     * 阅读数量
     */
    private Long readNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否删除
     */
    private Integer isDeleted;

}