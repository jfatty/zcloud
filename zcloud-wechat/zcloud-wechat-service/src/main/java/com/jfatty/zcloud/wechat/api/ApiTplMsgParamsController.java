package com.jfatty.zcloud.wechat.api;


import com.jfatty.zcloud.wechat.entity.TplMsgParams;
import com.jfatty.zcloud.wechat.interfaces.ITplMsgParams;
import com.jfatty.zcloud.wechat.req.TplMsgParamsReq;
import com.jfatty.zcloud.wechat.res.TplMsgParamsRes;
import com.jfatty.zcloud.wechat.service.TplMsgParamsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微信模板消息参数配置表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2020-01-05
 */
@Slf4j
@RestController
@RequestMapping("/api/tplMsgParams")
public class ApiTplMsgParamsController extends ApiBaseWechatController<TplMsgParams,TplMsgParamsReq,TplMsgParamsRes>  implements ITplMsgParams {

    private TplMsgParamsService tplMsgParamsService ;

    @Autowired
    public void setTplMsgParamsService(TplMsgParamsService tplMsgParamsService) {
        super.setBaseService(tplMsgParamsService);
        this.tplMsgParamsService = tplMsgParamsService;
    }

}

