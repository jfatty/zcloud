package com.jfatty.zcloud.system.mapper;



import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.system.entity.AccountUnique;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 系统账号信息表 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2019-03-25
 */
public interface AccountUniqueMapper extends IBaseMapper<AccountUnique> {


    /***
     * @description:根据用户ID获取对应角色名称集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     * @param map 封装查询参数用户id   userId
     * @return 返回角色名称  String Set集合
     */
    Set<String> getRoles(Map<String, Object> map);

    /**
     * @description:根据用户ID获取对应操作权限集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     * @param map 封装查询参数用户id   userId
     * @return 返回操作权限 路径 String Set 集合
     */
    Set<String> getPermissions(Map<String, Object> map);

}
