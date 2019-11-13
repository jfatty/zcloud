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
    private Integer status;

    // 响应消息
    private String msg;

    //渲染模板
    private Boolean rel ;

    private Integer count ;

    // 响应中的数据
    private List<T> list;

    public RELResultUtils() {

    }

    public RELResultUtils(Integer status, String msg, List<T> list) {
        this.status = status;
        this.msg = msg;
        this.list = list;
        if (list != null) {
            this.count = list.size();
            this.rel = (list.size() > 0);
        } else {
            this.count = 0;
            this.rel = false;
        }

    }

    public RELResultUtils(Integer status, String msg, List<T> list, Integer count) {
        this.status = status;
        this.msg = msg;
        this.list = list;
        this.count = count==null?0:count;
        if (list != null) {
            this.rel = (count > 0);
        } else {
            this.rel = false;
        }

    }

    public RELResultUtils(List<T> list) {
        this.status = 200;
        this.msg = "OK";
        this.list = list;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
