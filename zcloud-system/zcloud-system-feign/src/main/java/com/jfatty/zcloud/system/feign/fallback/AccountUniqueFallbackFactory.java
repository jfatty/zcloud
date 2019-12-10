package com.jfatty.zcloud.system.feign.fallback;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.feign.AccountUniqueFeignClient;
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
            public RELResultUtils<AccountUnique> table(Map<String, Object> params) {
                return null;
            }

            @Override
            public RELResultUtils<AccountUnique> table(String v, Integer pageIndex, Integer pageSize) {
                return null;
            }

            @Override
            public ResultUtils list() {
                return null;
            }

            @Override
            public List<AccountUnique> list(Long v) {
                return null;
            }

            @Override
            public ResultUtils save(AccountUnique entity) {
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
            public ResultUtils edit(AccountUnique entity) {
                return null;
            }

            @Override
            public ResultUtils delete(Map<String, Object> params) {
                return null;
            }
        } ;
    }
}
