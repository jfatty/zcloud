package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * 描述 关注回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayGzentityDTO<T extends BaseDTO> extends BaseDTO {

    /**
     *id
     */
    private String id;
    /**
     *模板名称
     */
    private String templateName;
    /**
     *模板id
     */
    private String templateId;
    /**
     *类型 文本_text,图文_news
     */
    private String templateType;
    /**
     *是否启用 未启用_0,启用_1
     */
    private String isWork;
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
