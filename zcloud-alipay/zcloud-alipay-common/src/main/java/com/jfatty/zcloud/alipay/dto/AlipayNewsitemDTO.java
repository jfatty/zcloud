package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
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
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *标题
     */
    @ApiModelProperty(name = "title", position = 0, required = true, value = "标题",example = "图文素材")
    private String title;
    /**
     *作者
     */
    @ApiModelProperty(name = "author", position = 0, required = true, value = "作者",example = "李白")
    private String author;
    /**
     *图片路径
     */
    @ApiModelProperty(name = "imagePath", position = 0,  value = "图片路径",example = "http://www/img.png")
    private String imagePath;
    /**
     *内容
     */
    @ApiModelProperty(name = "content", position = 0, required = true, value = "图文消息内容",example = "内容")
    private String content;
    /**
     *图文模板id
     */
    @ApiModelProperty(name = "templateid", position = 0, required = true, value = "图文模板id",example = "8i8u8u8i87yt76")
    private String templateid;
    /**
     *摘要
     */
    @ApiModelProperty(name = "description", position = 0, required = true, value = "图文模板消息摘要",example = "这是摘要")
    private String description;
    /**
     *新闻顺序
     */
    @ApiModelProperty(name = "orderNo", position = 0, required = true, value = "新闻顺序",example = "12")
    private String orderNo;
    /**
     *消息内容的url
     */
    @ApiModelProperty(name = "url", position = 0,  value = "消息内容的url",example = "12")
    private String url;
    /**
     *活动id
     */
    @ApiModelProperty(name = "hdid", position = 0,  value = "活动id",example = "QAWSWSWQA12")
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
