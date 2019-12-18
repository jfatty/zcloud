package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ElectronicDocDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子票据/我的服务单详情封装扩展响应实体")
public class ElectronicDocDetailExtRes extends ElectronicDocDetailDTO<ElectronicDocDetailExtRes> {

    /**
     * 挂号id
     */
    @ApiModelProperty(name = "ghid", position = 2,required = true, value = "挂号id" , example = "201911240358")
    private String ghid ;

    /**
     * 姓名
     */
    @ApiModelProperty(name = "xm", position = 2,required = true, value = "姓名" , example = "蔡琼")
    private String xm ;

    /**
     * 性别
     */
    @ApiModelProperty(name = "xb", position = 2,required = true, value = "性别" , example = "女")
    private String xb ;

    /**
     * 年龄
     */
    @ApiModelProperty(name = "nl", position = 2,required = true, value = "年龄" , example = "30岁")
    private String nl ;


    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 2,required = true, value = "科室名称" , example = "内一科")
    private String ksmc ;

    /**
     * 收费号
     */
    @ApiModelProperty(name = "sfh", position = 2,required = true, value = "收费号" , example = "12596")
    private String sfh ;

    /**
     * 收费日期
     */
    @ApiModelProperty(name = "sfrq", position = 2,required = true, value = "收费日期" , example = "2019-10-15 15:15:13")
    private String sfrq ;


    private List<ElectronicDocDetailRes> elecDocs ;


}
