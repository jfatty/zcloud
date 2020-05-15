package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
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
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *关键字
     */
    @ApiModelProperty(name = "keyWord", position = 0, required = true, value = "关键字",example = "你好")
    private String keyWord;
    /**
     *回复内容
     */
    @ApiModelProperty(name = "resContent", position = 0, required = true, value = "回复内容",example = "尊敬的用户您好,感谢你的关注")
    private String resContent;
    /**
     *消息类型
     */
    @ApiModelProperty(name = "msgType", position = 0, required = true, value = "消息类型",example = "text")
    private String msgType;
    /**
     *模板名称
     */
    @ApiModelProperty(name = "templateName", position = 0, required = true, value = "模板名称",example = "关注消息回复")
    private String templateName;
    /**
     *账号id
     */
    @ApiModelProperty(name = "accountid", position = 0, required = true, value = "账号id",example = "20991928282992")
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
