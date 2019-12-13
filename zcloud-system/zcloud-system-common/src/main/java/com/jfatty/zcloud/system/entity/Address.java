package com.jfatty.zcloud.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 公用地址表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Data
@TableName("sys_address")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID页面页面标识唯一
     */
    private String id;

    /**
     * 所属人ID
     */
    private String belongId;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市州
     */
    private String city;

    /**
     * 区县
     */
    private String area;

    /**
     * 乡
     */
    private String ownship;

    /**
     * 村
     */
    private String village;

    /**
     * 户籍
     */
    private String household;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 地址类型
     */
    private String addrType;

    /**
     * 描述备注
     */
    private String description;

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
