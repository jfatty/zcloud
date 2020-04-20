package com.jfatty.zcloud.hospital.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.hospital.entity.IconPicture;
import com.jfatty.zcloud.hospital.entity.Menu;
import com.jfatty.zcloud.hospital.interfaces.IIconPicture;
import com.jfatty.zcloud.hospital.req.IconPictureReq;
import com.jfatty.zcloud.hospital.res.IconPictureRes;
import com.jfatty.zcloud.hospital.service.IconPictureService;
import com.jfatty.zcloud.hospital.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-04-11
 */
@Api(tags = "图片储存API" ,value = "图片储存")
@Slf4j
@RestController
@RequestMapping("/api/iconPicture")
public class ApiIconPictureController extends ApiBaseHospitalController<IconPicture,IconPictureReq,IconPictureRes>  implements IIconPicture {

    private IconPictureService iconPictureService ;

    @Autowired
    private MenuService menuService ;

    @Autowired
    public void setIconPictureService(IconPictureService iconPictureService) {
        super.setBaseService(iconPictureService);
        this.iconPictureService = iconPictureService;
    }

    @ApiOperation(value="001****同步菜单图标到表")
    @RequestMapping(value={"/sync"},method=RequestMethod.GET)
    public RETResultUtils<String> sync() throws Exception{
        QueryWrapper<Menu> query = new QueryWrapper<Menu>() ;
        query.eq("version","4.0.0");
        List<Menu> menus = menuService.list(query);
        for( Menu menu : menus ) {
            System.out.println(menu);
            IconPicture iconPicture = new IconPicture();
            iconPicture.setIcon(menu.getIcon());
            iconPicture.setActIcon(menu.getActIcon());
            iconPicture.setSpecification("MOBILE");
            iconPicture.setRelationId(menu.getId());
            //iconPictureService.saveId(iconPicture);
        }

        return new RETResultUtils("ok");
    }


}

