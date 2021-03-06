package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.wechat.entity.MsgText;
import com.jfatty.zcloud.wechat.interfaces.IMsgText;
import com.jfatty.zcloud.wechat.req.MsgTextReq;
import com.jfatty.zcloud.wechat.res.MsgTextRes;
import com.jfatty.zcloud.wechat.service.MsgTextService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述 微信文本消息
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Api(tags = "微信文本消息API" ,value = "微信文本消息")
@Slf4j
@RestController
@RequestMapping("/api/msgText")
public class ApiMsgTextController extends ApiBaseWechatController<MsgText,MsgTextReq,MsgTextRes>  implements IMsgText {

    private MsgTextService msgTextService ;

    @Autowired
    public void setMsgTextService(MsgTextService msgTextService) {
        super.setBaseService(msgTextService);
        this.msgTextService = msgTextService;
    }
}
