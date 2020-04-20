package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class AccountUniqueDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;


    /**
     * 账号
     */
    @ApiModelProperty(name = "userName", position = 1 , value = "账号" , example = "admin" )
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(name = "password", position = 1 , value = "密码" , example = "123456" )
    private String password;

    /**
     * 密码的盐值
     */
    @ApiModelProperty(name = "salt", position = 1 , value = "密码的盐值" , example = "qazwsxx123456" )
    private String salt;

    /**
     * 电话号码
     */
    @ApiModelProperty(name = "tel", position = 1 , value = "电话号码" , example = "18858886888" )
    private String tel;

    /**
     * 身份证号码
     */
    @ApiModelProperty(name = "idCard", position = 1 , value = "身份证号码" , example = "110101199003078152" )
    private String idCard;

    /**
     * 电子邮箱
     */
    @ApiModelProperty(name = "email", position = 1 , value = "电子邮箱" , example = "13370451258@qq.com" )
    private String email;


    /**
     * 域值
     */
    @ApiModelProperty(name = "realm", position = 12 , value = "域值" )
    private String realm;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
