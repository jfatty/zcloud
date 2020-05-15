package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述 图文素材模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayNewstemplateDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *模板名称
     */
    @ApiModelProperty(name = "templateName", position = 0, required = true, value = "模板名称",example = "图文素材模板名称")
    private String templateName;
    /**
     *模板类型
     */
    @ApiModelProperty(name = "templateType", position = 0, required = true, value = "模板类型",example = "img")
    private String templateType;
    /**
     *微信企业号账号id
     */
    @ApiModelProperty(name = "accountid", position = 0, required = true, value = "账号id",example = "3839829287717")
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
