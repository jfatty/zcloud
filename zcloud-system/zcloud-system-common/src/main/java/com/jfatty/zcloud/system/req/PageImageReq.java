package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.PageImageDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述 界面图片开发配置
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面图片开发配置响应实体")
public class PageImageReq extends PageImageDTO<PageImageReq> {

}
