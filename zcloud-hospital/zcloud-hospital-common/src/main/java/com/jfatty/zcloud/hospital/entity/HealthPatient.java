package com.jfatty.zcloud.hospital.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述 健康卡病人信息
 *
 * @author jfatty on 2020/5/21
 * @email jfatty@163.com
 */
@Data
public class HealthPatient implements Serializable {

    private String brid ;

    private String xm ;

    private String sfzh ;

    private String healthCardId ;

    private String qrCodeText ;

}
