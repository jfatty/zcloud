package com.jfatty.zcloud.hospital.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述
 * 系统病人信息
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class SysPatientInfoDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "病人ID编号[添加操作可不传递,修改必传]")
    private String id ;
    @ApiModelProperty(name = "name", position = 1, value = "病人姓名")
    private String name ;
    @ApiModelProperty(name = "sex", position = 2, value = "病人性别")
    private String sex ;
    @ApiModelProperty(name = "cardNum", position = 3, value = "病人就诊卡号")
    private String cardNum ;
    @ApiModelProperty(name = "idCard", position = 4, value = "身份证号码")
    private String idCard ;
    @ApiModelProperty(name = "tel", position = 5, value = "联系电话")
    private  String tel ;
    @ApiModelProperty(name = "address", position = 6, value = "联系地址")
    private  String address ;

}
