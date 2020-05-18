package com.jfatty.zcloud.base.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
public class RETResultUtils<T> implements Serializable {

    public static final String SUCCESS = "SUCCESS" ;

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data ;

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

    public static RETResultUtils  faild(String msg) {
        return new RETResultUtils(500, msg, null);
    }

    /**
     * 506表示业务流程操作成功 回显有效提示信息
     * @param msg
     * @return
     */
    public static RETResultUtils  _506(String msg) {
        return new RETResultUtils(506, msg, null);
    }

    /**
     * 509 表示客户端 请求参数不合规 并携带提示信息
     * @param msg
     * @return
     */
    public static RETResultUtils  _509(String msg) {
        return new RETResultUtils(509, msg, null);
    }

    public static RETResultUtils  faild(Integer code,String msg) {
        return new RETResultUtils(code, msg, null);
    }

    public RETResultUtils(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }

    public RETResultUtils(String msg,T data) {
        this.code = 200;
        this.msg = msg ;
        this.data = data;
    }

    public RETResultUtils(T data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
