package com.jfatty.zcloud.system.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.entity.User;
import com.jfatty.zcloud.system.interfaces.IUser;
import com.jfatty.zcloud.system.req.UserReq;
import com.jfatty.zcloud.system.res.UserRes;
import com.jfatty.zcloud.system.service.AccountUniqueService;
import com.jfatty.zcloud.system.service.UserService;
import com.jfatty.zcloud.system.utils.AccountValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * 描述
 *
 * @author jfatty on 2019/11/1
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/user"})
public class ApiUserController extends ApiBaseSystemController<User,UserReq,UserRes>  implements IUser {

    @Autowired
    private AccountUniqueService accountUniqueService ;

    private UserService userService ;

    @Autowired
    public void setUserService(UserService userService) {
        super.setBaseService(userService);
        this.userService = userService;
    }


    @RequestMapping(value={"/getUserInfo"},method=RequestMethod.GET)
    public User getUserInfo(String id) throws Exception {
        User user = userService.getUserInfoById(id);
        log.error("===================>"+user);
        return user  ;
    }

    @RequestMapping(value={"/validate"},method=RequestMethod.POST)
    public ResultUtils validate(HttpServletRequest request, HttpSession session, @RequestBody Map<String,Object> params) throws Exception {
        String value = (String)params.get("validateVal") ;
        String identity = (String)params.get("identity") ;
        if(StringUtils.isBlank(value) || StringUtils.isEmpty(value)){
            return ResultUtils.build(200, "账号/身份证号/手机号不能为空!") ;
        }
        String msg = "" ;
        QueryWrapper<AccountUnique> qw = new QueryWrapper<AccountUnique>() ;
        //身份证号码
        if(AccountValidatorUtil.isIDCard(value)){
            qw.eq("id_card",value);
            msg = "身份证号码" ;
            //手机号
        }else if (AccountValidatorUtil.isMobile(value)){
            qw.eq("tel",value);
            msg = "手机号" ;
        }else {
            //账号
            qw.eq("user_name",value);
            msg = "账号" ;
        }
        if(StringUtils.isNotBlank(identity) || StringUtils.isNotEmpty(identity)){
            qw.ne("id",identity);
        }
        List<AccountUnique> list = accountUniqueService.list(qw);
        if(list != null && list.size() > 0)
            return ResultUtils.build(200, msg + "已被使用,请重新输入!") ;
        return ResultUtils.build(200, "") ;
    }



}
