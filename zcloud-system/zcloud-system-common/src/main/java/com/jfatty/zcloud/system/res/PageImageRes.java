package com.jfatty.zcloud.system.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.system.dto.PageImageDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述 界面图片开发配置
 *
 * @author jfatty on 2019/12/31
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "界面图片开发配置响应实体")
public class PageImageRes extends PageImageDTO<PageImageRes> {

    /**
     * 激活图片二进制文件
     */
    private byte[] actImg;

    /**
     * 图片二进制文件
     */
    private byte[] img;

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
