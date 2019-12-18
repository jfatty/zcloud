package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ElectronicCardDTO;
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
@ApiModel(description = "电子就诊卡信息响应实体")
public class ElectronicCardRes  extends ElectronicCardDTO<ElectronicCardRes> {

    @ApiModelProperty(name = "name", position = 0, value = "病人姓名" , example = "张三")
    private String name;                                                            //姓名
    @ApiModelProperty(name = "idCard", position = 1, value = "病人身份证号" , example = "42282319******4731")
    private String idCard;                                                          //身份证号
    @ApiModelProperty(name = "cardNo", position = 1, value = "就诊卡号" , example = "25659892825")
    private String cardNo = "";                                                          //绑定的卡号 jfatty add 绑定HIS系统中的磁卡号
    @ApiModelProperty(name = "hisCardNo", position = 1, value = "HIS中CardNo" , example = "20125859866")
    private String hisCardNo = "" ;                                                       //就诊卡号

}
