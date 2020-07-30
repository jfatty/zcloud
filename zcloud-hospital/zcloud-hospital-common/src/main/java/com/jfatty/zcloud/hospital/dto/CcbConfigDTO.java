package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 建行支付配置信息表
 *
 * @author jfatty on 2020/7/27
 * @email jfatty@163.com
 */
@Data
public class CcbConfigDTO<T extends BaseDTO> extends BaseDTO {


    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id;

    /**
     * 公众号APPID
     */
    @ApiModelProperty(name = "appid", position = 0,required = true, value = "公众号APPID" ,example = "wxe3336a60d2685379")
    private String appid;

    /**
     * 商户ID
     */
    @ApiModelProperty(name = "merchantId", position = 0,required = true, value = "商户ID" ,example = "105000080621818")
    private String merchantId;

    /**
     * 商户柜台代码
     */
    @ApiModelProperty(name = "posId", position = 0,required = true, value = "商户柜台代码" ,example = "028473089")
    private String posId;

    /**
     * 分行代码
     */
    @ApiModelProperty(name = "branchId", position = 0,required = true, value = "分行代码" ,example = "430000000")
    private String branchId;

    /**
     * 币种
     */
    @ApiModelProperty(name = "curCode", position = 0,required = true, value = "币种" ,example = "01")
    private String curCode;

    /**
     * 交易码
     */
    @ApiModelProperty(name = "txCode", position = 0,required = true, value = "交易码" ,example = "530550")
    private String txCode;

    /**
     * 支付回调地址
     */
    @ApiModelProperty(name = "payNotifyUrl", position = 0,required = true, value = "支付回调地址" ,example = "http://weixin.hnlsxzyy.com/hospital/api/payNotify/ccbNotifyUrl/105000080621818")
    private String payNotifyUrl;

    /**
     * 微信支付网关地址
     */
    @ApiModelProperty(name = "gateWay", position = 0,required = true, value = "建行网关地址" ,example = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain")
    private String gateWay;

    /**
     * 公钥完整字符串
     */
    @ApiModelProperty(name = "publicKey", position = 0,required = true, value = "公钥完整字符串" ,example = "30819d300d06092a864886f70d010101050003818b0030818702818100a9fa85d0e343c37a1ca81d7004f361f0a09381c642c88aa5cfab49c5ce6e430a4189baf6a9c3d025df3173731dec63baeb2bbb7b14bdf334d751b4573df1be373557b6176014ed18ef3774679eb7ae798aa84ae0e71d75a613fff04ce1b87c9693e48d46faca200dde18b59030500528f08b39390569acf1faa4767782e77bb1020111")
    private String publicKey;

    /**
     * 公钥后30位
     */
    @ApiModelProperty(name = "pub", position = 0,required = true, value = "公钥后30位" ,example = "0569acf1faa4767782e77bb1020111")
    private String pub;

    /**
     * 模板消息ID
     */
    @ApiModelProperty(name = "tplId", position = 0,required = true, value = "模板消息ID" ,example = "2C918082723F049E017249A9E09B0005")
    private String tplId;

    /**
     * 支付成功跳转详情地址
     */
    @ApiModelProperty(name = "paySuccessTplUrl", position = 0,required = true, value = "支付成功跳转详情地址" ,example = "http://weixin.hnlsxzyy.com/payResult?outTradeNo=")
    private String paySuccessTplUrl;

    private String returnType;

    /**
     * 证书号
     */
    @ApiModelProperty(name = "certNo", position = 0,required = true, value = "证书号" ,example = "MC1259150")
    private String certNo;

}
