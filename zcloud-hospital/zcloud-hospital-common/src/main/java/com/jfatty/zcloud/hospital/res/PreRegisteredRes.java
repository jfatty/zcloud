package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.PreRegisteredDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "预约挂号响应实体")
public class PreRegisteredRes extends PreRegisteredDTO<PreRegisteredRes> {

    /**
     * 科室ID
     */
    @ApiModelProperty(name = "ksid", position = 0,required = true, value = "科室ID" ,example = "1453")
    private String ksid ;
    /**
     * 科室名称
     */
    @ApiModelProperty(name = "ksmc", position = 0,required = true, value = "科室名称" ,example = "五官科")
    private String ksmc ;
    /**
     * 科室位置
     */
    @ApiModelProperty(name = "kswz", position = 0,required = true, value = "科室位置" ,example = "诊二楼右侧")
    private String kswz ;
    /**
     * 预约号
     */
    @ApiModelProperty(name = "yyh", position = 0,required = true, value = "预约号 成功页面一维码展示" ,example = "2252696238525")
    private String yyh ;

    /**
     * 预约日期
     */
    @ApiModelProperty(name = "yyrq", position = 0,required = true, value = "预约日期" ,example = "2019-12-05 08:40")
    private String yyrq ;

    /**
     * 就诊人
     */
    @ApiModelProperty(name = "name", position = 0,required = true, value = "就诊人" ,example = "张三")
    private String name ;

    /**
     * 状态
     */
    @ApiModelProperty(name = "name", position = 0,required = true, value = "状态" ,example = "成功")
    private String status ;

    /**
     * 预约挂号时间
     */
    @ApiModelProperty(name = "name", position = 0,required = true, value = "预约挂号时间" ,example = "yyyy-MM-dd HH:mm:ss")
    private String yyghsj ;

}
