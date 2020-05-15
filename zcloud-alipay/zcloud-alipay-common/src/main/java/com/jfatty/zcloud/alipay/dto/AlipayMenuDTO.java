package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述 支付宝菜单
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayMenuDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *菜单标题
     */
    @ApiModelProperty(name = "menuName", position = 0, required = true, value = "菜单标题",example = "公司官网")
    private String menuName;
    /**
     * 菜单标识
     */
    @ApiModelProperty(name = "menuKey", position = 0, required = true, value = "菜单标识",example = "www")
    private String menuKey;
    /**
     *菜单类型
     */
    @ApiModelProperty(name = "menuType", position = 0, required = true, value = "菜单类型",example = "button")
    private String menuType;
    /**
     *菜单位置
     */
    @ApiModelProperty(name = "orders", position = 0, required = true, value = "菜单位置",example = "0")
    private String orders;
    /**
     *响应消息类型
     */
    @ApiModelProperty(name = "msgType", position = 0, required = true, value = "响应消息类型",example = "text")
    private String msgType;
    /**
     *关联素材ID
     */
    @ApiModelProperty(name = "templateId", position = 0,  value = "关联素材ID",example = "ZAQCDEFGERR14266255251625162")
    private String templateId;
    /**
     *网页链接
     */
    @ApiModelProperty(name = "url", position = 0,  value = "网页链接",example = "ZAQCDEFGERR14266255251625162")
    private String url;
    /**
     *父ID
     */
    @ApiModelProperty(name = "fatherId", position = 0,  value = "父ID",example = "3w22321qq11")
    private String fatherId;
    /**
     *创建人名称
     */
    private String createName;
    /**
     *创建人登录名称
     */
    private String createBy;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新人名称
     */
    private String updateName;
    /**
     *更新人登录名称
     */
    private String updateBy;
    /**
     *更新日期
     */
    private Date updateDate;

    private String agentId ;

}
