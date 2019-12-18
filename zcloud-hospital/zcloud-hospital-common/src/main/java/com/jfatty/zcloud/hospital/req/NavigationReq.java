package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.NavigationDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */

@Data
@ApiModel(description = "底部导航请求实体")
public class NavigationReq  extends NavigationDTO<NavigationReq> {

    /**
     * 是否显示 1 表示显示 0 表示不显示
     */
    @ApiModelProperty(name = "display", value = "是否显示 1 表示显示 0 表示不显示", position = 6, required = true, allowableValues = "1,0")
    private Integer display;

    /**
     * 导航图标二进制文件
     */
    //@ApiModelProperty(name = "iconImg", value = "导航图标二进制文件", required = true, position = 2, example = "导航图标二进制文件")
    //private MultipartFile iconImg;

    /**
     * 导航图标激活状态二进制文件
     */
    //@ApiModelProperty(name = "actIconImg", value = "导航图标激活状态二进制文件", required = true, position = 2, example = "导航图标激活状态二进制文件")
    //private MultipartFile actIconImg;



}
