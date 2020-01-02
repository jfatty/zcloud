package com.jfatty.zcloud.health.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2020/1/2
 * @email jfatty@163.com
 */
@Data
public class IDCardInfo implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String nation;
    private String birth;
    private String address;
    private String authority;
    private String validDate;

    public IDCardInfo() {
    }

    public String getId() {
        return this.id;
    }

    public IDCardInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public IDCardInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return this.gender;
    }

    public IDCardInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNation() {
        return this.nation;
    }

    public IDCardInfo setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public String getBirth() {
        return this.birth;
    }

    public IDCardInfo setBirth(String birth) {
        this.birth = birth;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public IDCardInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAuthority() {
        return this.authority;
    }

    public IDCardInfo setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public String getValidDate() {
        return this.validDate;
    }

    public IDCardInfo setValidDate(String validDate) {
        this.validDate = validDate;
        return this;
    }
}
