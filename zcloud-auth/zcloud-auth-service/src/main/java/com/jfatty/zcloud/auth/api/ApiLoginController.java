package com.jfatty.zcloud.auth.api;

import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.auth.req.LoginVoReq;
import com.jfatty.zcloud.auth.req.SellLoginReq;
import com.jfatty.zcloud.auth.res.UserProfileRes;
import com.jfatty.zcloud.auth.service.UserPasswdService;
import com.jfatty.zcloud.auth.utils.JedisUtil;
import com.jfatty.zcloud.auth.utils.JsonUtils;
import com.jfatty.zcloud.auth.utils.PhoneNumUtil;
import com.jfatty.zcloud.base.utils.JwtUtil;
import com.jfatty.zcloud.base.utils.RETResultUtils;
import com.jfatty.zcloud.base.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * 描述
 *
 * @author jfatty on 2019/12/7
 * @email jfatty@163.com
 */
@Api(tags = "002*****登录授权API" ,value = "登录授权")
@Slf4j
@RestController
@RequestMapping(value={"/api"})
public class ApiLoginController {


    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Autowired
    private UserPasswdService userPasswdService ;

    @Autowired
    private JedisUtil jedisUtil ;

    @ApiOperation(value="001******登录")
    @RequestMapping(value = {"/login"} ,method = RequestMethod.POST)
    public RETResultUtils<String> login(@RequestBody LoginVoReq loginVo , HttpServletRequest request){
        //Subject subject = SecurityUtils.getSubject();
        //AuthenticationToken token = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //UsernamePasswordToken upToken = new UsernamePasswordToken(loginVo.getAccount(), loginVo.getPassword());
        //subject.login(upToken);
        //subject.login(token);
        //登录成功就不会报异常
        String phone = loginVo.getAccount() ;
        String msg = PhoneNumUtil.isPhone(phone) ;
        if(StringUtils.isNotEmptyAndBlank(msg))
            return RETResultUtils._509(msg) ;
        if(StringUtils.isEmptyOrBlank(loginVo.getPassword()))
            return RETResultUtils._509("验证码不能为空") ;
        String code = "" ;
        try {
            //code = (String) redisTemplate.opsForValue().get(phone);
            code = stringRedisTemplate.opsForValue().get(phone);
        } catch (Exception e) {
            log.error("====>通过redisTemplate 获取手机号[{}]对应验证码失败尝试通过jedis获取 [{}]",phone,e.getMessage());
            code = jedisUtil.get(phone) ;
        }
        if (StringUtils.isEmptyOrBlank(code)) {
            code = jedisUtil.get(phone) ;
        }
        if(StringUtils.isEmptyOrBlank(code))
            return RETResultUtils._506("验证码已经失效") ;
        if(!code.equalsIgnoreCase(loginVo.getPassword()))
            return RETResultUtils._509("验证码错误") ;
        try {
            //redisTemplate.delete(loginVo.getAccount());
            stringRedisTemplate.delete(loginVo.getAccount());
        } catch (Exception e) {
            log.error("====>通过redisTemplate 删除手机号[{}] 缓存验证码[{}]失败尝试通过jedis删除 [{}]",phone,code,e.getMessage());
            jedisUtil.del(loginVo.getAccount());
        }
        UserPasswd  userPasswd = userPasswdService.getUserByPhone(phone);
        String uid = userPasswd.getId() ;
        String account = userPasswd.getAccount() ;
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
        try{
            redisTemplate.opsForValue().set(token,userPasswd);
        } catch ( Exception e) {
            log.error("====>通过redisTemplate 缓存用户信息失败 token[{}] 尝试用过jedis [{}]",token,e.getMessage());
            //把用户信息写入redis
            jedisUtil.set(token, JsonUtils.objectToJson(userPasswd));
        }
        //redisTemplate.opsForValue().set(token,loginVo,7200,TimeUnit.SECONDS);
        //LoginVoReq login = (LoginVoReq) redisTemplate.opsForValue().get(token);
        log.error("====>   login user info [{}]",userPasswd);
        return new RETResultUtils(token) ;
    }

