package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述 HIS库挂号预约信息
 *
 * @author jfatty on 2019/12/18
 * @email jfatty@163.com
 */
@Data
@TableName("gh_yyxx")
public class RegisteredInfo implements Serializable {

    private String id ; //yyh充当ID

    private String name ;

    private String idCard ;

    private String preTreatTime ;// 预就诊时间


}
