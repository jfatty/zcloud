package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


/**
 * <p>
 * 智慧医疗页面配置信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-30
 */
@Data
@TableName("hospital_page_settings")
public class HOSPageSettings extends Model<HOSPageSettings> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 应用ID APPID
     */
    private String appid;

    /**
     * 医院名称
     */
    private String hosName;

    /**
     * 医院口号标语
     */
    private String hosSlogan;

    /**
     * 医院logoUrl地址
     */
    private String hosLogoUrl;

    /**
     * 医院logo二进制文件
     */
    private byte[] hosLogoImg;

    /**
     * 技术支持方名称
     */
    private String techSupport;

    /**
     * 技术支持服务电话
     */
    private String techSupportPhone;

    /**
     * 技术支持官网地址
     */
    private String techSupportWww;

    /**
     * 图标 类型 0 表示图片地址 1 表示二进制文件
     */
    private Integer iconType;

    /**
     * 配置描述
     */
    private String description;

    /**
     * 地址
     */
    private String address;

    /**
     * 激活状态地址图标地址
     */
    private String actAddressIconUrl;

    /**
     * 地址图标地址
     */
    private String addressIconUrl;

    /**
     * 激活状态电话图标二进制文件
     */
    private byte[] actAddressIconImg;
    /**
     * 电话图标二进制文件
     */
    private byte[] addressIconImg;

    /**
     * 电话
     */
    private String phone;

    /**
     * 激活状态电话图标地址
     */
    private String actPhoneIconUrl;
    /**
     * 电话图标地址
     */
    private String phoneIconUrl;

    /**
     * 激活状态电话图标二进制
     */
    private byte[] actPhoneIconImg;
    /**
     * 电话图标二进制
     */
    private byte[] phoneIconImg;

    /**
     * 菜单版本
     */
    private String version;

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
