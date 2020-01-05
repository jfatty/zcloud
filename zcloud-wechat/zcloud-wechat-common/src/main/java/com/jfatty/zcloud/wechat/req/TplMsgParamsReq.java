package com.jfatty.zcloud.wechat.req;

import com.jfatty.zcloud.wechat.dto.TplMsgParamsDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2020/1/5
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信模板消息参数配置响应实体")
public class TplMsgParamsReq extends TplMsgParamsDTO<TplMsgParamsReq> {
}
