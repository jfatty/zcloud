package com.jfatty.zcloud.health.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.health.service.HealthCardServiceServer;
import com.tencent.healthcard.exception.FuncRetCode;
import com.tencent.healthcard.exception.RestException;
import com.tencent.healthcard.exception.ServerException;
import com.tencent.healthcard.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述
 *
 * @author jfatty on 2020/1/4
 * @email jfatty@163.com
 */
public abstract class AbstractHealthCardServiceServer implements HealthCardServiceServer {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractHealthCardServiceServer.class);

    public AbstractHealthCardServiceServer() {
    }

    protected JSONObject request(String url, String jsonParam) {
        String result = HttpUtil.post(url, jsonParam);
        if (result == null) {
            throw new ServerException(FuncRetCode.ERROR_CODE_NET_ERROR);
        } else {
            JSONObject jsonObject = JSON.parseObject(result);
            JSONObject commonOut = jsonObject.getJSONObject("commonOut");
            if (commonOut.getInteger("resultCode") != 0) {
                LOG.debug("request url:" + url + ", result:" + result);
                throw new RestException(commonOut.getInteger("resultCode"), commonOut.getString("errMsg"));
            } else {
                LOG.debug("输出参数：" + jsonObject.toJSONString());
                return jsonObject.getJSONObject("rsp");
            }
        }
    }

}
