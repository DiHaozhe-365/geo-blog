package com.dihaozhe.geoblogbackend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * (Account)实体类
 *
 * @author 邸浩哲
 *
 */
@Data
@TableName("tb_account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1234676655605848537L;
    /**
     * 账号id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

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
