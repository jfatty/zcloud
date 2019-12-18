package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.PageElementDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面标签元素开发配置携带对应字典列表响应实体")
public class PageElementMenuRes extends PageElementDTO<PageElementMenuRes> {

    /**
     * 页面标签ID 或者是唯一确定元素
     */
    private String elemId;

    /**
     * 页面标签类型 input select radio等
     */
    private String elemType;

    /**
     * 二级页面标签类型 hidden checbox 等
     */
    private String elemSecType;

    /**
     * 字典菜单ID
     */
    private String dictionaryMenu;

    /**
     * 设置字段 根据需求使用本字段
     */
    private String site;

    private List<DictionarySimRes> dicts ;
}
