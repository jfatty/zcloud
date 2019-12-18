package com.jfatty.zcloud.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.base.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
public class DictionaryMenuDTO<T extends BaseDTO> extends BaseDTO {

    /**
     * 主键ID页面页面标识唯一
     */
    @ApiModelProperty(name = "id", position = 0, value = "主键ID编号[添加操作可不传递,修改必传]")
    private String id ;

    /**
     * 菜单字典名称
     */
    private String name;

    /**
     * 菜单字典编码
     */
    private String menuCode;

    /**
     * 菜单字典描述
     */
    private String description;

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;


}
