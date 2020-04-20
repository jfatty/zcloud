package com.jfatty.zcloud.health.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 电子健康卡微信用户信息
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
public class HealthCardUserDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 2,required = true, value = "微信  支付宝  APP appId" , example = "wx0725202a2fe5ffcf" )
    private String appid;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * openId类型1,2,3
     */
    private Integer openIdType;

    /**
     * 健康卡信息记录表ID
     */
    private String healthCardInfoId;

    /**
     * 微信用户姓名或者昵称
     */
    private String name;

    /**
     * 微信用户性别
     */
    private String gender;

    /**
     * 微信用户手机号码
     */
    private String phone;

    /**
     * 出生年月日
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status;


}
