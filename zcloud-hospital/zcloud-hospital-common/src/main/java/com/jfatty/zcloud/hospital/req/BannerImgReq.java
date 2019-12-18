package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.BannerImgDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */

@Data
@ApiModel(description = "首页轮播图请求实体")
public class BannerImgReq extends BannerImgDTO<BannerImgReq> {

    /**
     * 图片二进制文件
     */
    //@ApiModelProperty(name = "picture", value = "图片文件",  position = 11, example = "上传图片文件")
    //private MultipartFile picture;

    /**
     * 是否显示
     */
    //@ApiModelProperty(name = "display", position = 12 ,required = true, value = "是否显示" ,allowableValues = "1,0")
    //private Integer display;
}
