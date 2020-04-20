package com.jfatty.zcloud.wechat.req;

import com.jfatty.zcloud.wechat.dto.UserTagDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "用户标签响应实体")
public class UserTagReq  extends UserTagDTO<UserTagReq> {
}
