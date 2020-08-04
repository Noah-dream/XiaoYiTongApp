package com.xiaoyitong.app.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class ServerResponse<T> implements Serializable {

    private int stauts;
    private String msg;
    private T data;

    private ServerResponse(int stauts) {
        this.stauts = stauts;
    }

    private ServerResponse(int stauts, T data) {
        this.stauts = stauts;
        this.data = data;
    }

    private ServerResponse(int stauts, String msg) {
        this.stauts = stauts;
        this.msg = msg;
    }

    private ServerResponse(int stauts, String msg, T data) {
        this.stauts = stauts;
        this.msg = msg;
        this.data = data;
    }

    /**
     * json忽略
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.stauts == ResponseCode.SUCCESS.getCode();
    }

    public int getStauts() {
        return stauts;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }
    public static <T> ServerResponse<T> refuseCreate(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
