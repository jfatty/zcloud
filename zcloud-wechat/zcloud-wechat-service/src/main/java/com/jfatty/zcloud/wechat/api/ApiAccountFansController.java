package com.jfatty.zcloud.wechat.api;

import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.entity.AccountFans;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.interfaces.IAccountFans;
import com.jfatty.zcloud.wechat.service.AccountFansService;
import com.jfatty.zcloud.wechat.service.WxService;
import com.jfatty.zcloud.wechat.utils.WxMemoryCacheClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 微信粉丝表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */

@Slf4j
@RestController
@RequestMapping("/api/accountFans")
public class ApiAccountFansController extends ApiBaseWechatController<AccountFans>  implements IAccountFans {


    @Autowired
    private WxService wxService ;

    private AccountFansService accountFansService;

    @Autowired
    public void setAccountFansService(AccountFansService accountFansService) {
        super.setBaseService(accountFansService);
        this.accountFansService = accountFansService;
    }


    /**
     * 描述 获取表格数据
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="获取微信账号表格数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "v", value = "时间戳",dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "页码",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数",dataType = "Integer"),
            @ApiImplicitParam(name = "nickname", value = "搜索昵称采用GET方式传送通过URL两次编码后台解码",dataType = "String")
    })
    @Override
    public RELResultUtils<AccountFans> table(String v, Integer pageIndex, Integer pageSize) {
        return super.table(v, pageIndex, pageSize);
    }


    /**
     * 描述 预览修改编辑
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="修改前回显数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户粉丝ID", value = "id",dataType = "String")
    })
    @Override
    public Object view(String id) {
        return super.view(id);
    }

    //同步粉丝列表
    @RequestMapping(value = "/accountFans/syncAccountFansList")
    @ResponseBody
    public Object syncAccountFansList() throws WxErrorException {
        Account mpAccount = WxMemoryCacheClient.getMpAccount();//获取缓存中的唯一账号
        if(mpAccount != null){
            boolean flag = wxService.syncAccountFansList(mpAccount);
            if(flag)
                return ResultUtils.ok();
        }
        return ResultUtils.failure(500,"同步粉丝列表失败");
    }
}
