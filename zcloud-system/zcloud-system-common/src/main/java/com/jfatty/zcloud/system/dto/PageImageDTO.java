package com.jfatty.zcloud.system.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
public class PageImageDTO<T extends BaseDTO> extends BaseDTO {


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
    private String imgTitle;

    /**
     * 图片对应缺标题
     */
    private String imgAlt;

    /**
     * 图片类型 0 表示图片地址 1 表示二进制文件
     */
    private Integer imgType;

    /**
     * 激活图片对应路径
     */
    private String actIconUrl;

    /**
     * 图片对应路径
     */
    private String iconUrl;

    /**
     * 设置字段 根据需求使用本字段
     */
    private String site;

    /**
     * 备注或者描述
     */
    private String description;

}
