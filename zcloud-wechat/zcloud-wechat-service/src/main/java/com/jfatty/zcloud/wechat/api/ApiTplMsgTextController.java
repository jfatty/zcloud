package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.wechat.entity.TplMsgText;
import com.jfatty.zcloud.wechat.interfaces.ITplMsgText;
import com.jfatty.zcloud.wechat.req.TplMsgTextReq;
import com.jfatty.zcloud.wechat.res.TplMsgTextRes;
import com.jfatty.zcloud.wechat.service.TplMsgTextService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 微信模板消息
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "微信模板消息API" ,value = "微信模板消息")
@Slf4j
@RestController
@RequestMapping("/api/tplMsgText")
public class ApiTplMsgTextController extends ApiBaseWechatController<TplMsgText,TplMsgTextReq,TplMsgTextRes>  implements ITplMsgText {

    private TplMsgTextService tplMsgTextService ;

    @Autowired
    public void setTplMsgTextService(TplMsgTextService tplMsgTextService) {
        super.setBaseService(tplMsgTextService);
        this.tplMsgTextService = tplMsgTextService;
    }
}
