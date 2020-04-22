package com.jfatty.zcloud.hospital.api;


import com.jfatty.zcloud.hospital.entity.MailConfig;
import com.jfatty.zcloud.hospital.interfaces.IMailConfig;
import com.jfatty.zcloud.hospital.req.MailConfigReq;
import com.jfatty.zcloud.hospital.res.MailConfigRes;
import com.jfatty.zcloud.hospital.service.MailConfigService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 智慧医疗邮件发送配置 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-04-22
 */
@Api(tags = "智慧医疗邮件发送配置API" ,value = "智慧医疗邮件发送配置")
@Slf4j
@RestController
@RequestMapping("/api/mailConfig")
public class ApiMailConfigController extends ApiBaseHospitalController<MailConfig,MailConfigReq,MailConfigRes> implements IMailConfig {

    private MailConfigService mailConfigService ;

    @Autowired
    public void setMailConfigService(MailConfigService mailConfigService) {
        super.setBaseService(mailConfigService);
        this.mailConfigService = mailConfigService;
    }

}

