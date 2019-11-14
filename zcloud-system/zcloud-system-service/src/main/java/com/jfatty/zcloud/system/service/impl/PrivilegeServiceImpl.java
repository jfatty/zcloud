package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.base.utils.PrivilegeMenu;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.Privilege;
import com.jfatty.zcloud.system.mapper.PrivilegeMapper;
import com.jfatty.zcloud.system.service.PrivilegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class PrivilegeServiceImpl extends BaseSystemServiceImpl<Privilege,PrivilegeMapper> implements PrivilegeService {

    private PrivilegeMapper privilegeMapper ;

    @Autowired
    public void setPrivilegeMapper(PrivilegeMapper privilegeMapper) {
        super.setBaseMapper(privilegeMapper);
        this.privilegeMapper = privilegeMapper;
    }

    @Override
    public List<PrivilegeMenu> getPrivilegeMenu(AccountUnique user) {
        //权限级别
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", user.getId());
        map.put("root", true);
        map.put("type", "MENU");
        //map.put("layoutPosition",  new String[]{"LEFTMENU"});
        //超级管理员获取所有可视菜单
        map.put("super", 1);
        //一级菜单权限类型'TARGET','BUTTON','HREF','ACTION','SCRIPT','MENU'
        List<Privilege> top = privilegeMapper.getPrivilegeMenu(map);

        List<PrivilegeMenu> privilegeMenus = new ArrayList<PrivilegeMenu>() ;
        for( Privilege tPri : top   ){
            Integer level = tPri.getLevel() ;
            Integer levelMax = tPri.getLevelMax() ;
            PrivilegeMenu privilegeMenu = new PrivilegeMenu(tPri.getHref(),tPri.getIcon(),tPri.getSpread(),tPri.getTitle());
            if( level < levelMax ) { //说明有下级权限当前权限菜单可以展示出来
                //迭代查询子菜单
                privilegeMenu.setChildren(loopChildren(tPri, user));
                privilegeMenus.add(privilegeMenu);
            }
        }
        //返回权限列表
        return privilegeMenus ;

    }

    /**
     * @param privilege 一级菜单
     * @param user      当前用户
     * @return 迭代查询子菜单
     * @description:迭代查询子菜单
     * @author jfatty
     * @date 2018年7月19日
     * @version 1.0.0
     */
    protected List<PrivilegeMenu> loopChildren(Privilege privilege, AccountUnique user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", user.getId());
        map.put("parentId", privilege.getId());
        map.put("type", "MENU");
        //map.put("type", null);
        //map.put("layoutPosition", new String[]{"LEFTMENU","RIGHTCONTENT"} );
        //超级管理员获取所有可视菜单
        map.put("super", 1);
        List<Privilege> list = privilegeMapper.getPrivilegeMenu(map);
        List<PrivilegeMenu> privilegeMenus = new ArrayList<PrivilegeMenu>() ;
        //查询结果为列表继续迭代
        for (Privilege pri : list) {
            Integer level = pri.getLevel() ;
            Integer levelMax = pri.getLevelMax() ;
            String tmpHref = pri.getHref() ;
            if(tmpHref.contains(".h5")){
                tmpHref = tmpHref.replaceAll(".h5",".htm") ;
                System.out.println(tmpHref);
                pri.setHref(tmpHref);
                //privilegeMapper.updateById(pri);
            }
            //
            PrivilegeMenu privilegeMenu = new PrivilegeMenu(pri.getHref(),pri.getIcon(),pri.getSpread(),pri.getTitle());
            if( level < levelMax ) { //说明有下级权限当前权限菜单可以展示出来
                //迭代查询子菜单
                privilegeMenu.setChildren(loopChildren(pri, user));
            }
            privilegeMenus.add(privilegeMenu);
        }
        return privilegeMenus;
    }
}
