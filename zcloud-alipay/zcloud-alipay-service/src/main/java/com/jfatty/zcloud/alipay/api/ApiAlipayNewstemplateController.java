package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayNewstemplate;
import com.jfatty.zcloud.alipay.interfaces.IAlipayNewstemplate;
import com.jfatty.zcloud.alipay.req.AlipayNewstemplateReq;
import com.jfatty.zcloud.alipay.res.AlipayNewstemplateRes;
import com.jfatty.zcloud.alipay.service.AlipayNewstemplateService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 图文素材模板
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "图文素材模板API" ,value = "图文素材模板")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayNewstemplate"})
public class ApiAlipayNewstemplateController
        extends ApiBaseAlipayController<AlipayNewstemplate,AlipayNewstemplateReq,AlipayNewstemplateRes>
        implements IAlipayNewstemplate {


    private AlipayNewstemplateService alipayNewstemplateService ;

    @Autowired
    public void setAlipayNewstemplateService(AlipayNewstemplateService alipayNewstemplateService) {
        super.setBaseService(alipayNewstemplateService);
        this.alipayNewstemplateService = alipayNewstemplateService;
    }

}
