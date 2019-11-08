package com.jfatty.zcloud.alipay.jw;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayMobilePublicFollowListRequest;
import com.alipay.api.request.AlipayMobilePublicGisGetRequest;
import com.alipay.api.response.AlipayMobilePublicFollowListResponse;
import com.alipay.api.response.AlipayMobilePublicGisGetResponse;
import com.jfatty.zcloud.alipay.core.AlipayClientFactory;
import com.jfatty.zcloud.alipay.entity.AlipayConfig;
import com.jfatty.zcloud.alipay.vo.GetUserInfoMateonVo.GetAddress;
import com.jfatty.zcloud.alipay.vo.GetUserInfoMateonVo.GetUserInfoMateon;


/**
 *
 * 关注用户
 * 
 */
public class JwGetUserInforMationAPI {

	/**
	 * 获取关注者列表
	 * 
	 * @param appAuthToken
	 * @param model
	 * @return
	 * @throws AlipayApiException
	 */
	public static AlipayMobilePublicFollowListResponse followlistQuery(String appAuthToken, GetUserInfoMateon model, AlipayConfig config) throws AlipayApiException {
		AlipayMobilePublicFollowListRequest request = new AlipayMobilePublicFollowListRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		String json = JSONObject.toJSONString(model);
		request.setBizContent(json);
		return AlipayClientFactory.getAlipayClientInstance(config).execute(request);
	}

	/**
	 * 获取用户地理位置
	 * 
	 * @param appAuthToken
	 * @param model
	 * @return
	 * @throws AlipayApiException
	 */
	public static AlipayMobilePublicGisGetResponse gisget(String appAuthToken, GetAddress model, AlipayConfig config) throws AlipayApiException {
		AlipayMobilePublicGisGetRequest request = new AlipayMobilePublicGisGetRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		String json = JSONObject.toJSONString(model);
		request.setBizContent(json);
		return AlipayClientFactory.getAlipayClientInstance(config).execute(request);
	}

}
