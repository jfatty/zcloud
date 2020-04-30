package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
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
     *ID
     */
    private String id;
    /**
     *菜单标题
     */
    private String menuName;
    /**
     * 菜单标识
     */
    private String menuKey;
    /**
     *菜单类型
     */
    private String menuType;
    /**
     *菜单位置
     */
    private String orders;
    /**
     *响应消息类型
     */
    private String msgType;
    /**
     *关联素材ID
     */
    private String templateId;
    /**
     *网页链接
     */
    private String url;
    /**
     *父ID
     */
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
