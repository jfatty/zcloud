package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayReceivetext;
import com.jfatty.zcloud.alipay.interfaces.IAlipayReceivetext;
import com.jfatty.zcloud.alipay.req.AlipayReceivetextReq;
import com.jfatty.zcloud.alipay.res.AlipayReceivetextRes;
import com.jfatty.zcloud.alipay.service.AlipayReceivetextService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述  文本消息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "文本消息API" ,value = "文本消息")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayReceivetext"})
public class ApiAlipayReceivetextController
        extends ApiBaseAlipayController<AlipayReceivetext,AlipayReceivetextReq,AlipayReceivetextRes>
        implements IAlipayReceivetext {


    private AlipayReceivetextService alipayReceivetextService ;


    @Autowired
    public void setAlipayReceivetextService(AlipayReceivetextService alipayReceivetextService) {
        super.setBaseService(alipayReceivetextService);
        this.alipayReceivetextService = alipayReceivetextService;
    }



}
