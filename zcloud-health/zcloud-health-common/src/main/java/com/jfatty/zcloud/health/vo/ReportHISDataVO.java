package com.jfatty.zcloud.health.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/26
 * @email jfatty@163.com
 */
@Data
public class ReportHISDataVO implements Serializable {

    private String qrCodeText;
    private String idCardNumber;
    private String name;
    private String time;
    private String hospitalCode;
    //private String hospitalId;
    private String scene;
    private String department;
    private String cardType; //11-电子健康卡
    private String cardChannel;//用卡渠道  0401-服务号
    private String cardCostTypes = "" ; // 用卡费别 0100 自费  0200 医保 0300 公费  0000 其他

}
