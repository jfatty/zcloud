package com.jfatty.zcloud.wechat.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述 微信文章
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
@Data
public class MsgArticle implements Serializable {


    /**
     * 主键ID
     */
    private String arId;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 内容
     */
    private String content;

    private String digest;

    private Integer showCoverPic;

    private String url;

    private String thumbMediaId;

    private String contentSourceUrl;

    private String mediaId;

    private String newsId;

    private Integer newsIndex;

    private String picUrl;

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
