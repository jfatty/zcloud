package com.jfatty.zcloud.health.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * <p>
 * 身份证信息表
 * </p>
 *
 * @author jfatty
 * @since 2019-12-26
 */
@Data
@TableName("hcs_id_card_info")
public class HCSIDCardInfo extends Model<HCSIDCardInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 本表中本字段即为身份证号码
     */
    private String id;

    private String name;

    private String idCard ;

    private String gender;

    private String nation;

    private String birth;

    private String address;

    /**
     * 菜单描述
     */
    private String authority;

    @TableField("validDate")
    private String validDate;

    private String description;

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

    public String getIdCard() {
        return this.id;
    }
}
