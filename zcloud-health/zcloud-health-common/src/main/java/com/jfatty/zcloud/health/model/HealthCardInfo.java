package com.jfatty.zcloud.health.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2020/1/4
 * @email jfatty@163.com
 */
@Data
public class HealthCardInfo implements Serializable {

    private String wechatCode;
    private String name;
    private String gender;
    private String nation;
    private String birthday;
    private String idNumber;
    private String idType;
    private String address;
    private String phone1;
    private String phone2;
    private String patid;
    private String phid;
    private String qrCodeText;
    private String healthCardId;
    private String adminExt;
    private String openId;
    private String wechatUrl;

    public HealthCardInfo() {
    }

    public String getWechatCode() {
        return this.wechatCode;
    }

    public HealthCardInfo setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public HealthCardInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return this.gender;
    }

    public HealthCardInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNation() {
        return this.nation;
    }

    public HealthCardInfo setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public HealthCardInfo setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public HealthCardInfo setIdNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public String getIdType() {
        return this.idType;
    }

    public HealthCardInfo setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public HealthCardInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public HealthCardInfo setPhone1(String phone1) {
        this.phone1 = phone1;
        return this;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public HealthCardInfo setPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public String getPatid() {
        return this.patid;
    }

    public HealthCardInfo setPatid(String patid) {
        this.patid = patid;
        return this;
    }

    public String getQrCodeText() {
        return this.qrCodeText;
    }

    public HealthCardInfo setQrCodeText(String qrCodeText) {
        this.qrCodeText = qrCodeText;
        return this;
    }

    public String getHealthCardId() {
        return this.healthCardId;
    }

    public HealthCardInfo setHealthCardId(String healthCardId) {
        this.healthCardId = healthCardId;
        return this;
    }

    public String getAdminExt() {
        return this.adminExt;
    }

    public HealthCardInfo setAdminExt(String adminExt) {
        this.adminExt = adminExt;
        return this;
    }

    public String getPhid() {
        return this.phid;
    }

    public HealthCardInfo setPhid(String phid) {
        this.phid = phid;
        return this;
    }

    public String getOpenId() {
        return this.openId;
    }

    public HealthCardInfo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getWechatUrl() {
        return this.wechatUrl;
    }

    public HealthCardInfo setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl;
        return this;
    }

}
