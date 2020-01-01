package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.PageHrefDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/1/1
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面链接跳转开发配置响应实体")
public class PageHrefRes extends PageHrefDTO<PageHrefRes> {
}
