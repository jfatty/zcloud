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
public class AppTokenInfo implements Serializable {

    private String appToken;
    private int expiresIn;

    public AppTokenInfo() {
    }

    public String getAppToken() {
        return this.appToken;
    }

    public AppTokenInfo setAppToken(String appToken) {
        this.appToken = appToken;
        return this;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public AppTokenInfo setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
