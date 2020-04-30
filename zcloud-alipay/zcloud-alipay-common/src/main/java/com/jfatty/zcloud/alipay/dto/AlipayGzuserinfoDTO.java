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
    private String userid;
    /**
     *姓名
     */
    private String name;
    /**
     *部门
     */
    private String department;
    /**
     *职位
     */
    private String position;
    /**
     *电话
     */
    private String mobile;
    /**
     *省份
     */
    private String province;
    /**
     *性别gender=1表示男，=0表示女
     */
    private String gender;
    /**
     *邮箱
     */
    private String email;
    /**
     *微信号
     */
    private String weixinid;
    /**
     *头像url
     */
    private String avatar;
    /**
     *关注状态: 1=已关注，2=已冻结，4=未关注
     */
    private String subscribeStatus;
    /**
     *关注时间
     */
    private Date subscribeTime;
    /**
     *微信账号ID
     */
    private String accountid;
}
