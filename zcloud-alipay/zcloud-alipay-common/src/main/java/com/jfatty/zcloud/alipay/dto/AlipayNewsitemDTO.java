package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * 描述 图文素材新闻
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayNewsitemDTO<T extends BaseDTO> extends BaseDTO {

    /**
     *id
     */
    private String id;
    /**
     *标题
     */
    private String title;
    /**
     *作者
     */
    private String author;
    /**
     *图片路径
     */
    private String imagePath;
    /**
     *内容
     */
    private String content;
    /**
     *图文模板id
     */
    private String templateid;
    /**
     *摘要
     */
    private String description;
    /**
     *新闻顺序
     */
    private String orderNo;
    /**
     *消息内容的url
     */
    private String url;
    /**
     *活动id
     */
    private String hdid;
    /**
     *创建人名称
     */
    private String createName;
    /**
     *创建人登录名称
     */
    private String createBy;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新人名称
     */
    private String updateName;
    /**
     *更新人登录名称
     */
    private String updateBy;
    /**
     *更新日期
     */
    private Date updateDate;

}
