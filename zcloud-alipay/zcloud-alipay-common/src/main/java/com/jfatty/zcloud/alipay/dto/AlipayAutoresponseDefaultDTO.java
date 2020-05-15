package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 描述 默认关键字回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
public class AlipayAutoresponseDefaultDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *模板名称
     */
    @ApiModelProperty(name = "templatename", position = 0, required = true, value = "模板名称",example = "一般通知")
    private String templatename;
    /**
     *模板Id
     */
    @ApiModelProperty(name = "templateid", position = 0, required = true, value = "模板Id",example = "DEFRFSDF98938272898928932982")
    private String templateid;
    /**
     *消息类型
     */
    @ApiModelProperty(name = "msgtype", position = 0, value = "消息类型",example = "text")
    private String msgtype;
    /**
     *微信账号Id
     */
    @ApiModelProperty(name = "accountid", position = 0, value = "微信账号Id",example = "20200293398483992")
    private String accountid;
    /**
     *是否启用
     */
    @ApiModelProperty(name = "iswork", position = 0, value = "是否启用",example = "1")
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
