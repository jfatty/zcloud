package com.jfatty.zcloud.health.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述 描述 HIS 存储过程返回基本字段
 * @author jfatty on 2019/4/4
 * @email jfatty@163.com
 */
@Data
public class BaseResponse implements Serializable {

    /**
     * 返回编码
     * 1表示操作成功
     * 其他代码表示操作失败
     * 随带返回提示信息信息
     */
    protected Integer Code ;

    /**
     * 操作后返回的提示信息
     */
    protected String Msg ;

    /**
     * HIS返回扩展字段
     */
    protected String Ext1 = "" ;

    /**
     * HIS返回扩展字段
     */
    protected String Ext2  = "" ;

    /**
     * HIS返回扩展字段
     */
    protected String Ext3  = "" ;

    /**
     * 根据Code判断本次调用存储过程是否成功
     * @return
     */
    public boolean success(){
        if(Code != null && Code == 0)
            return  true ;
        return false ;
    }

    /**
     * 调用存储过程出错时获取错误消息
     * @return
     */
    public String errMsg(){
        if (Msg != null && !"".equals(Msg)) {
            return Msg;
        }
        return "" ;
    }


}
