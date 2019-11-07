package com.jfatty.zcloud.wechat.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 微信推送消息表
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Data
public class MsgNews  extends MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单图文多图文类型
     * 1单图文2多图文类
     */
    private String multType;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 简介
     */
    private String brief;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片路径
     */
    private String picPath;

    /**
     * 是否显示图片
     */
    private Integer showPic;

    /**
     * URL地址
     */
    private String url;

    /**
     * 源URL
     */
    private String fromUrl;

    /**
     * 基础ID
     */
    private String baseId;

    /**
     * 上传后返回的媒体素材id
     */
    private String mediaId;

    /**
     * 封面图片id
     */
    private String thumbMediaId;

    /**
     * 多图文中的第几条
     */
    private Integer newsIndex;

    private Integer opencomment;//是否打开评论，0不打开，1打开
    private Integer fanscancomment;//是否粉丝才可评论，0所有人可评论，1粉丝才可评论
    private String start;
    private String end;
    //一对多
    private List<MsgArticle> articles;

}
