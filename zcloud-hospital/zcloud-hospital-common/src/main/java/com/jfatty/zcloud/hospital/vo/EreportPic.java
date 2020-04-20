package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述
 *
 * @author jfatty on 2019/9/30
 * @email jfatty@163.com
 */
@Data
public class EreportPic implements Serializable {

    private String zhid ;

    /**
     * 序号
     */
    private Integer xh ;
    /**
     * 图像
     */
    private byte[] tx ;

}