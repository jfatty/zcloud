package com.jfatty.zcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2020/2/5
 * @email jfatty@163.com
 */
@Data
public class Gateway implements Serializable {

    private Integer id;
    private String url;
    private String remark;

}
