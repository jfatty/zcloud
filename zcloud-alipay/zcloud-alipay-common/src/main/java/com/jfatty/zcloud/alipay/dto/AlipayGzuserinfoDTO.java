package com.jfatty.zcloud.alipay.dto;

import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述 支付宝关注用户
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
public class AlipayGzuserinfoDTO<T extends BaseDTO> extends BaseDTO {
    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;
}
