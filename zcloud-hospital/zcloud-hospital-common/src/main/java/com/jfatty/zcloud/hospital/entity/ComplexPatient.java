package com.jfatty.zcloud.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 描述
 *
 * @author jfatty on 2019/12/29
 * @email jfatty@163.com
 */
@Data
@TableName("table_undefined")
public class ComplexPatient  extends Model<ComplexPatient> {


    private String id ;

}
