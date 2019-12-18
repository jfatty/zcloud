package com.jfatty.zcloud.wechat.res;

import com.jfatty.zcloud.wechat.dto.AccountDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "微信账号响应实体")
public class AccountRes extends AccountDTO<AccountRes> {



}
