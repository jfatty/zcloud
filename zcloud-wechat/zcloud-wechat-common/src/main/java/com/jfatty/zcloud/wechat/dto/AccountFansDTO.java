package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 描述 微信粉丝
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AccountFansDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    @ApiModelProperty(name = "openId", position = 12 , value = "微信用户唯一识别" , example = "wx2658459965445" )
    private String openId;


    @ApiModelProperty(name = "subscribeStatus", position = 12 , value = "微信用户订阅状态" , example = "wx2658459965445" )
    private Integer subscribeStatus;


    @ApiModelProperty(name = "subscribeTime", position = 13 , value = "订阅时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso= DateTimeFormat.ISO.DATE_TIME)
    private Date subscribeTime;//订阅时间

    /**
     * 昵称,二进制保存emoji表情
     */
    private byte[] nickName;

    @ApiModelProperty(name = "nicknameStr", position = 12 , value = "昵称显示" , example = "灵活的" )
    private String nicknameStr;//昵称显示

    @ApiModelProperty(name = "gender", position = 12 , value = "微信用户显示性别0：未知、1：男、2：女" , example = "1" )
    private Integer gender;

    @ApiModelProperty(name = "language", position = 12 , value = "微信交流使用语言" , example = "简体中文" )
    private String language;

    @ApiModelProperty(name = "country", position = 12 , value = "微信账号所在国家" , example = "中国" )
    private String country;

    @ApiModelProperty(name = "province", position = 12 , value = "微信账号所在省份" , example = "湖北" )
    private String province;

    @ApiModelProperty(name = "city", position = 12 , value = "微信账号所在城市" , example = "武汉" )
    private String city;

    @ApiModelProperty(name = "headImgUrl", position = 12 , value = "头像地址" , example = "http://img/avtar/1.png" )
    private String headImgUrl;

    @ApiModelProperty(name = "remark", position = 12 , value = "备注说明" , example = "微信粉丝备注" )
    private String remark;

    /**
     * 微信原始ID
     */
    @ApiModelProperty(name = "account", position = 12 , value = "微信原始ID" ,required = true , example = "gh_sjsijaijhishaiai" )
    private String account;

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

    /**
     * 更新人
     */
    @ApiModelProperty(name = "updateOperator", position = 12 , value = "更新人" , example = "张三" )
    private String updateOperator;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "updateTime", position = 13 , value = "更新时间" ,allowableValues = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public String getNicknameStr() {
        if(this.getNickName() != null){
            try {
                this.nicknameStr = new String(this.getNickName(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return nicknameStr;
    }

}
