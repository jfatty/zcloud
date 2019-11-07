package com.jfatty.zcloud.wechat.utils.wx;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述 OAuth token
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public class OAuthAccessToken extends AccessToken {

    private static final long serialVersionUID = 1L;
    //oauth2.0
    private String oauthAccessToken;//刷新token
    private String openid;
    private String scope;


    public String getOauthAccessToken() {
        return oauthAccessToken;
    }
    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
