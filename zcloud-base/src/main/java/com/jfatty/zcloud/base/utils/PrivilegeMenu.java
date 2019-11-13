package com.jfatty.zcloud.base.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述 权限菜单
 * @author jfatty
 * 创建时间：2018年6月19日
 */
@Data
public class PrivilegeMenu implements Serializable {

    /**
     * 描述
     * @author jfatty
     * 创建时间：2018年6月19日
     */
    private static final long serialVersionUID = -7173953560173080419L;

    /**
     * 主键ID
     */
    @JsonIgnore
    private String id ;
    /**
     * 权限控制链接
     */
    private String href;

    /**
     * 权限图标样式
     */
    private String icon;
    /**
     * 父级权限
     */
    @JsonIgnore
    private String parentId;

    /**
     * 展开状态
     */
    private Boolean spread;
    /**
     * 权限标题名称
     */
    private String title;

    private List<PrivilegeMenu> children ;

    @Override
    public String toString() {
        return "PrivilegeMenu [id=" + id + ", href=" + href + ", icon=" + icon + ", parentId=" + parentId + ", spread=" + spread + ", title=" + title + ", children=" + children
                + "]";
    }


    public PrivilegeMenu() {
    }

    public PrivilegeMenu(String href, String icon, Boolean spread, String title) {
        this.href = href;
        this.icon = icon;
        this.spread = spread;
        this.title = title;
    }
}
