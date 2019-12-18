package com.jfatty.zcloud.system.controller;

import com.jfatty.zcloud.base.controller.IBaseController;
import com.jfatty.zcloud.base.utils.RELResultUtils;
import com.jfatty.zcloud.base.utils.ResultUtils;
import com.jfatty.zcloud.system.entity.User;
import com.jfatty.zcloud.system.feign.UserFeignClient;
import com.jfatty.zcloud.system.req.UserReq;
import com.jfatty.zcloud.system.res.UserRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/user"})
public class UserController implements IBaseController<User,UserReq,UserRes> {

    @Autowired
    private UserFeignClient userFeignClient ;

    @Override
    public RELResultUtils<UserRes> table(Map<String, Object> params) {
        return userFeignClient.table(params);
    }

    @Override
    public RELResultUtils<UserRes> table(String v, Integer pageIndex, Integer pageSize) {
        return userFeignClient.table(v, pageIndex, pageSize);
    }

    @Override
    public Object list() {
        return userFeignClient.list();
    }

    @Override
    public List<UserRes> list(Long v) {
        return userFeignClient.list(v);
    }

    @Override
    public Object save(UserReq entity) {
        return userFeignClient.save(entity);
    }

    @Override
    public Object view(String id) {
        return userFeignClient.view(id);
    }

    @Override
    public Object edit(UserReq entity) {
        return userFeignClient.edit(entity);
    }

    @Override
    public Object delete(Map<String, Object> params) {
        return userFeignClient.delete(params);
    }

    @RequestMapping(value={"/getUserInfo"},method=RequestMethod.GET)
    public Object getUserInfo(HttpServletRequest request, HttpSession session) throws Exception {
        return new ResultUtils(userFeignClient.getUserInfoById("4028819069B8658C0169B8658C700000"))  ;
    }
}
