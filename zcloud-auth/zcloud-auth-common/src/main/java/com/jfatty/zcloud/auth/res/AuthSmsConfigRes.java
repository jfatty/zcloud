package com.jfatty.zcloud.auth.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfatty.zcloud.auth.dto.AuthSmsConfigDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author jfatty on 2019/12/27
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "系统短信息配置响应实体")
public class AuthSmsConfigRes extends AuthSmsConfigDTO<AuthSmsConfigRes> {

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
    private LocalDateTime createTime;

}
