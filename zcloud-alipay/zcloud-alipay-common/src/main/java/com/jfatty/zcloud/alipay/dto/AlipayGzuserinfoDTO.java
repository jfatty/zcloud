package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述 支付宝关注用户
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AlipayGzuserinfoDTO<T extends BaseDTO> extends BaseDTO {
    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;
    /**
     *账号
     */
    @ApiModelProperty(name = "userid", position = 0, required = true, value = "账号",example = "733227729991828")
    private String userid;
    /**
     *姓名
     */
    @ApiModelProperty(name = "name", position = 0, required = true, value = "姓名",example = "笑咪咪")
    private String name;
    /**
     *部门
     */
    @ApiModelProperty(name = "department", position = 0, value = "部门",example = "笑咪咪")
    private String department;
    /**
     *职位
     */
    @ApiModelProperty(name = "position", position = 0, value = "职位",example = "经理")
    private String position;
    /**
     *电话
     */
    @ApiModelProperty(name = "mobile", position = 0, value = "电话",example = "18899998888")
    private String mobile;
    /**
     *省份
     */
    @ApiModelProperty(name = "province", position = 0, value = "省份",example = "湖南")
    private String province;
    /**
     *性别gender=1表示男，=0表示女
     */
    @ApiModelProperty(name = "gender", position = 0, value = "性别gender=1表示男，=0表示女",example = "1")
    private String gender;
    /**
     *邮箱
     */
    @ApiModelProperty(name = "email", position = 0, value = "邮箱",example = "young@163.com")
    private String email;
    /**
     *微信号
     */
    @ApiModelProperty(name = "weixinid", position = 0, value = "微信号",example = "wx163.com")
    private String weixinid;
    /**
     *头像url
     */
    @ApiModelProperty(name = "avatar", position = 0, value = "头像url",example = "wx163.com/avatar")
    private String avatar;
    /**
     *关注状态: 1=已关注，2=已冻结，4=未关注
     */
    @ApiModelProperty(name = "subscribeStatus", position = 0, value = "关注状态: 1=已关注，2=已冻结，4=未关注",example = "1")
    private String subscribeStatus;
    /**
     *关注时间
     */
    private Date subscribeTime;
    /**
     *微信账号ID
     */
    @ApiModelProperty(name = "accountid", position = 0, value = "微信账号ID",example = "wxcount@134.com")
    private String accountid;
}
