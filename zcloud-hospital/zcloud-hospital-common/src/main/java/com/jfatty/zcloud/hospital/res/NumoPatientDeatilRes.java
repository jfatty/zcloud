package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.NumoPatientInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "就诊人详情响应实体")
public class NumoPatientDeatilRes extends NumoPatientInfoDTO<NumoPatientDeatilRes> {

    @ApiModelProperty(name = "id", position = 2,required = true, value = "主键ID" , example = "125")
    private Long id ;
    @ApiModelProperty(name = "patId", position = 2,required = true, value = "病人ID" , example = "12252")
    private String patId;                                                           //HIS系统病人唯一码
    @ApiModelProperty(name = "name", position = 2,required = true, value = "姓名" , example = "12252")
    private String name;                                                            //姓名
    @ApiModelProperty(name = "age", position = 2,required = true, value = "年龄" , example = "18")
    private Integer age;                                                            //年龄
    @ApiModelProperty(name = "gender", position = 2,required = true, value = "性别 1--男， 2--女" , example = "1")
    private Integer gender;                                                         //性别 1--男， 2--女
    @ApiModelProperty(name = "tel", position = 2,required = true, value = "联系电话" , example = "13158661258")
    private String tel;                                                             //联系电话
    @ApiModelProperty(name = "idCard", position = 2,required = true, value = "身份证号" , example = "422801258699")
    private String idCard;                                                          //身份证号
    @ApiModelProperty(name = "address", position = 2,required = true, value = "地址" , example = "湖北武汉")
    private String address;                                                         //地址
    @ApiModelProperty(name = "cardNo", position = 2,required = true, value = "卡号 " , example = "215258")
    private String cardNo;                                                          //绑定的卡号 jfatty add 绑定HIS系统中的磁卡号
    @ApiModelProperty(name = "hisCardNo", position = 2,required = true, value = "就诊卡号 " , example = "2252266999")
    private String hisCardNo ;                                                       //就诊卡号
    @ApiModelProperty(name = "hisCardType", position = 2,required = true, value = "就诊卡类型 " , example = "就诊卡")
    private String hisCardType ;                                                     //就诊卡类型
    @ApiModelProperty(name = "hisCardTypeCode", position = 2,required = true, value = "就诊卡类型编码 " , example = "HIS_MZH")
    private String hisCardTypeCode ;                                                 //就诊卡类型编码
    @ApiModelProperty(name = "nation", position = 2,required = true, value = "民族 " , example = "土家族")
    private String nation;                                                           //民族
    @ApiModelProperty(name = "relationship", position = 2,required = true, value = "与就诊人关系 " , example = "本人")
    private String relationship ;                                                    //与就诊人关系

}
