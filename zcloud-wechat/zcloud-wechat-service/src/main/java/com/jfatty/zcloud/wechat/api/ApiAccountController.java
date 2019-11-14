package com.jfatty.zcloud.wechat.api;


import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.wechat.entity.Account;
import com.jfatty.zcloud.wechat.interfaces.IAccount;
import com.jfatty.zcloud.wechat.service.AccountService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 微信账号表 前端控制器
 * </p>
 *
 * @author jfatty
 * @since 2019-04-04
 */
@Slf4j
@RestController
@RequestMapping("/api/account")
public class ApiAccountController extends ApiBaseWechatController<Account>  implements IAccount {


    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        super.setBaseService(accountService);
        this.accountService = accountService;
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
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数",dataType = "Integer")
    })
    @Override
    public RELResultUtils<Account> table(String v, Integer pageIndex, Integer pageSize) {
        return super.table(v, pageIndex, pageSize);
    }



    @Override
    public List<Account> list() {
        return super.list();
    }

    /**
     * 描述 新增
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="新增账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json包微信数据数据", value = "account",dataType = "json")
    })
    @Override
    public Object save(Account entity) {
        return super.save(entity);
    }


    /**
     * 描述 预览修改编辑
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="修改前回显数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "微信账号ID", value = "id",dataType = "String")
    })
    @Override
    public Object view(String id) {
        return super.view(id);
    }


    /**
     * 描述 修改
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="修改微信账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json包微信账号数据", value = "account",dataType = "json")
    })
    @Override
    public Object edit(Account entity) {
        return super.edit(entity);
    }


    /**
     * 描述 单删 或者 批量删除
     * @author jfatty
     * 创建时间：2018年6月13日
     */
    @ApiOperation(value="删除微信账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json包微信账号数据", value = "ids",dataType = "json")
    })
    @Override
    public Object delete(Map<String, Object> params) {
        return super.delete(params);
    }
}