package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.wechat.entity.TplMsgText;
import com.jfatty.zcloud.wechat.interfaces.ITplMsgText;
import com.jfatty.zcloud.wechat.service.TplMsgTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/api/tplMsgText")
public class ApiTplMsgTextController extends ApiBaseWechatController<TplMsgText>  implements ITplMsgText {

    private TplMsgTextService tplMsgTextService ;

    @Autowired
    public void setTplMsgTextService(TplMsgTextService tplMsgTextService) {
        super.setBaseService(tplMsgTextService);
        this.tplMsgTextService = tplMsgTextService;
    }
}
