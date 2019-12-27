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
    private String hospitalId;
    private String scene;
    private String cardType;
    private String cardChannel;

}
