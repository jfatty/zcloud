package com.jfatty.zcloud.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/6
 * @email jfatty@163.com
 */
@Data
public class BaseResponse implements Serializable {

    private int status = 200;
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

}
