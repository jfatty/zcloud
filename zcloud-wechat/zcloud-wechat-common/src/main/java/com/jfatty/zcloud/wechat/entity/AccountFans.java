package com.jfatty.zcloud.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 微信粉丝表
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Data
@TableName("wxcms_account_fans")
public class AccountFans extends Model<AccountFans> {

    private static final long serialVersionUID = 1L;

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

    @TableField(exist = false)
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
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
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
