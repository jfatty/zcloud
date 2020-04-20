package com.jfatty.zcloud.system.req;

import com.jfatty.zcloud.system.dto.AccountUniqueDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * 描述
 *
 * @author jfatty on 2019/12/16
 * @email jfatty@163.com
 */
@Data
@ApiModel(description = "登录账号信息请求实体")
public class AccountUniqueReq extends AccountUniqueDTO<AccountUniqueReq> {

}
