package com.dihaozhe.geoblogbackend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (PostCategory)实体类
 *
 * @author 邸浩哲
 *
 */
@Data
@TableName(value ="tb_post_category")
public class PostCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1134516795635113556L;

    /**
     * 文章分类id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    private Long postId;

    /**
     * 分类id
     */
    private Long categoryId;

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