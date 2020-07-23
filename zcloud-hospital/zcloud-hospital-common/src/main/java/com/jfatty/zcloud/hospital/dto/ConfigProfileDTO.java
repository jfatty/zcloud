package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 描述 慧医疗系统配置配置
 * @author jfatty on 2020/5/20
 * @email jfatty@163.com
 */
@Data
public class ConfigProfileDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 应用ID APPID
     */
    @ApiModelProperty(name = "appid", position = 1, required = true, value = "应用ID APPID" , example = "wxe3336a60d2685379")
    private String appid;

    /**
     * 医院ID
     */
    @ApiModelProperty(name = "hospitalId", position = 0, value = "医院 ID",required = true,example = "30646")
    private String hospitalId;

    /**
     * 智慧医疗中是否启用电子健康卡0表示未启用1表示启用
     */
    @ApiModelProperty(name = "healthCardEnable", position = 0, value = "智慧医疗中是否启用电子健康卡0表示未启用1表示启用",required = true,example = "0",allowableValues = "0,1")
    private Integer healthCardEnable;

    /**
     * 医院名名称
     */
    @ApiModelProperty(name = "hospitalName", position = 0, value = "医院名名称",required = true,example = "中医院")
    private String hospitalName;

    /**
     * 医院智慧医疗 二级域名
     */
    @ApiModelProperty(name = "hospitalDomain", position = 0, value = "医院智慧医疗 二级域名",required = true,example = "sec.jfatty.com")
    private String hospitalDomain;


    @ApiModelProperty(name = "publicIp", position = 0, value = "二级域名对应公网IP",required = true,example = "sec.jfatty.com")
    private String publicIp;

     /**
     * 对接各服务器调用地址
     */
     @ApiModelProperty(name = "serverUrl", position = 0, value = "对接各服务器调用地址",required = true,example = "http://sec.jfatty.com/827728728/gateway")
    private String serverUrl;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", position = 7 , value = "备注或者描述" ,example = "这是描述")
    private String description;


}
