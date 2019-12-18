package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.DictionaryDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统数据字典请求实体")
public class DictionaryReq  extends DictionaryDTO<DictionaryReq> {

    /**
     * 父字典id
     */
    private String parentDic;

    /**
     * 字典菜单ID
     */
    private String dictionaryMenu;

    /**
     * 使用状态
     */
    private Integer state;

}
