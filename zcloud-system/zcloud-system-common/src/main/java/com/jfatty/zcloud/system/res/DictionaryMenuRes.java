package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.DictionaryMenuDTO;
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
@ApiModel(description = "项目管理实体")
public class DictionaryMenuRes extends DictionaryMenuDTO<DictionaryMenuRes> {

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime = LocalDateTime.now() ;


}
