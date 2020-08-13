package com.jfatty.zcloud.auth.service;

import com.jfatty.zcloud.auth.entity.UserPasswd;

import java.util.Set;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
public interface UserPasswdService extends BaseAuthService<UserPasswd> {


    UserPasswd getUserPasswd(String account);

    /**
     * 通过手机号码查询用户信息
     * @param phone 手机号码
     * @return
     */
    UserPasswd getUserByPhone(String phone);

    /**
     * 保存用户注册的基本信息
     * @param userPasswd
     * @return
     */
    boolean saveUser(UserPasswd userPasswd);

    /**
     * @param uid 当前在线用户
     * @param sm   supermanager 超级管理员
     * @return 返回角色名称集合
     * @description: 获取角色名称列表
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     */
    Set<String> getRoles(String uid, Boolean sm);

    /**
     * @param uid 当前在线用户
     * @param sm   supermanager 超级管理员
     * @return 返回权限路径集合
     * @description:获取当前用户对应权限路径集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     */
    Set<String> getPermissions(String uid, Boolean sm);

    /**
     * @param uid 当前在线用户
     * @param sm   supermanager 超级管理员
     * @return 返回权限路径集合
     * @description:获取当前用户对应uri集合
     * @author jfatty
     * @date 2018年7月12日
     * @version 1.0.0
     */
    Set<String> getUris(String uid, Boolean sm);

}
