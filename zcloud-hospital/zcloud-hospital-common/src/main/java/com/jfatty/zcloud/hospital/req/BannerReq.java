package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.BannerDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/11
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "轮播图请求实体")
public class BannerReq extends BannerDTO<BannerReq> {


}
