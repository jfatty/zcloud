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
public class HCSIDCardInfoVO implements Serializable {

    private String id;
    private String name;
    private String gender;
    private String nation;
    private String birth;
    private String address;
    private String authority;
    private String validDate;

}
