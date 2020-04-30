package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * 描述 文本模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayTexttemplateDTO<T extends BaseDTO> extends BaseDTO {


    /**
     *id
     */
    private String id;
    /**
     *模板名称
     */
    private String templateName;
    /**
     *模板内容
     */
    private String templateContent;
    /**
     *微信企业账户id
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
