package com.jfatty.zcloud.filter;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.msg.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author jfatty on 2019/12/6
 * @email jfatty@163.com
 */
@Slf4j
@Component
public class AccessGatewayFilter  implements GlobalFilter {


    private static final String startWith = "/login,/logout,/kaptcha,/alipay,/wx,/healthCardInfo,/idCardInfo,/healthCardSettings,/healthCardStation,/healthCardUser" +
            ",/menu,/bannerImg,/pageSettings" +
            ",/pageImage,/reportView,/electronicDoc" +
            ",/webPriceinfo,/registration,/complexPay" +
            ",/payOrder,/payNotify,/queueProgress" +
            ",/electronicCard,/protocol,/sysPatientInfo" +
            ",/wepayConfig,/alipayConfig,/pageHref"; //

    private static final String GATE_WAY_PREFIX = "/api";


    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("check token and user permission....");
        LinkedHashSet requiredAttribute = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        ServerHttpRequest request = exchange.getRequest();
        String requestUri = request.getPath().pathWithinApplication().value();
        if (requiredAttribute != null) {
            Iterator<URI> iterator = requiredAttribute.iterator();
            while (iterator.hasNext()){
                URI next = iterator.next();
                if(next.getPath().startsWith(GATE_WAY_PREFIX)){
                    requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
                }
            }
        }

        final String method = request.getMethod().toString();
        //BaseContextHandler.setToken(null);
        ServerHttpRequest.Builder mutate = request.mutate();
        // 不进行拦截的地址 例如 登录 发送验证码 支付宝 微信API 操作
        if ( isStartWith(requestUri) ) {
            ServerHttpRequest build = mutate.build();
            return chain.filter(exchange.mutate().request(build).build());
        }
        BaseResponse response = listRequest(request,mutate);
        if (!response.success())
            return getVoidMono(exchange, response);
        //其他情况下 校验是否登录
        if ( requestUri.contains("error") ) {
            //return getVoidMono(exchange, new BaseResponse(40301,"User Token Forbidden or Expired! " + method));
            return getVoidMono(exchange, new BaseResponse(401,"登录过期,请重新登录"));
        }
        ServerHttpRequest build = mutate.build();
        return chain.filter(exchange.mutate().request(build).build());
    }

    private BaseResponse listRequest(ServerHttpRequest request, ServerHttpRequest.Builder ctx) {
        String requestUri = request.getPath().pathWithinApplication().value();
        //校验请求路径 用户是否登录
        HttpHeaders headers = request.getHeaders();
        Set<Map.Entry<String, List<String>>> stes =  headers.entrySet();
        for (Map.Entry<String, List<String>> entry : stes) {
            entry.getValue().forEach(
                    strValue -> {
                        log.error("key: [{}]  value: [{}]" ,entry.getKey(),strValue );
                    }
            );
        }
        List<String>  strings = request.getHeaders().get("token");
        String authToken = null;
        if (CollectionUtils.isEmpty(strings)){
            strings = request.getQueryParams().get("token");
            if (!CollectionUtils.isEmpty(strings))
                authToken = strings.get(0);
        } else {
            authToken = strings.get(0);
        }
        if ( StringUtils.isEmpty(authToken) || StringUtils.isBlank(authToken)){
            log.error("校验请求路径[{}] 用户是否登录  token为空 用户尚未登录",requestUri);
            return new BaseResponse(401,"您尚未登录");
        } else {
            if (redisTemplate.hasKey(authToken)){
                log.error("校验请求路径[{}] 用户是否登录 更新 token===>[{}] 过期时间",requestUri,authToken);
                redisTemplate.expire(authToken,7200,TimeUnit.SECONDS);
                return new BaseResponse(200,"登录成功");
            }
            log.error("校验请求路径[{}] 用户登录已过期 token===>[{}] ",requestUri,authToken);
            return new BaseResponse(401,"登录过期,请重新登录");

        }

    }

    /**
     * 网关抛异常
     *
     * @param body
     */
    //@NotNull
    private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, BaseResponse body) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }

}
