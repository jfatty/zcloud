package com.jfatty.zcloud.hospital.res;

import com.jfatty.zcloud.hospital.dto.ModuleDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/4/12
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统模块集合响应实体")
public class ModuleTreeRes extends ModuleDTO<ModuleTreeRes> {

    private List<MenuRes> menus ;


}
