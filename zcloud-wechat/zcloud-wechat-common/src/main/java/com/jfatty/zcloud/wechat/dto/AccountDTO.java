package com.jfatty.zcloud.wechat.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 微信账号
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AccountDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 名称
     */
    @ApiModelProperty(name = "name", position = 1 , value = "名称" , required = true , example = "龙山大医院" )
    private String name;

    /**
     * 原始ID
     */
    @ApiModelProperty(name = "account", position = 1 , value = "原始ID" , required = true , example = "gh_askeioewoi" )
    private String account;

    /**
     * 开发者ID
     */
    @ApiModelProperty(name = "appid", position = 1 , value = "开发者ID" , required = true , example = "wxwxaskeioewoi" )
    private String appid;

    /**
     * 开发者密码
     */
    @ApiModelProperty(name = "appsecret", position = 1 , value = "开发者密码" , required = true , example = "wxwxaskeioewoissaawswsww33" )
    private String appsecret;

    /**
     * 服务器地址(URL)
     */
    @ApiModelProperty(name = "url", position = 1 , value = "服务器地址(URL)" , required = true , example = "微信服务器回调地址" )
    private String url;

    /**
     * 令牌(Token)
     */
    @ApiModelProperty(name = "token", position = 1 , value = "令牌(Token)" , required = true , example = "ijusjuhjjkuiwu5854" )
    private String token;

    /**
     * 微信号
     */
    @ApiModelProperty(name = "wxAccount", position = 1 , value = "微信号" , required = true , example = "hfx@163.com" )
    private String wxAccount;

    /**
     * AccessToken
     */
    @ApiModelProperty(name = "accessToken", position = 1 , value = "AccessToken" ,  example = "wkkskk8838j" )
    private String accessToken;

    /**
     * 消息条数
     */
    @ApiModelProperty(name = "msgCount", position = 1 , value = "消息条数" ,  example = "5" )
    private Integer msgCount;

    /**
     * 描述
     */
    @ApiModelProperty(name = "description", position = 1 , value = "描述" ,  example = "微信账号相关描述" )
    private String description;

    /**
     * 消息加解密密钥(EncodingAESKey)
     */
    @ApiModelProperty(name = "encodingaesKey", position = 1 , value = "消息加解密密钥(EncodingAESKey)" ,  example = "QIEJHDHJNJDKWOWJSUI0" )
    private String encodingaesKey;

    /**
     * 公众号类型 订阅号 企业号 服务号 小程序
     */
    @ApiModelProperty(name = "type", position = 1 , value = "公众号类型 订阅号 企业号 服务号 小程序" ,  example = "服务号" )
    private String type;

    /**
     * 电子邮箱,登录邮箱
     */
    @ApiModelProperty(name = "email", position = 1 , value = "电子邮箱,登录邮箱" ,  example = "zealsoft@qq.com" )
    private String email;

    /**
     * 该微信账号的管理员
     */
    @ApiModelProperty(name = "manager", position = 1 , value = "该微信账号的管理员" ,  example = "admin" )
    private String manager;

    /**
     * 数据字典对应字段数据交互类型json，xml
     */
    @ApiModelProperty(name = "dataType", position = 1 , value = "数据字典对应字段数据交互类型json，xml" ,  example = "json",allowableValues = "jason,xml")
    private String dataType;

    /**
     * 管理员联系方式
     */
    @ApiModelProperty(name = "managerContact", position = 1 , value = "管理员联系方式" ,  example = "1558745099")
    private String managerContact;

    /**
     * 使用状态
     */
    @ApiModelProperty(name = "state", position = 11,required = true,value = "正常使用 1 停用 0 使用状态" , example = "1" ,allowableValues = "0,1")
    private Integer state;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;



}
