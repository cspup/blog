package com.csp.common;

import org.springframework.http.HttpStatus;

/**
 * @author csp
 * @date 2021/12/16 22:00
 * @description 通用返回包装
 */
public class R<T> {

    private int status;
    private String message;
    private T data;

    public R(){
        this.status = HttpStatus.OK.value();
        this.message = "ok";
    }
    public R(int status,String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T>R<T> ok(int status,String message,T data){
        return new R<>(status,message,data);
    }

    public static <T>R<T> ok(int status,String message){
        return new R<>(status,message,null);
    }

    public static <T>R<T> ok(T data){
        return new R<>(HttpStatus.OK.value(), "ok",data);
    }


    public static <T>R<T> error(int status,String message,T data){
        return new R<>(status,message,data);
    }

    public static <T>R<T> error(int status,String message){
        return new R<>(status,message,null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
