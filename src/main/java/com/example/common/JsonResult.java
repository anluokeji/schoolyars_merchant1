package com.example.common;
/**
 *@author zf
 * 统一封装返回
 */

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    //Serializable将对象的状态保存在存储媒体中以便可以在以后重新创建出完全相同的副本
    public static final int SUCCESS=0;
    public static final int ERROR=1;
    public static final int OTHER=2;

    private int state;
    private int code;//请求头状态 成功用200 失败500
    private String message = "";
    private T data;
    private String pass="";

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getOTHER() {
        return OTHER;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public JsonResult(int state, int code, String message, T data, String pass) {
        this.state = state;
        this.code = code;
        this.message = message;
        this.data = data;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", pass='" + pass + '\'' +
                '}';
    }

    public JsonResult() {
    }
}
