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
public class EreportSecond implements Serializable {

    /**
     * 项目名称
     */
    private String xmmc  = "" ;
    /**
     * 项目结果
     */
    private String xmjg  = "" ;
    /**
     * 项目单位
     */
    private String xmdw  = "" ;
    /**
     * 参考值
     */
    private String ckz  = "" ;

    /**
     * 结果说明
     */
    private String jgsm = "" ;

}