    @ApiOperation(value="002******获取用户登录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户登录token", required = true , dataType = "String",defaultValue = "QAZXSWEDVRE741258")
    })
    @RequestMapping(value = {"/userProfile"} ,method = RequestMethod.GET)
    public RETResultUtils<UserProfileRes> userProfile(@RequestParam(value = "token" , defaultValue = "QAZXSWEDVRE741258") String token , HttpServletRequest request){
        if(StringUtils.isEmptyOrBlank(token))
            return RETResultUtils._509("token不能为空") ;
        UserPasswd  userPasswd = (UserPasswd) redisTemplate.opsForValue().get(token);
        if ( userPasswd == null)
            return RETResultUtils._506("登录过期") ;
        redisTemplate.opsForValue().set(token,userPasswd);
        UserProfileRes userProfile = new UserProfileRes();
        userProfile.setAccount(userPasswd.getAccount());
        userProfile.setAccEditState(userPasswd.getAccEditState());
        userProfile.setNickName("张三");
        userProfile.setRole("普通用户");
        return new RETResultUtils(userProfile) ;
    }


    @ApiOperation(value="003***微信点餐***获取用户登录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户登录token", required = true , dataType = "String",defaultValue = "QAZXSWEDVRE741258")
    })
    @RequestMapping(value = {"/sell/userProfile"} ,method = RequestMethod.GET)
    public RETResultUtils<UserProfileRes> sellUserProfile(@RequestParam(value = "token" , defaultValue = "QAZXSWEDVRE741258") String token , HttpServletRequest request){
        if(StringUtils.isEmptyOrBlank(token))
            return RETResultUtils._509("token不能为空") ;
        UserPasswd userPasswd = (UserPasswd) redisTemplate.opsForValue().get(token);
        if ( userPasswd == null)
            return RETResultUtils._506("登录过期") ;
        redisTemplate.opsForValue().set(token,userPasswd);
        UserProfileRes userProfile = new UserProfileRes();
        userProfile.setAccount(userPasswd.getAccount());
        userProfile.setPhone(userPasswd.getPhone());
        userProfile.setAccEditState(userPasswd.getAccEditState());
        userProfile.setNickName("");
        userProfile.setAvatar("");
        userProfile.setRole("普通用户");
        return new RETResultUtils(userProfile) ;
    }


    @ApiOperation(value="004***微信点餐***登录")
    @RequestMapping(value = {"/sell/login"} ,method = RequestMethod.POST)
    public RETResultUtils<String> sellLogin(@RequestBody SellLoginReq loginVo , HttpServletRequest request){
        String mode = loginVo.getMode() ;
        String account = loginVo.getAccount() ;
        boolean loginStatus = false ;
        UserPasswd userPasswd = null ;
        if(StringUtils.isEmptyOrBlank(mode))
            return RETResultUtils._509("登录方式不能为空") ;
        if( "KAPTCHA".equals(mode) ){
            String msg = PhoneNumUtil.isPhone(account) ;
            if(StringUtils.isNotEmptyAndBlank(msg))
                return RETResultUtils._509(msg) ;
            if(StringUtils.isEmptyOrBlank(loginVo.getPassword()))
                return RETResultUtils._509("验证码不能为空") ;
            String code = (String) redisTemplate.opsForValue().get(account);
            if(StringUtils.isEmptyOrBlank(code))
                return RETResultUtils._506("验证码已经失效") ;
            if(!code.equalsIgnoreCase(loginVo.getPassword()))
                return RETResultUtils._509("验证码错误") ;
            redisTemplate.delete(loginVo.getAccount());
            //标记登录成功
            loginStatus = true ;
            userPasswd = userPasswdService.getUserByPhone(account) ;
        } else if ( "USERPWD".equals(mode)  ) {
            try {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(account, loginVo.getPassword());
                subject.login(token);
                //标记登录成功
                loginStatus = true ;
                userPasswd = userPasswdService.getUserPasswd(account) ;
            }  catch(UnknownAccountException e){ //登录成功就不会报异常
                return RETResultUtils.faild("用户名或密码错误");
            }catch(AuthenticationException e){
                return RETResultUtils.faild("用户名或密码错误");
            }
        } else {
            return RETResultUtils._509("不支持的登录方式");
        }
        if (loginStatus && userPasswd != null) {
            String uid = userPasswd.getId() ;
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
            claims.put("userName",userPasswd.getAccount());
            claims.put("roles",roles);
            claims.put("perms",perms);
            claims.put("uris",uris);
            String token = JwtUtil.createJWT(uid,userPasswd.getAccount(),uid,claims,JwtUtil.TTL) ;
            redisTemplate.opsForValue().set(token,userPasswd);
            log.error("====>   login user info [{}]",userPasswd);
            return new RETResultUtils(token) ;
        }
        return RETResultUtils.faild("网络异常请稍后重试");
    }




}
