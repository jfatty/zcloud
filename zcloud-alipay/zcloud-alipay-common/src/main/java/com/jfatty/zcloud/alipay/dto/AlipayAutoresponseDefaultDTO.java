package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;

import java.util.Date;

/**
 * 描述 默认关键字回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
public class AlipayAutoresponseDefaultDTO<T extends BaseDTO> extends BaseDTO {

    /**
     *主键Id
     */
    private String id;
    /**
     *模板名称
     */
    private String templatename;
    /**
     *模板Id
     */
    private String templateid;
    /**
     *消息类型
     */
    private String msgtype;
    /**
     *微信账号Id
     */
    private String accountid;
    /**
     *是否启用
     */
    private String iswork;
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
