package com.jfatty.zcloud.wechat.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.base.utils.UUIDGenerator;
import com.jfatty.zcloud.wechat.constants.Constants;
import com.jfatty.zcloud.wechat.entity.*;
import com.jfatty.zcloud.wechat.exception.WxErrorException;
import com.jfatty.zcloud.wechat.interfaces.IAccountMenu;
import com.jfatty.zcloud.wechat.req.AccountMenuReq;
import com.jfatty.zcloud.wechat.res.AccountMenuRes;
import com.jfatty.zcloud.wechat.service.*;
import com.jfatty.zcloud.wechat.utils.WxMemoryCacheClient;
import com.jfatty.zcloud.wechat.utils.wx.ErrCode;
import com.jfatty.zcloud.wechat.utils.wx.WxUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 微信菜单表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-04-07
 */
@Api(tags = "微信菜单API" ,value = "微信菜单")
@Slf4j
@RestController
@RequestMapping("/api/accountMenu")
public class ApiAccountMenuController extends ApiBaseWechatController<AccountMenu,AccountMenuReq,AccountMenuRes>  implements IAccountMenu {

    @Autowired
    private WxService wxService ;

    private AccountMenuService accountMenuService;

    @Autowired
    private MsgTextService msgTextService ;

    @Autowired
    private MsgNewsService msgNewsService ;

    @Autowired
    private AccountService accountService ;

    @Autowired
    public void setAccountMenuService(AccountMenuService accountMenuService) {
        super.setBaseService(accountMenuService);
        this.accountMenuService = accountMenuService;
    }


    @Override
    public ResultUtils list() {
        System.out.println("==============================>菜单获取");
        Account account = accountService.getActiveAccount() ;
        List<AccountMenu> menus = accountMenuService.selectWxMenus(account.getAccount());
        MsgText msgText = new MsgText() ;
        msgText.setAccount(account.getAccount());
        List<MsgText> msgTextList = msgTextService.getMsgTextList(msgText);
        MsgNews msgNew = new MsgNews();
        msgNew.setAccount(account.getAccount());
        List<MsgNews> msgNews = msgNewsService.listMsgNewsList(msgNew);
        Matchrule matchrule = new Matchrule();
        return ResultUtils.ok(WxUtil.prepareMenus(menus, matchrule,msgTextList,msgNews));
    }

    @RequestMapping(value = "/menus")
    public Object menus() {
        //String account = WxMemoryCacheClient.getAccount();
        String account = accountService.getActiveAccount().getAccount() ;
        List<AccountMenu> menus = accountMenuService.selectWxMenus(account);
        MsgText msgText = new MsgText() ;
        msgText.setAccount(account);
        List<MsgText> msgTextList = msgTextService.getMsgTextList(msgText);
        MsgNews msgNew = new MsgNews();
        msgNew.setAccount(account);
        List<MsgNews> msgNews = msgNewsService.listMsgNewsList(msgNew);
        Matchrule matchrule = new Matchrule();
        return ResultUtils.ok(WxUtil.prepareMenus(menus, matchrule,msgTextList,msgNews));
    }


