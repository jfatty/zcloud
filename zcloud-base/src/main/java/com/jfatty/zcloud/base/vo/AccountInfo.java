package com.jfatty.zcloud.base.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
@Data
public class AccountInfo implements Serializable {

    /**
     * id
     * 身份
     */
    private String identity ;

    /**
     * 凭证
     */
    private String certificate ;


}
