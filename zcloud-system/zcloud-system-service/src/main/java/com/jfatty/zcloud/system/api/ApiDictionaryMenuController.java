package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.DictionaryMenu;
import com.jfatty.zcloud.system.interfaces.IDictionaryMenu;
import com.jfatty.zcloud.system.req.DictionaryMenuReq;
import com.jfatty.zcloud.system.res.DictionaryMenuRes;
import com.jfatty.zcloud.system.service.DictionaryMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "系统字典菜单(分类)API" ,value = "系统字典菜单(分类)")
@Slf4j
@RestController
@RequestMapping(value={"/api/dictionaryMenu"})
public class ApiDictionaryMenuController extends ApiBaseSystemController<DictionaryMenu,DictionaryMenuReq,DictionaryMenuRes>  implements IDictionaryMenu {

    private DictionaryMenuService dictionaryMenuService ;

    @Autowired
    public void setDictionaryMenuService(DictionaryMenuService dictionaryMenuService) {
        super.setBaseService(dictionaryMenuService);
        this.dictionaryMenuService = dictionaryMenuService;
    }
}
