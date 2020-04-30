package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * 描述 支付宝自动回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayAutoresponseDTO<T extends BaseDTO> extends BaseDTO {

    /**
     *id
     */
    private String id;
    /**
     *关键字
     */
    private String keyWord;
    /**
     *回复内容
     */
    private String resContent;
    /**
     *消息类型
     */
    private String msgType;
    /**
     *模板名称
     */
    private String templateName;
    /**
     *微信账号id
     */
    private String accountid;
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

}
