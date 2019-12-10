package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.base.vo.SystemTree;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.UserGroup;
import com.jfatty.zcloud.system.mapper.UserGroupMapper;
import com.jfatty.zcloud.system.service.UserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class UserGroupServiceImpl extends BaseSystemServiceImpl<UserGroup,UserGroupMapper> implements UserGroupService {

    private UserGroupMapper userGroupMapper ;

    @Autowired
    public void setUserGroupMapper(UserGroupMapper userGroupMapper) {
        super.setBaseMapper(userGroupMapper);
        this.userGroupMapper = userGroupMapper;
    }

    @Override
    public List<SystemTree> getUserGroupList(AccountUnique user, String userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        //supermanager
        Boolean sm = user.getUserName().equals("root");
        map.put("sm", sm ? 1 : 0);
        map.put("currentUserId", user.getId());
        map.put("userId", null);
        List<SystemTree> all = userGroupMapper.getUserGroupList(map);
        //
        if (StringUtils.isNotEmpty(userId) && StringUtils.isNotBlank(userId)) {
            map = new HashMap<String, Object>();
            map.put("userId", userId);
            List<SystemTree> selecteds = userGroupMapper.getUserGroupList(map);
            for (SystemTree a : all) {
                for (SystemTree sed : selecteds) {
                    if (sed.getValue().equals(a.getValue())) {
                        a.setChecked(true);
                    }
                }
            }
        }
        return all;
    }
}
