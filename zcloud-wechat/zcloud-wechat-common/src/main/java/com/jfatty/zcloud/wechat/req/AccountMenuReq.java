package com.jfatty.zcloud.wechat.req;

import com.jfatty.zcloud.wechat.dto.AccountMenuDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信菜单响应实体")
public class AccountMenuReq extends AccountMenuDTO<AccountMenuReq> {
}
