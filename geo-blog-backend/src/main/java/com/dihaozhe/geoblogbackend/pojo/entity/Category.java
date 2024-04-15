package com.dihaozhe.geoblogbackend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (Category)实体类
 *
 * @author 邸浩哲
 *
 */
@Data
@TableName(value ="tb_category")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1934536685665818537L;

    /**
     * 分类id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    private String name;

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