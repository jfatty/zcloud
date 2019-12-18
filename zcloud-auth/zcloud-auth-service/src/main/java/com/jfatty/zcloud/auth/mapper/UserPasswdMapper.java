package com.jfatty.zcloud.auth.mapper;


import com.jfatty.zcloud.auth.entity.UserPasswd;
import com.jfatty.zcloud.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述
 *
 * @author jfatty on 2019/12/8
 * @email jfatty@163.com
 */
public interface UserPasswdMapper extends IBaseMapper<UserPasswd> {


    UserPasswd getUserPasswd(@Param("account") String account);

}
