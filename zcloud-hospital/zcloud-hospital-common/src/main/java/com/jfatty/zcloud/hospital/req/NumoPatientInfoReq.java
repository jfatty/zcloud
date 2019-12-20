package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.NumoPatientInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "患者信息请求实体")
public class NumoPatientInfoReq extends NumoPatientInfoDTO<NumoPatientInfoReq> {

    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 支付宝 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 支付宝 1 APP 3 openId 类型" , example = "2" ,allowableValues = "1,2,3")
    private Integer openIdType ;
    @ApiModelProperty(name = "name", position = 2,required = true, value = "姓名" , example = "张三")
    private String name;                                                            //姓名
    //@ApiModelProperty(name = "gender", position = 3,required = true, value = "性别" , example = "男" ,allowableValues = "男,女")
    //private String gender;                                                         //性别 1--男， 2--女 性别 0：未知、1：男、2：女
    @ApiModelProperty(name = "tel", position = 4,required = true, value = "联系电话" , example = "15571068412")
    private String tel;                                                             //联系电话
    @ApiModelProperty(name = "idCard", position = 5,required = true, value = "身份证号" , example = "42282319******4731")
    private String idCard;                                                          //身份证号
    @ApiModelProperty(name = "address", position = 6, value = "地址" , example = "湖北武汉光谷")
    private String address;                                                         //地址
    @ApiModelProperty(name = "nation", position = 7,required = true, value = "民族 dicValue:::dicCode:::id 汉族、满族等" , example = "阿昌族:::402881bb5c626071015c62b3f8ac0038:::ddf014432f584952b1cd92b8d23526aa")
    private String nation;
    @ApiModelProperty(name = "relationship", position = 8, required = true, value = "与就诊人关系 dicValue:::dicCode:::id 本人、家人、朋友等" , example = "本人:::100212:::402881906EF4795A016EF47A85A80001")
    private String relationship ;
    @ApiModelProperty(name = "hisCardNo", position = 9, value = "就诊卡号" , example = "201253695")
    private String hisCardNo ;                                                       //就诊卡号
    @ApiModelProperty(name = "hisCardType", position = 10, value = "就诊卡类型 dicValue:::dicCode:::id " , example = "门诊号:::HIS_MZH:::693c54a870da44029aa03864659ee055")
    private String hisCardType ;                                                     //就诊卡类型
    @ApiModelProperty(name = "hasCard", position = 11,required = true, value = "勾选有就诊卡 值为1 未勾选有就诊卡 值为0" , example = "0" ,allowableValues = "1,0")
    private Integer hasCard ;

}
