package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.wechat.entity.UserTag;
import com.jfatty.zcloud.wechat.interfaces.IUserTag;
import com.jfatty.zcloud.wechat.req.UserTagReq;
import com.jfatty.zcloud.wechat.res.UserTagRes;
import com.jfatty.zcloud.wechat.service.UserTagService;
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
@RequestMapping("/api/userTag")
public class ApiUserTagController extends ApiBaseWechatController<UserTag,UserTagReq,UserTagRes>  implements IUserTag {

    private UserTagService userTagService ;

    @Autowired
    public void setUserTagService(UserTagService userTagService) {
        super.setBaseService(userTagService);
        this.userTagService = userTagService;
    }
}
