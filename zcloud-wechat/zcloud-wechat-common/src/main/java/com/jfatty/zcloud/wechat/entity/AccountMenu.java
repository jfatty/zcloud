package com.jfatty.zcloud.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 微信菜单表
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Data
@TableName("wxcms_account_menu")
public class AccountMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    private String mtype;

    /**
     * 事件类型
     */
    private String eventType;

    private String name;

    private String inputCode;

    private String url;

    private Integer sort;

    /**
     * 父类ID
     */
    private String parentId;

    private String msgType;

    private String msgId;

    private String gid;

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
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOperator;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
