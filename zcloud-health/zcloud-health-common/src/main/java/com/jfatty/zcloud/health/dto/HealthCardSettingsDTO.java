package com.jfatty.zcloud.health.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
public class HealthCardSettingsDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 开放平台官网分配的appId
     */
    @ApiModelProperty(name = "appid", position = 0, value = "开放平台官网分配的appId",required = true,example = "b9b77d6b9ba46db83a7dbb158c4740c4")
    private String appid;

    @ApiModelProperty(name = "hospitalId", position = 0, value = "医院 ID",required = true,example = "30646")
    private String hospitalId;

    @ApiModelProperty(name = "appSecret", position = 0, value = "放平台官网分配的APPSECRET",required = true,example = "f0073c435d049edfb5a7f9d2a5d9044b")
    private String appSecret;

    /**
     * 其他所有接口的调用凭证
     */
    @ApiModelProperty(name = "appToken", position = 0, value = "其他所有接口的调用凭证",required = true,example = "5686d520fe95578a93b618282fexxxxx")
    private String appToken = "";

    /**
     * appToken有效时间，默认为7200秒
     */
    @ApiModelProperty(name = "expiresIn", position = 0, value = "appToken有效时间，默认为7200秒",required = true,example = "7200")
    private Integer expiresIn;

    @ApiModelProperty(name = "description", position = 0, value = "描述 备注说明",required = true,example = "****")
    private String description;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    @ApiModelProperty(name = "status", position = 0, value = "使用状态0表示正常使用-1表示维护中-2表示建设中...",example = "0",allowableValues = "0,-1,-2")
    private Integer status;


}
