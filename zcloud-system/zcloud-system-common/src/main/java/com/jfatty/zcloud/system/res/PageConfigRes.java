package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.PageConfigDTO;
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
@ApiModel(description = "界面开发配置响应实体")
public class PageConfigRes extends PageConfigDTO<PageConfigRes> {


    /**
     * 域值
     */
    private String realm;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
