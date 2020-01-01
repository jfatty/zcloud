package com.jfatty.zcloud.health.res;

import com.jfatty.zcloud.health.dto.HealthCardUserDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 电子健康卡微信用户信息
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "电子健康卡微信用户信息响应实体")
public class HealthCardUserRes extends HealthCardUserDTO<HealthCardUserRes> {



}
