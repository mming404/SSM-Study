package com.ysm.springmvc.pojo;

public class RespBean<T> {
    private Integer code;
    private String message;
    private T data;

    private RespBean() {
    }

    private RespBean(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RespBean<T> ok(String message, T data) {
        return new RespBean<>(200, message, data);
    }

    public static <T>RespBean<T> error(String message, T data) {
        return new RespBean<>(300, message, data);
    }

    public static <T>RespBean<T> ok(String message) {
        return new RespBean<>(200, message, null);
    }

    public static <T>RespBean<T> error(String message) {
        return new RespBean<>(300, message, null);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }



}
