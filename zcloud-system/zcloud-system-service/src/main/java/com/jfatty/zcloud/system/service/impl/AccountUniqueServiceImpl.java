package com.jfatty.zcloud.system.service.impl;



import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.mapper.AccountUniqueMapper;
import com.jfatty.zcloud.system.service.AccountUniqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 系统账号信息表 服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
@Slf4j
@Service
public class AccountUniqueServiceImpl extends BaseSystemServiceImpl<AccountUnique,AccountUniqueMapper> implements AccountUniqueService {


    private AccountUniqueMapper accountUniqueMapper;


    @Autowired
    public void setAccountUniqueMapper(AccountUniqueMapper accountUniqueMapper) {
        super.setBaseMapper(accountUniqueMapper);
        this.accountUniqueMapper = accountUniqueMapper;
    }

    @Override
    public Set<String> getRoles(AccountUnique user, Boolean sm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sm ? null : user.getId());
        return accountUniqueMapper.getRoles(map);
    }

    @Override
    public Set<String> getPermissions(AccountUnique user, Boolean sm) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sm ? null : user.getId());
        return accountUniqueMapper.getPermissions(map);
    }


}
