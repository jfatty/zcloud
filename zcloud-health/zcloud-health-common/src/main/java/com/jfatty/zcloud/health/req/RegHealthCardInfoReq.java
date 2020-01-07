package com.jfatty.zcloud.health.req;

import com.jfatty.zcloud.health.dto.HCSHealthCardInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "注册健康卡请求实体")
public class  RegHealthCardInfoReq  extends HCSHealthCardInfoDTO<RegHealthCardInfoReq> {


    @ApiModelProperty(name = "openId", position = 0,required = true, value = "微信 openId" ,example = "oPGot0QAYXg-Y4OiTYUDn55sjRdo")
    private String openId ;
    @ApiModelProperty(name = "openIdType", position = 1,required = true, value = "微信 2 openId 类型" , example = "2" ,allowableValues = "2")
    private Integer openIdType ;
    @ApiModelProperty(name = "hospitalId", position = 0,required = true, value = "医院ID" ,example = "30646")
    private String hospitalId ;

    @ApiModelProperty(name = "name", position = 0, value = "姓名",required = true ,example = "李志康")
    private String name;
    @ApiModelProperty(name = "idNumber", position = 0, value = "证件号码",required = true ,example = "429004199508134038")
    private String idNumber;
    @ApiModelProperty(name = "nation", position = 7,required = true, value = "民族 dicValue:::dicCode:::id 汉族、满族等" , example = "阿昌族:::402881bb5c626071015c62b3f8ac0038:::ddf014432f584952b1cd92b8d23526aa")
    private String nation;
    @ApiModelProperty(name = "phone1", position = 0, value = "联系方式1",required = true ,example = "18062158054")
    private String phone1;
    @ApiModelProperty(name = "address", position = 0, value = "地址",example = "湖北省仙桃市通海口镇石垸村三组31号")
    private String address;
    @ApiModelProperty(name = "kaptcha", position = 0, value = "短信验证码",required = true ,example = "142578")
    private String kaptcha;

    @ApiModelProperty(name = "relationship", position = 8, value = "与就诊人关系 dicValue:::dicCode:::id 本人、家人、朋友等" , example = "本人:::100212:::402881906EF4795A016EF47A85A80001")
    private String relationship ;
    @ApiModelProperty(name = "feeType", position = 10, value = "费用类别 dicValue:::dicCode:::id " , example = "自费:::0100:::693c54a870da44029aa03864659ee055")
    private String feeType ;

    @ApiModelProperty(name = "pubAddress", position = 0, value = "常驻地址信息")
    private HCSAddressReq pubAddress ;


}
