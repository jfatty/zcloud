package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 描述 账号信息表
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Data
public class AlipayAccountDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;
    /**
     *账号名称
     */
    @ApiModelProperty(name = "accontName", position = 0, required = true, value = "账号名称",example = "北大青鸟")
    private String accontName;
    /**
     *描述
     */
    @ApiModelProperty(name = "accountDesc", position = 0, value = "描述",example = "北大青鸟好好好")
    private String accountDesc;
    /**
     *商户应用APPID
     */
    @ApiModelProperty(name = "appid", position = 0,required = true, value = "商户应用APPID",example = "288372882992838292983")
    private String appid;
    /**
     *开发者应用私钥
     */
    @ApiModelProperty(name = "rsaPrivateKey", position = 0, value = "开发者应用私钥",example = "shuhdiuwqhdiqwdhiqu")
    private String rsaPrivateKey;
    /**
     *支付宝公钥
     */
    @ApiModelProperty(name = "alipayPublicKey", position = 0,required = true, value = "支付宝公钥",example = "340873248djdjijdied83u8jd83e83je83ue38ue83ur8")
    private String alipayPublicKey;
    /**应用公钥*/
    @ApiModelProperty(name = "publicKey", position = 0,required = true, value = "应用公钥",example = "ujjhygtbsfsvggywywu")
    private String publicKey;

    /**商户应用私钥**/
    @ApiModelProperty(name = "privateKey", position = 0,required = true, value = "商户应用私钥",example = "89983948uejjjjdjn")
    private String privateKey ;

    /**
     *创建人名称
     */
    @ApiModelProperty(name = "createName", position = 0,required = true, value = "创建人名称",example = "张三丰")
    private String createName;
    /**
     *创建人登录名称
     */
    @ApiModelProperty(name = "createName", position = 0,required = true, value = "创建人名称",example = "add")
    private String createBy;
    /**
     *创建日期
     */
    private Date createDate;
    /**
     *更新人名称
     */
    @ApiModelProperty(name = "updateName", position = 0,required = true, value = "更新人名称",example = "灭绝师太")
    private String updateName;
    /**
     *更新人登录名称
     */
    @ApiModelProperty(name = "updateBy", position = 0,required = true, value = "更新人登录名称",example = "方丈大师")
    private String updateBy;
    /**
     *更新日期
     */
    private Date updateDate;

    private String conversationSecret ;

}
