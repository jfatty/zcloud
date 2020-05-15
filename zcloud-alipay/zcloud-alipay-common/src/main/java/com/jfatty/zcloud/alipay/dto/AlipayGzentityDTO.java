package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
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
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *模板名称
     */
    @ApiModelProperty(name = "templateName", position = 0, required = true, value = "模板名称",example = "关注消息回复")
    private String templateName;
    /**
     *模板id
     */
    @ApiModelProperty(name = "templateId", position = 0, required = true, value = "模板id",example = "8i8u8u8i87yt76")
    private String templateId;
    /**
     *类型 文本_text,图文_news
     */
    @ApiModelProperty(name = "templateType", position = 0, required = true, value = "文本_text,图文_news",example = "text")
    private String templateType;
    /**
     *是否启用 未启用_0,启用_1
     */
    @ApiModelProperty(name = "isWork", position = 0, required = true, value = "是否启用 未启用_0,启用_1",example = "1")
    private String isWork;
    /**
     *账号id
     */
    @ApiModelProperty(name = "accountid", position = 0, required = true, value = "账号id",example = "38473748183831")
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
