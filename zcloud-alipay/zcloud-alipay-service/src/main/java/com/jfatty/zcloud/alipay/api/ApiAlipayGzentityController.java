package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayGzentity;
import com.jfatty.zcloud.alipay.interfaces.IAlipayGzentity;
import com.jfatty.zcloud.alipay.req.AlipayGzentityReq;
import com.jfatty.zcloud.alipay.res.AlipayGzentityRes;
import com.jfatty.zcloud.alipay.service.AlipayGzentityService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 关注回复
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "关注回API" ,value = "关注回复")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayGzentity"})
public class ApiAlipayGzentityController
        extends ApiBaseAlipayController<AlipayGzentity,AlipayGzentityReq,AlipayGzentityRes>
        implements IAlipayGzentity {

    private AlipayGzentityService alipayGzentityService ;

    @Autowired
    public void setAlipayGzentityService(AlipayGzentityService alipayGzentityService) {
        super.setBaseService(alipayGzentityService);
        this.alipayGzentityService = alipayGzentityService;
    }
}
