package com.dihaozhe.common.response;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.dihaozhe.common.enumeration.StateCode;

public record Result<T>(int code, String message, T data) {

    public static <T> Result<T> success() {
        return new Result<>(200, "ok", null);
    }

    public static <T> Result<T> success(int code) {
        return new Result<>(code, "ok", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "ok", data);
    }

    public static <T> Result<T> success(StateCode stateCode) {
        return new Result<>(stateCode.getCode(), stateCode.getMessage(), null);
    }

    public static <T> Result<T> success(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> success(int code, T data) {
        return new Result<>(code, "ok", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static <T> Result<T> success(StateCode stateCode, T data) {
        return new Result<>(stateCode.getCode(), stateCode.getMessage(), data);
    }

    public static <T> Result<T> success(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> failure(StateCode stateCode) {
        return new Result<>(stateCode.getCode(), stateCode.getMessage(), null);
    }

    public static <T> Result<T> unauthorized(String message) {
        return new Result<>(401, message, null);
    }

    public static <T> Result<T> forbidden(String message) {
        return new Result<>(403, message, null);
    }

    public String toJSON() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }

}
