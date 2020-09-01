package com.zkq.utils;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 15:14 2020/7/13
 */
public class RestResult<T> {
    public static final int SUCCESS = 0;
    private int code;
    private String message;
    private T data;

    public RestResult() {
    }

    public RestResult(int code) {
        this.code = code;
    }

    public RestResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RestResult<T> success() {
        return new RestResult(0);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult(0, "操作成功", data);
    }

    public static RestResult error(int code, String message) {
        return new RestResult(code, message);
    }
}
