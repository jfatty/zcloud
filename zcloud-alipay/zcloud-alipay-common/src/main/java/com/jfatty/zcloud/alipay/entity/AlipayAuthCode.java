package com.jfatty.zcloud.alipay.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("alipay_auth_code")
public class AlipayAuthCode extends Model<AlipayAuthCode> {


    private String id ;

    private String authCode ;

    private String appid ;


}
