package com.jfatty.zcloud.system.fallback;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.feign.AccountUniqueFeignClient;
import com.jfatty.zcloud.system.req.AccountUniqueReq;
import com.jfatty.zcloud.system.res.AccountUniqueRes;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * 描述
 *
 * @author jfatty on 2019/11/14
 * @email jfatty@163.com
 */
@Component
public class AccountUniqueFallbackFactory implements FallbackFactory<AccountUniqueFeignClient>  {


    @Override
    public AccountUniqueFeignClient create(Throwable cause) {
        return new AccountUniqueFeignClient() {
            @Override
            public RELResultUtils<AccountUniqueRes> table(Map<String, Object> params) {
                return null;
            }

            @Override
            public RELResultUtils<AccountUniqueRes> table(String v, Integer pageIndex, Integer pageSize) {
                return null;
            }

            @Override
            public ResultUtils list() {
                return null;
            }

            @Override
            public List<AccountUniqueRes> list(Long v) {
                return null;
            }

            @Override
            public ResultUtils save(AccountUniqueReq entity) {
                return null;
            }

            @Override
            public ResultUtils view(String id) {
                AccountUnique accountUnique =  new AccountUnique();
                accountUnique.setId(id);
                accountUnique.setUserName("未找到");
                accountUnique.setUpdateTime(LocalDateTime.now());
                return ResultUtils.success(accountUnique) ;
            }

            @Override
            public ResultUtils edit(AccountUniqueReq entity) {
                return null;
            }

            @Override
            public ResultUtils delete(Map<String, Object> params) {
                return null;
            }
        };
    }
}
