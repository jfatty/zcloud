package com.jfatty.zcloud.health.model;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2020/1/2
 * @email jfatty@163.com
 */
public class DynamicQRCode implements Serializable {

    private int color ;
    private String qrCodeText;
    private String qrCodeImg;

    public DynamicQRCode() {
    }

    public String getQrCodeText() {
        return this.qrCodeText;
    }

    public DynamicQRCode setQrCodeText(String qrCodeText) {
        this.qrCodeText = qrCodeText;
        return this;
    }

    public String getQrCodeImg() {
        return this.qrCodeImg;
    }

    public DynamicQRCode setQrCodeImg(String qrCodeImg) {
        this.qrCodeImg = qrCodeImg;
        return this;
    }

    public int getColor() {
        return color;
    }

    public DynamicQRCode setColor(int color) {
        this.color = color;
        return this;
    }
}
