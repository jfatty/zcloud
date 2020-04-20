package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.WebExamDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "体检套餐明细多条数据响应实体")
public class WebExamDetailRes extends WebExamDetailDTO<WebExamDetailRes> {


    /**
     * 显示顺序
     */
    @ApiModelProperty(name = "xssx", position = 2,required = true, value = "显示顺序" , example = "12")
    private String xssx = "" ;

    /**
     * 名称
     */
    @ApiModelProperty(name = "zhmc", position = 2,required = true, value = "名称" , example = "一般体检")
    private String zhmc = "" ;

    /**
     * 内容
     */
    @ApiModelProperty(name = "zhnr", position = 2,required = true, value = "内容 " , example = "身高  体重  血压  脉搏  体重指数")
    private String zhnr = "" ;


}
