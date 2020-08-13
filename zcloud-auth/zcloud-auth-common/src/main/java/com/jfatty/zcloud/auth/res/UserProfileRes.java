package com.jfatty.zcloud.auth.res;

import com.jfatty.zcloud.auth.dto.UserProfileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 用户登录信息
 *
 * @author jfatty on 2020/4/12
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "用户登录信息响应实体")
public class UserProfileRes extends UserProfileDTO<UserProfileRes> {


    //用户账号
    @ApiModelProperty(name = "account", position = 0 , value = "用户账号" , example = "admin")
    private String account ;

    //用户昵称
    @ApiModelProperty(name = "nickName", position = 0 , value = "用户昵称" , example = "大漂亮")
    private String nickName ;

    //头像地址
    @ApiModelProperty(name = "avatar", position = 0 , value = "头像地址" , example = "***/abc.png")
    private String avatar ;

    //角色 例如 超级管理员
    @ApiModelProperty(name = "role", position = 0 , value = "角色" , example = "超级管理员")
    private String role ;

    //电话
    @ApiModelProperty(name = "phone", position = 0 , value = "电话" , example = "13327110512")
    private String phone ;

    //邮箱
    @ApiModelProperty(name = "email", position = 0 , value = "邮箱" , example = "admini@163.com")
    private String email ;

    //登录设备 PC|MOBILE|APP
    @ApiModelProperty(name = "devices", position = 0 , value = "登录设备" , example = "PC|MOBILE|APP")
    private String devices ;

    @ApiModelProperty(name = "accEditState", position = 0 , value = "账号修改状态 0表示未修改还1表示已经修改" , example = "0")
    private Integer accEditState ;
}
