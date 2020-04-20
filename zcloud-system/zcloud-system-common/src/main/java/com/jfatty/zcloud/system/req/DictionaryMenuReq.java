package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.DictionaryMenuDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统字典菜单请求实体")
public class DictionaryMenuReq  extends DictionaryMenuDTO<DictionaryMenuReq> {

}
