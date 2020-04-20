package com.jfatty.zcloud.hospital.vo;

import lombok.Data;

/**
 * 描述 总结建议
 *
 * @author jfatty on 2019/5/7
 * @email jfatty@163.com
 */
@Data
public class ReportZjjy extends BaseResponse {

    /**
     * 单据号
     */
    private String djh ;
    /**
     * 总结
     */
    private String zj ;
    /**
     * 建议
     */
    private String jy ;
    /**
     * 总结医生
     */
    private String zjys ;
    /**
     * 总结医生名称
     */
    private String zjysmc ;
    /**
     * 总结医生签名
     */
    private byte[] zjysqm ;
    /**
     * 总结时间
     */
    private String zjsj ;


}
