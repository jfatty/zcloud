package com.jfatty.zcloud.system.res;

import com.jfatty.zcloud.system.dto.DictionaryDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统数据字典响应实体")
public class DictionarySimRes extends DictionaryDTO<DictionaryRes> {


}
