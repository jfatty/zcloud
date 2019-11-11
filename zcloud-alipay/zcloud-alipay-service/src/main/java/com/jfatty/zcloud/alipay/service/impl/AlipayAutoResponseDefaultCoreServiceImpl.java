package com.jfatty.zcloud.alipay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.alipay.entity.AlipayAutoresponseDefault;
import com.jfatty.zcloud.alipay.entity.AlipayNewsitem;
import com.jfatty.zcloud.alipay.entity.AlipayNewstemplate;
import com.jfatty.zcloud.alipay.entity.AlipayTexttemplate;
import com.jfatty.zcloud.alipay.mapper.AlipayAutoresponseDefaultMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayNewsitemMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayNewstemplateMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayTexttemplateMapper;
import com.jfatty.zcloud.alipay.service.AlipayAutoResponseDefaultCoreService;
import com.jfatty.zcloud.alipay.utils.AlipayUtil;
import com.jfatty.zcloud.alipay.vo.SendMessageImageTextOneVo.SendMessageImageText;
import com.jfatty.zcloud.alipay.vo.SendMessageTextOneVo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Service("alipayAutoResponseDefaultCoreService")
@Transactional
public class AlipayAutoResponseDefaultCoreServiceImpl implements AlipayAutoResponseDefaultCoreService {

    @Autowired
    private AlipayTexttemplateMapper alipayTexttemplateMapper ;

    @Autowired
    private AlipayNewstemplateMapper alipayNewstemplateMapper ;

    @Autowired
    private AlipayNewsitemMapper alipayNewsitemMapper ;

    @Autowired
    private AlipayAutoresponseDefaultMapper alipayAutoresponseDefaultMapper ;

    @Override
    public String getWorkDefaultResponse(String toUserid, String accountId) {
        List<AlipayAutoresponseDefault> defaultResponseList = alipayAutoresponseDefaultMapper.getAutoresponseDefault(accountId, "1");
        if(defaultResponseList!=null&&defaultResponseList.size()>0){
            AlipayAutoresponseDefault defaultResponse =  defaultResponseList.get(0);
            String msgType = defaultResponse.getMsgtype();
            String templateId = defaultResponse.getTemplateid();
            String respMessage = "";
            if("text".equals(msgType)){
                AlipayTexttemplate textTemplate = alipayTexttemplateMapper.selectById(templateId);
                if(textTemplate!=null){
                    SendMessage sendMessage = AlipayUtil.wrapperTextMessage(textTemplate, toUserid);
                    respMessage =JSONObject.toJSONString(sendMessage);
                }
            }else if("news".equals(msgType)){
                AlipayNewstemplate newsTemplate = alipayNewstemplateMapper.selectById(templateId);
                if(newsTemplate!=null){
                    List<AlipayNewsitem> newsList = alipayNewsitemMapper.getAlipayNewsitemByTemplateId(newsTemplate.getId());
                    if(newsList!=null&&newsList.size()>0){
                        SendMessageImageText sendMessage = AlipayUtil.wrapperNewsMessage(newsList,toUserid);
                        respMessage =JSONObject.toJSONString(sendMessage);
                    }
                }
            }
            return respMessage;
        }
        return null;
    }
}
