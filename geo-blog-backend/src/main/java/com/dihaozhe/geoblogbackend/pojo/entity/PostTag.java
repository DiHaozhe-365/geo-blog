package com.dihaozhe.geoblogbackend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (PostTag)实体类
 *
 * @author 邸浩哲
 *
 */
@TableName(value ="tb_post_tag")
@Data
public class PostTag implements Serializable {

    @Serial
    private static final long serialVersionUID = 3564514095331118555L;

    /**
     * 文章标签id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    private Long postId;

    /**
     * 标签id
     */
    private Long tagId;

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