    @RequestMapping(value = "/saveMenu" ,method=RequestMethod.POST )
    public ResultUtils save(String menus)  {
        Account account = accountService.getActiveAccount() ;
        AccountMenu delMenu =  new AccountMenu() ;
        delMenu.setAccount(account.getAccount());
        JSONArray jsons = JSONArray.parseArray(menus);
        //每次先行删除公众号所有菜单
        try {
            accountMenuService.deleteMenu(delMenu);
            if (CollectionUtils.isNotEmpty(jsons)) {
                for (int i = 0; i < jsons.size(); i++) {
                    JSONObject json = jsons.getJSONObject(i);
                    if (null != json) {
                        AccountMenu accountMenu = new AccountMenu();
//					String pid = CommonUtil.getUID();
//					accountMenu.setId(pid);
                        accountMenu.setName(json.getString("name"));
                        accountMenu.setSort(i + 1);
                        accountMenu.setParentId("0");
                        if (json.containsKey("type")) {
                            accountMenu.setMtype(json.getString("type"));
                            //判断是否设置key
                            if (Constants.MENU_NEED_KEY.contains(json.getString("type"))) {
                                accountMenu.setEventType("fix");
                                accountMenu.setMsgType(json.getString("msgType"));
                                accountMenu.setMsgId(json.getString("msgId"));
                            }
                        }
                        if (json.containsKey("url")) {
                            accountMenu.setUrl(json.getString("url"));
                        }
                        if (json.containsKey("media_id")) {
                            accountMenu.setMsgId(json.getString("media_id"));
                        }
                        accountMenu.setId(UUIDGenerator.uuid());
                        //accountMenu.setCreateOperator(user.getId());
                        //accountMenu.setRealm(user.getRealm());
                        accountMenu.setAccount(account.getAccount());
                        //保存
                        accountMenuService.save(accountMenu);
                        //判断是否有subbutton
                        if (json.containsKey("sub_button")) {
                            JSONArray buttons = json.getJSONArray("sub_button");
                            if (CollectionUtils.isNotEmpty(buttons)) {
                                String pid = accountMenu.getId();
                                for (int j = 0; j < buttons.size(); j++) {
                                    json = buttons.getJSONObject(j);
                                    accountMenu = new AccountMenu();
                                    accountMenu.setParentId(pid);
                                    accountMenu.setName(json.getString("name"));
                                    accountMenu.setSort(j + 1);
                                    if (json.containsKey("type")) {
                                        accountMenu.setMtype(json.getString("type"));
                                        //判断是否设置key
                                        if (Constants.MENU_NEED_KEY.contains(json.getString("type"))) {
                                            accountMenu.setEventType("fix");
                                            accountMenu.setMsgType(json.getString("msgType"));
                                            accountMenu.setMsgId(json.getString("msgId"));
                                        }
                                    }
                                    if (json.containsKey("url")) {
                                        accountMenu.setUrl(json.getString("url"));
                                    }
                                    if (json.containsKey("media_id")) {
                                        accountMenu.setMsgId(json.getString("media_id"));
                                    }
                                    accountMenu.setId(UUIDGenerator.uuid());
                                    //accountMenu.setCreateOperator(user.getId());
                                    //accountMenu.setRealm(user.getRealm());
                                    accountMenu.setAccount(account.getAccount());
                                    accountMenuService.save(accountMenu);
                                }
                            }
                        }
                    }
                }
            }
            return  ResultUtils.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResultUtils.failure(501,"菜单保存失败");
    }


    //查看当前公众号中已存在的菜单列表
    @RequestMapping(value = "/wcloud")
    public Object wcloud() throws WxErrorException {
        String account = accountService.getActiveAccount().getAccount() ;
        //String account = WxMemoryCacheClient.getAccount();
        if(account == null )
            return  ResultUtils.failure(501,"缓存中不存在微信账号信息");
        Account mpAccount = WxMemoryCacheClient.getMpAccount(account);
        JSONObject rstObj =  wxService.getMenu(mpAccount);
        return ResultUtils.ok(rstObj);
    }

    //创建(发布)微信公众账号菜单
    @RequestMapping(value = "/publishMenu" , method=RequestMethod.GET )
    public ResultUtils publishMenu() throws WxErrorException  {
        JSONObject rstObj = null;
        //Account mpAccount = WxMemoryCacheClient.getMpAccount();
        Account mpAccount = accountService.getActiveAccount() ;
        if(mpAccount != null){
            rstObj = wxService.publishMenu(mpAccount);
            if(rstObj != null){//成功，更新菜单组
                if(rstObj.containsKey("menu_id")){
                    return ResultUtils.ok("创建菜单成功");
                }else if(rstObj.containsKey("errcode") && rstObj.getIntValue("errcode") == 0){
                    return ResultUtils.ok("创建菜单成功");
                }
            }
        }
        String failureMsg = "创建菜单失败，请检查菜单：可创建最多3个一级菜单，每个一级菜单下可创建最多5个二级菜单。";
        if(rstObj != null){
            failureMsg += ErrCode.errMsg(rstObj.getIntValue("errcode"));
        }
        return ResultUtils.failure(501,failureMsg);
    }

    //删除微信公众账号菜单
    @RequestMapping(value = "/deleteMenu")
    public ResultUtils deleteMenu(HttpServletRequest request) throws WxErrorException {
        JSONObject rstObj = null;
        Account account = accountService.getActiveAccount() ;
        if(account != null){
            rstObj = wxService.deleteMenu(account);
            if(rstObj != null && rstObj.getIntValue("errcode") == 0)
                return ResultUtils.ok("删除菜单成功");
        }
        String failureMsg = "删除菜单失败";
        if(rstObj != null){
            failureMsg += ErrCode.errMsg(rstObj.getIntValue("errcode"));
        }
        return ResultUtils.failure(501,failureMsg);
    }


}
