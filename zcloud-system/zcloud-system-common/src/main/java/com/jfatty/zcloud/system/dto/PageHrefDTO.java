package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2020/1/1
 * @email jfatty@163.com
 */
@Data
public class PageHrefDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 应用ID APPID
     */
    private String appid;

    /**
     * 页面标识ID
     */
    private String pageId;

    /**
     * 页面标签ID 或者是唯一确定元素
     */
    private String elemId;

    /**
     * 图片标题
     */
    private String elemTitle;

    /**
     * 链接显示类型 按钮或者a标签
     */
    private String elemType;

    /**
     * 目标地址
     */
    private String targetHref;

    /**
     * 设置字段 根据需求使用本字段
     */
    private String site;

    /**
     * 备注或者描述
     */
    private String description;



}
