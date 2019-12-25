package com.jfatty.zcloud.filter;

import com.alibaba.fastjson.JSONObject;
import com.jfatty.zcloud.msg.BaseResponse;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 描述
 *
 * @author jfatty on 2019/12/6
 * @email jfatty@163.com
 */
@Slf4j
@Component
public class AccessGatewayFilter  implements GlobalFilter {


    private static final String startWith = "/login,/logout,/kaptcha";

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
        // 不进行拦截的地址 例如 登录 操作
        if ( isStartWith(requestUri) ) {
            ServerHttpRequest build = mutate.build();
            return chain.filter(exchange.mutate().request(build).build());
        }
        listRequest(request);
        //其他情况下 校验是否登录
        if ( requestUri.contains("error") ) {
            return getVoidMono(exchange, new BaseResponse(40301,"User Token Forbidden or Expired! " + method));
        }
        ServerHttpRequest build = mutate.build();
        return chain.filter(exchange.mutate().request(build).build());
    }

    private void listRequest(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        Set<Map.Entry<String, List<String>>> stes =  headers.entrySet();
        for (Map.Entry<String, List<String>> entry : stes) {
            entry.getValue().forEach(
                    strValue -> {
                        log.error("key: [{}]  value: [{}]" ,entry.getKey(),strValue );
                    }
            );

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
