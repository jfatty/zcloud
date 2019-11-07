package com.jfatty.zcloud.base.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述 页面权限树 封装
 * @author jfatty
 * 创建时间：2018年5月16日
 */
public class SystemTree implements Serializable {


    /**
     * 描述
     * @author jfatty
     * 创建时间：2018年5月16日
     */
    private static final long serialVersionUID = 2742842830572764973L;

    //{ title: "节点1.1", checked: true, disabled: true, value: "jd1.1", data: [] }

    private String title ;

    private String value ;

    private Boolean checked = false ;

    private Boolean disabled = false ;

    private List<SystemTree> data = new ArrayList<SystemTree>() ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<SystemTree> getData() {
        return data;
    }

    public void setData(List<SystemTree> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SystemTree [title=" + title + ", checked=" + checked + ", disabled=" + disabled + ", value=" + value + ", data=" + data + "]";
    }

}
