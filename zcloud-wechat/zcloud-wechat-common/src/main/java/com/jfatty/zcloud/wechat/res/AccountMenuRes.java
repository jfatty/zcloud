package com.jfatty.zcloud.wechat.res;

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
@ApiModel(description = "电子就诊卡信息响应实体")
public class AccountMenuRes extends AccountMenuDTO<AccountMenuRes> {
}
