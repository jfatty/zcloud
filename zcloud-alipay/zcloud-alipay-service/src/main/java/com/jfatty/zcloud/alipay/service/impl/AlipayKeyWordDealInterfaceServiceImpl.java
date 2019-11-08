package com.jfatty.zcloud.alipay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.alipay.entity.*;
import com.jfatty.zcloud.alipay.mapper.AlipayAutoresponseMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayNewsitemMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayNewstemplateMapper;
import com.jfatty.zcloud.alipay.mapper.AlipayTexttemplateMapper;
import com.jfatty.zcloud.alipay.service.AlipayKeyWordDealInterfaceService;
import com.jfatty.zcloud.alipay.utils.AlipayUtil;
import com.jfatty.zcloud.alipay.vo.SendMessageImageTextOneVo.SendMessageImageText;
import com.jfatty.zcloud.alipay.vo.SendMessageTextOneVo.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2019/11/8
 * @email jfatty@163.com
 */
@Slf4j
@Service("alipayKeyWordDealInterfaceService")
@Transactional
public class AlipayKeyWordDealInterfaceServiceImpl implements AlipayKeyWordDealInterfaceService {

    @Autowired
    private AlipayAutoresponseMapper alipayAutoresponseMapper ;

    @Autowired
    private AlipayTexttemplateMapper alipayTexttemplateMapper ;

    @Autowired
    private AlipayNewstemplateMapper alipayNewstemplateMapper ;

    @Autowired
    private AlipayNewsitemMapper alipayNewsitemMapper ;

    @Override
    public String dealKeyMessage(String content, AlipayConfig config , String toUserid) {
        String responseMessage = "";
        List<AlipayAutoresponse> autoList = alipayAutoresponseMapper.getAlipayAutoresponseByAccountid(config.getAccountid());
        //---------【测试】auhthor2.0  网页授权--------------------
        if("授权测试".equals(content)){
            AlipayTexttemplate textTemplate = new AlipayTexttemplate();
            String testurl = "/alipay/alipayGzuserinfo.do?userinfo";
            try {
                String authurl="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+config.getAppid()+"&scope=auth_userinfo&redirect_uri="+URLEncoder.encode(testurl, "GBK");
                textTemplate.setTemplateContent("<a href='"+authurl+"'>授权测试，点击后获取用户信息</a>");
                SendMessage sendMessage = AlipayUtil.wrapperTextMessage(textTemplate, toUserid);
                responseMessage =JSONObject.toJSONString(sendMessage);
                return responseMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //---------【测试】auhthor2.0 静默授权--------------------
        if("静默授权".equals(content)){
            AlipayTexttemplate textTemplate = new AlipayTexttemplate();
            String testurl = "/alipay/alipayGzuserinfo.do?userinfo";
            try {
                String authurl="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+config.getAppid()+"&scope=auth_base&redirect_uri="+URLEncoder.encode(testurl, "GBK");
                textTemplate.setTemplateContent("<a href='"+authurl+"'>静默授权测试，点击后获取用户信息</a>");
                SendMessage sendMessage = AlipayUtil.wrapperTextMessage(textTemplate, toUserid);
                responseMessage =JSONObject.toJSONString(sendMessage);
                return responseMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(AlipayAutoresponse autoResponse:autoList){
            String keyWord = autoResponse.getKeyWord();
            //如果含有字母，则把所有字母都变成小写，进行匹配
            if(content.toLowerCase().indexOf(keyWord.toLowerCase())>=0){
                String lx = autoResponse.getMsgType();
                String tempalteId = autoResponse.getResContent();
                if("text".equals(lx)){
                    AlipayTexttemplate textTemplate = alipayTexttemplateMapper.selectById(tempalteId) ;
                    if(textTemplate!=null){
                        SendMessage sendMessage = AlipayUtil.wrapperTextMessage(textTemplate, toUserid);
                        responseMessage =JSONObject.toJSONString(sendMessage);
                    }
                }else if("news".equals(lx)){
                    AlipayNewstemplate newsTemplate = alipayNewstemplateMapper.selectById(tempalteId);
                    if(newsTemplate!=null){
                        List<AlipayNewsitem> newsList = alipayNewsitemMapper.getAlipayNewsitemByTemplateId(newsTemplate.getId());
                        if(newsList!=null&&newsList.size()>0){
                            SendMessageImageText sendMessage = AlipayUtil.wrapperNewsMessage(newsList,toUserid);
                            responseMessage =JSONObject.toJSONString(sendMessage);
                        }
                    }
                }
                break;
            }
        }
        return responseMessage;
    }
}
