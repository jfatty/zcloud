package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.req.RegisterVoReq;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import com.jfatty.zcloud.auth.utils.ShiroKit;
import com.jfatty.zcloud.base.utils.JwtUtil;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 描述 系统注册接口
 *
 * @author jfatty on 2020/7/8
 * @email jfatty@163.com
 */
@Api(tags = "004*****系统注册API" ,value = "系统注册")
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiRegisterController {


    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private UserPasswdService userPasswdService ;

    @ApiOperation(value="001******注册")
    @RequestMapping(value = {"/sell/register"} ,method = RequestMethod.POST)
    public RETResultUtils<String> sellRegister(@RequestBody RegisterVoReq registerVoReq , HttpServletRequest request){
        String phone = registerVoReq.getPhone() ;
        String password = registerVoReq.getPassword() ;
        String kaptcha = registerVoReq.getKaptcha() ;
        if( StringUtils.isEmptyOrBlank(phone) )
            return RETResultUtils._509("手机号不能为空") ;
        if( StringUtils.isEmptyOrBlank(kaptcha) )
            return RETResultUtils._509("验证码不能为空") ;
        if( StringUtils.isEmptyOrBlank(password) )
            return RETResultUtils._509("密码不能为空") ;
        String code = (String) redisTemplate.opsForValue().get(phone);
        if(StringUtils.isEmptyOrBlank(code))
            return RETResultUtils._506("验证码已经失效") ;
        if(!code.equalsIgnoreCase(kaptcha))
            return RETResultUtils._509("验证码错误") ;
        String uid = UUIDGenerator.uuid() ;
        UserPasswd userPasswd = new UserPasswd();
        userPasswd.setId(uid);
        userPasswd.setPhone(phone);
        //生成账号
        String account = UUIDGenerator.genNum(phone) ;
        //密码的盐值
        String salt = ShiroKit.getRandomSalt();
        userPasswd.setSalt(salt);
        userPasswd.setAccount(account);
        userPasswd.setCreateTime(LocalDateTime.now());
        userPasswd.setPassword(ShiroKit.md5(password,userPasswd.getCredentialsSalt()));
        if ( userPasswdService.saveUser(userPasswd) ) {
            Set<String> roles = userPasswdService.getRoles(uid,false);
            Set<String> perms = userPasswdService.getPermissions(uid,false) ;
            Set<String> uris = userPasswdService.getUris(uid,false) ;
            if ( !CollectionUtils.isEmpty(roles) ) {
                userPasswd.setRoles(roles);
            }
            if ( !CollectionUtils.isEmpty(perms) ) {
                userPasswd.setPerms(perms);
            }
            if ( !CollectionUtils.isEmpty(uris) ) {
                userPasswd.setUris(uris);
            }
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("uid",uid);
            claims.put("userName",account);
            claims.put("roles",roles);
            claims.put("perms",perms);
            claims.put("uris",uris);
            String token = JwtUtil.createJWT(uid,account,uid,claims,JwtUtil.TTL) ;
            redisTemplate.opsForValue().set(token,userPasswd);
            return new RETResultUtils(token) ;
        }
        return RETResultUtils.faild("网络延时,请稍后重试");
    }



}
