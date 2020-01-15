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

    private int code = 200;
    private String msg;

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse() {
    }

    public BaseResponse(int code) {
        this.code = code;
    }

    public boolean success(){
        return this.code == 200 ;
    }

}
