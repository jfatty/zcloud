package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.entity.MsgNews;
import com.jfatty.zcloud.wechat.service.AccountService;
import com.jfatty.zcloud.wechat.service.MsgNewsService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping("/api/msgNews")
public class ApiMsgNewsController {


    @Autowired
    private MsgNewsService msgNewsService ;

    @Autowired
    private AccountService accountService ;

    /**
     * @description:最新文章列表获取
     * @author jfatty
     * @date 2018年7月26日
     * @version 1.0.0
     * @param request
     * @return
     */
    @ApiOperation(value="获取最新文章列表数据")
    @RequestMapping("/list")
    public ResultUtils list() {
        Account mpAccount = accountService.getActiveAccount() ;
        MsgNews msgNews = new MsgNews();
        msgNews.setAccount(mpAccount.getAccount());
        List<MsgNews> list = msgNewsService.listMsgNewsList(msgNews);
        if(list != null && list.size() > 0) {
            return ResultUtils.ok(list);
        }
        return ResultUtils.build(401, "没有查询到数据");
    }

}
