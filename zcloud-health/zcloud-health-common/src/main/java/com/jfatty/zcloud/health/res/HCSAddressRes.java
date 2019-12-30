package com.jfatty.zcloud.health.res;


import com.jfatty.zcloud.health.dto.HCSAddressDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "公用地址信息响应实体")
public class HCSAddressRes extends HCSAddressDTO<HCSAddressRes> {


}
