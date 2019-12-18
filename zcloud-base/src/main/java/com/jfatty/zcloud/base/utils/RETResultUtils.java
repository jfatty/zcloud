package com.jfatty.zcloud.base.utils;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
public class RETResultUtils<T> implements Serializable {

    public static final String SUCCESS = "SUCCESS" ;

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T obj ;

    public RETResultUtils() {

    }


    public RETResultUtils(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RETResultUtils success() {
        return new RETResultUtils(200, SUCCESS, null);
    }

    public static RETResultUtils success(String msg) {
        return new RETResultUtils(200, msg, null);
    }


    public RETResultUtils(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;

    }

    public RETResultUtils(T obj) {
        this.code = 200;
        this.msg = "OK";
        this.obj = obj;
    }

    public Boolean isOK() {
        return this.code == 200;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
