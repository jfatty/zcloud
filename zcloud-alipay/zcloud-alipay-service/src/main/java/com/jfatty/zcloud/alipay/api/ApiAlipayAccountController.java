package com.jfatty.zcloud.alipay.api;

import com.jfatty.zcloud.alipay.entity.AlipayAccount;
import com.jfatty.zcloud.alipay.interfaces.IAlipayAccount;
import com.jfatty.zcloud.alipay.req.AlipayAccountReq;
import com.jfatty.zcloud.alipay.res.AlipayAccountRes;
import com.jfatty.zcloud.alipay.service.AlipayAccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 支付宝账号信息
 *
 * @author jfatty on 2020/4/26
 * @email jfatty@163.com
 */
@Api(tags = "支付宝账号信息API" ,value = "支付宝账号信息")
@Slf4j
@RestController
@RequestMapping(value={"/api/alipayAccount"})
public class ApiAlipayAccountController extends ApiBaseAlipayController<AlipayAccount,AlipayAccountReq,AlipayAccountRes> implements IAlipayAccount {


    private AlipayAccountService alipayAccountService ;


    @Autowired
    public void setAlipayAccountService(AlipayAccountService alipayAccountService) {
        super.setBaseService(alipayAccountService);
        this.alipayAccountService = alipayAccountService;
    }


}
