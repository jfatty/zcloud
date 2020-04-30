package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayMenu;
import com.jfatty.zcloud.alipay.interfaces.IAlipayMenu;
import com.jfatty.zcloud.alipay.req.AlipayMenuReq;
import com.jfatty.zcloud.alipay.res.AlipayMenuRes;
import com.jfatty.zcloud.alipay.service.AlipayMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 支付宝菜单
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "支付宝菜单API" ,value = "支付宝菜单")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayMenu"})
public class ApiAlipayMenuController
        extends ApiBaseAlipayController<AlipayMenu,AlipayMenuReq,AlipayMenuRes>
        implements IAlipayMenu {


    private AlipayMenuService alipayMenuService ;

    @Autowired
    public void setAlipayMenuService(AlipayMenuService alipayMenuService) {
        super.setBaseService(alipayMenuService);
        this.alipayMenuService = alipayMenuService;
    }
}
