package com.dihaozhe.common.enumeration;

import lombok.Getter;

/**
 * 全局状态码
 *
 * @author 邸浩哲
 */
@Getter
public enum StateCode {

    /**
     * 正确相关状态码
     */
    SUCCESS(200,"ok"),

    /**
     * 错误相关状态码
     */
    PARAMS_ERROR(400,"请求参数错误"),
    NULL_ERROR(400,"请求数据为空"),
    USERNAME_EMPTY(400,"账号不能为空"),
    PASSWORD_EMPTY(400,"密码不能为空"),
    CHECK_PASSWORD_EMPTY(400,"确认密码不能为空"),
    PASSWORD_NOT_EQUAL(400,"两次密码不相同"),

    USERNAME_EXIST(400,"账号已存在"),
    LOGIN_FAILED(400,"账号或密码错误"),
    NOT_LOGIN_ERROR(401,"未登录"),
    NO_AUTH_ERROR(401,"无权限"),
    SYSTEM_ERROR(50000,"系统内部异常");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String message;

    StateCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
