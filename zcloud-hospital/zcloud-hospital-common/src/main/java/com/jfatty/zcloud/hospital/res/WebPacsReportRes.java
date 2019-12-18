package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebPacsReportDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/17
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "检查报告内容响应实体")
public class WebPacsReportRes extends WebPacsReportDTO<WebPacsReportRes> {

    /**
     * 流水号
     */
    @ApiModelProperty(name = "djh", position = 2,required = true, value = "流水号 " , example = "201252852")
    private String djh ;
    /**
     * 病人编号
     */
    @ApiModelProperty(name = "brbh", position = 2 ,required = true, value = "病人编号 " , example = "2521478")
    private String brbh ;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2 ,required = true, value = "姓名 " , example = "张三")
    private String xm ;
    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2 ,required = true, value = "性别 " , example = "男")
    private String xb ;
    /**
     * 年龄
     */
    @ApiModelProperty(name = "xb", position = 2 ,required = true, value = "性别 " , example = "男")
    private String nl ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2 ,required = true, value = "科室名称 " , example = "内一科")
    private String ksmc ;
    /**
     * 床位号
     */
    @ApiModelProperty(name = "cwh", position = 2 ,required = true, value = "床位号 " , example = "15床")
    private String cwh ;
    /**
     * 诊断
     */
    @ApiModelProperty(name = "zd", position = 2,required = true, value = "诊断" , example = "中孕，单活胎，超声约孕18W+4建议20-24W行胎儿系统")
    private String zd ;
    /**
     * 检查描述
     */
    @ApiModelProperty(name = "jcms", position = 2,required = true, value = "检查描述" , example = "中孕，单活胎，超声约孕18W+4建议20-24W行胎儿系统")
    private String jcms ;
    /**
     * 检查结论
     */
    @ApiModelProperty(name = "jcjl", position = 2,required = true, value = "检查结论" , example = "增大的宫腔内见一胎儿图像：双顶径44m")
    private String jcjl ;
    /**
     *
     */
    private String jsysmc ;
    /**
     * 检查医生名称
     */
    @ApiModelProperty(name = "jcysqm", position = 2,required = true, value = "检查医生签名" , example = "图片二进制")
    private String jcysqm ;
    /**
     * 检查日期
     */
    @ApiModelProperty(name = "jcrq", position = 2,required = true, value = "检查日期" , example = "2019-11-18 08:46:28.64")
    private String jcrq ;
    /**
     * 审核医生名称
     */
    @ApiModelProperty(name = "shysmc", position = 2,required = true, value = "审核医生名称" , example = "印冬阳")
    private String shysmc ;
    /**
     * 审核医生签名
     */
    @ApiModelProperty(name = "shysqm", position = 2,required = true, value = "审核医生签名" , example = "图片二进制")
    private String shysqm ;
    /**
     * 审核日期
     */
    @ApiModelProperty(name = "shrq", position = 2,required = true, value = "审核日期" , example = "2019-11-02 ...")
    private String shrq ;

}
