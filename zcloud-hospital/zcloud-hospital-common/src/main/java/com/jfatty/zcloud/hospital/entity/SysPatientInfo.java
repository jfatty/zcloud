package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * 描述 系统病人信息
 *
 * @author jfatty on 2019/12/12
 * @email jfatty@163.com
 */
@Data
@TableName("xt_brxx")
public class SysPatientInfo  extends Model<SysPatientInfo> {

    private String id ;

    private String name ;

    private String sex ;

    private String cardNum ;

    private String idCard ;

}
