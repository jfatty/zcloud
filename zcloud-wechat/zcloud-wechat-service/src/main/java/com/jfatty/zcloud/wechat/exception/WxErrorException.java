package com.jfatty.zcloud.wechat.exception;

/**
 * 描述 微信异常封装
 * @author jfatty on 2019/4/7
 * @email jfatty@163.com
 */
public class WxErrorException extends Exception {

    private static final long serialVersionUID = -6357149550353160810L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }

}
