package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.PageHrefDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2020/1/1
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面链接跳转开发配置响应实体")
public class PageHrefRes extends PageHrefDTO<PageHrefRes> {

    /**
     * 域值
     */
    private String realm;

    /**
     * 使用状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
