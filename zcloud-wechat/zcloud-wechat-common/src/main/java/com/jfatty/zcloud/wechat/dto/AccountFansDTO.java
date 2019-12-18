package com.jfatty.zcloud.wechat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AccountFansDTO<T extends BaseDTO> extends BaseDTO {

    private String id;

    private String openId;

    private Integer subscribeStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso= DateTimeFormat.ISO.DATE_TIME)
    private Date subscribeTime;//订阅时间

    /**
     * 昵称,二进制保存emoji表情
     */
    private byte[] nickName;

    private String nicknameStr;//昵称显示

    private Integer gender;

    private String language;

    private String country;

    private String province;

    private String city;

    private String headImgUrl;

    private String remark;

    /**
     * 微信原始ID
     */
    private String account;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
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
