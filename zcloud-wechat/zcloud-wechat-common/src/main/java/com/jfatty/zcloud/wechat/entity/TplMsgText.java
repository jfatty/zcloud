package com.jfatty.zcloud.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * <p>
 * 微信模板消息
 * </p>
 *
 * @author jfatty
 * @since 2019-04-23
 */
@Data
@TableName("wxcms_tpl_msg_text")
public class TplMsgText extends Model<TplMsgText> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 模板ID
     */
    private String tplId;

    /**
     * 链接
     */
    private String url;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 微信模板
     */
    private String wxTpl;

    /**
     * 系统发送时的map内容
     */
    private String sendContent;

    /**
     * 基础ID
     */
    private String baseId;

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
