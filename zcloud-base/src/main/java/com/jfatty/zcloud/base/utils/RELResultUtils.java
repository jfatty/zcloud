package com.jfatty.zcloud.base.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 描述 自定义响应结构
 *
 * @author jfatty on 2019/11/12
 * @email jfatty@163.com
 */
public class RELResultUtils <T> implements Serializable {

    /**
     * 描述
     * @author jfatty
     * 创建时间：2018年5月1日
     */
    private static final long serialVersionUID = 4676782472415788129L;

    public static final String SUCCESS = "SUCCESS" ;

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    //渲染模板
    private Boolean rel ;

    private Integer count ;

    // 响应中的数据
    private List<T> data;


    public static RELResultUtils  faild(String msg) {
        return new RELResultUtils(500, msg, null);
    }

    /**
     * 506表示业务流程操作成功 回显有效提示信息
     * @param msg
     * @return
     */
    public static RELResultUtils  _506(String msg) {
        return new RELResultUtils(506, msg, null);
    }

    /**
     * 509 表示客户端 请求参数不合规 并携带提示信息
     * @param msg
     * @return
     */
    public static RELResultUtils  _509(String msg) {
        return new RELResultUtils(509, msg, null);
    }

    public static RELResultUtils  faild(Integer code,String msg) {
        return new RELResultUtils(code, msg, null);
    }



    public RELResultUtils() {

    }

    public static RELResultUtils success() {
        return new RELResultUtils(200, SUCCESS, null);
    }

    public static RELResultUtils success(String msg) {
        return new RELResultUtils(200, msg, null);
    }


    public RELResultUtils(Integer code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        if (data != null) {
            this.count = data.size();
            this.rel = (data.size() > 0);
        } else {
            this.count = 0;
            this.rel = false;
        }

    }

    public RELResultUtils(Integer code, String msg, List<T> data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count == null?0:count;
        if (data != null) {
            this.rel = (count > 0);
        } else {
            this.rel = false;
        }

    }

    public RELResultUtils(List<T> data) {
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

    public Boolean getRel() {
        return rel;
    }

    public void setRel(Boolean rel) {
        this.rel = rel;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
