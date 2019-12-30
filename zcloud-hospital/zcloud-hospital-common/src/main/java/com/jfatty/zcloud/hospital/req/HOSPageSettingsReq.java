package com.jfatty.zcloud.hospital.req;

import com.jfatty.zcloud.hospital.dto.HOSPageSettingsDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/30
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "智慧医疗页面配置信息请求实体")
public class HOSPageSettingsReq extends HOSPageSettingsDTO<HOSPageSettingsReq> {

    /**
     * 使用状态
     */
    private Integer state;



}
