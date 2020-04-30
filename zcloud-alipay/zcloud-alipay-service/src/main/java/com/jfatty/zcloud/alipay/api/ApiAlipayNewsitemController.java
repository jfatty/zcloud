package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayNewsitem;
import com.jfatty.zcloud.alipay.interfaces.IAlipayNewsitem;
import com.jfatty.zcloud.alipay.req.AlipayNewsitemReq;
import com.jfatty.zcloud.alipay.res.AlipayNewsitemRes;
import com.jfatty.zcloud.alipay.service.AlipayNewsitemService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述  图文素材新闻
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "图文素材新闻API" ,value = "图文素材新闻")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayNewsitem"})
public class ApiAlipayNewsitemController
        extends ApiBaseAlipayController<AlipayNewsitem,AlipayNewsitemReq,AlipayNewsitemRes>
        implements IAlipayNewsitem {


    private AlipayNewsitemService alipayNewsitemService ;

    @Autowired
    public void setAlipayNewsitemService(AlipayNewsitemService alipayNewsitemService) {
        super.setBaseService(alipayNewsitemService);
        this.alipayNewsitemService = alipayNewsitemService;
    }
}
