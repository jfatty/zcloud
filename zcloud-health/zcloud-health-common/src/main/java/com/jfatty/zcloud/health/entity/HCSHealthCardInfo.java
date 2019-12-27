package com.jfatty.zcloud.health.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
@TableName("hcs_health_card_info")
public class HCSHealthCardInfo extends Model<HCSHealthCardInfo>  {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 民族
     */
    private String nation;

    /**
     * 出生年月日
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系方式1
     */
    private String phone1;

    /**
     * 联系方式2
     */
    private String phone2;

    /**
     * 院内ID
     */
    private String patid;

    /**
     * 微信身份码
     */
    private String wechatCode;

    /**
     * 健康卡主索引
     */
    private String phid;

    /**
     * 二维码文本
     */
    private String qrCodeText;

    /**
     * 健康卡ID
     */
    private String healthCardId;

    /**
     * 扩展字段
     */
    private String adminExt;

    /**
     * 使用状态0表示正常使用-1表示维护中-2表示建设中...
     */
    private Integer status;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 域值
     */
    private String realm;

    /**
     * 创建人
     */
    private String createOperator;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

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

    /**
     * 删除状态0表示非删除状态1表示数据已经删除
     */
    private Integer deleteState;

    /**
     * 删除时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteTime;

    /**
     * 删除操作者
     */
    private String deleteOperator;

}
