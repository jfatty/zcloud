package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.IdentityFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述
 *
 * @author jfatty on 2019/12/15
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统证件信息请求实体")
public class IdentityFileReq extends IdentityFileDTO<IdentityFileReq> {

    /**
     * 人头面
     */
    @ApiModelProperty(name = "avatar", value = "人头面", required = true, position = 2, example = "湖南省")
    private MultipartFile avatar;

    /**
     * 国徽面
     */
    @ApiModelProperty(name = "emblem", value = "国徽面", required = true, position = 3, example = "长沙市")
    private MultipartFile emblem;
}
