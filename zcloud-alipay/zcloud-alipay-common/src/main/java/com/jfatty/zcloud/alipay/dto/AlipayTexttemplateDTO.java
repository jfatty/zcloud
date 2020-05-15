package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
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
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *模板名称
     */
    @ApiModelProperty(name = "templateName", position = 0, required = true, value = "模板名称",example = "音频模板消息")
    private String templateName;
    /**
     *模板内容
     */
    @ApiModelProperty(name = "templateContent", position = 0, required = true, value = "模板内容",example = "你好那 大千世界")
    private String templateContent;
    /**
     *微信企业账户id
     */
    @ApiModelProperty(name = "accountid", position = 0, required = true, value = "账户id",example = "20109292929")
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
