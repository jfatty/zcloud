package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.DictionaryDTO;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "系统数据字典响应实体")
public class DictionaryRes extends DictionaryDTO<DictionaryRes> {

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

    /**
     * 域值
     */
    private String realm;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime  ;

}
