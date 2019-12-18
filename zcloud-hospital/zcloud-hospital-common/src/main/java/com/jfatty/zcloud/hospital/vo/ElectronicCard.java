package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class ElectronicCard implements Serializable {

    private String id ;
    private String patId;                                                           //HIS系统病人唯一码
    private String name;                                                            //姓名
    private String idCard;                                                          //身份证号
    private String cardNo;                                                          //绑定的卡号 jfatty add 绑定HIS系统中的磁卡号
    private String hisCardNo ;                                                       //就诊卡号

}
