package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.IconPictureDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/4/12
 * @email jfatty@163.com
 */

@Data
@ApiModel(description = "图片储存请求实体")
public class IconPictureReq extends IconPictureDTO<IconPictureReq> {


}
