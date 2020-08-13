package com.jfatty.zcloud.auth.mapper;


import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Set;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
public interface UserPasswdMapper extends IBaseMapper<UserPasswd> {


    UserPasswd getUserPasswd(@Param("account") String account);

    UserPasswd getUserByPhone(@Param("phone") String phone);

    int saveUser(UserPasswd userPasswd);

    /***
     * @description:根据用户ID获取对应角色名称集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     * @param map 封装查询参数用户id   userId
     * @return 返回角色名称  String Set集合
     */
    Set<String> getRoles(Map<String,Object> map);

    /**
     * @description:根据用户ID获取对应操作权限集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     * @param map 封装查询参数用户id   userId
     * @return 返回操作权限 路径 String Set 集合
     */
    Set<String> getPermissions(Map<String,Object> map);

    /**
     * @description:根据用户ID获取对应操作权限集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     * @param map 封装查询参数用户id   userId
     * @return 返回操作权限 路径 String Set 集合
     */
    Set<String> getUris(Map<String,Object> map);
}
