package com.jfatty.zcloud.wechat.entity;



import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 描述 发送的模板消息对象
 * @author jfatty on 2019/4/21
 * @email jfatty@163.com
 */
@Data
public class TemplateMessage implements Serializable {

    private String openid;//粉丝id
    private String templateId;//模板id
    private String url;//链接
    private String color = "#173177";//颜色
    private Map<String,String> dataMap;//参数数据

    @Override
    public String toString(){
        JSONObject jsObj = new JSONObject();
        jsObj.put("touser", openid);
        jsObj.put("template_id", templateId);
        jsObj.put("url", url);

        JSONObject data = new JSONObject();
        if(dataMap != null){
            for(String key : dataMap.keySet()){
                JSONObject item = new JSONObject();
                item.put("value", dataMap.get(key));
                item.put("color", color);
                data.put(key,item);
            }
        }
        jsObj.put("data", data);
        return jsObj.toString();
    }

}
