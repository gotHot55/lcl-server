package com.micro.lcl.gataway.filter;

import cn.hutool.json.JSONUtil;
import com.micro.lcl.common.api.ResponseCode;
import com.micro.lcl.common.api.ResponseResult;
import com.micro.lcl.common.exception.TokenAuthenticationException;
import com.micro.lcl.common.utils.JWTUtil;
import com.micro.lcl.common.utils.MD5Util;
import com.micro.lcl.gataway.utils.RedisUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/416:49
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Value("${secretKey: !@#$%^&*}")
    private String secretKey;
    @Value("${issuer: mark}")
    private String issuer;
    @Value("${expireTime: 30}")
    private Long expireTime;
    @Autowired
    private RedisUtil redisUtil;
    private static final String TOKEN_CACHE_PREFIX = "auth-service:";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String token = request.getHeaders().getFirst("token");
        if (StringUtils.isBlank(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return getVoidMono(response, ResponseCode.TOKEN_MISSION);
        }
        String username = null;
        try {
            username = JWTUtil.getUserInfo(token);
        } catch (Exception e) {
            return getVoidMono(response, ResponseCode.TOKEN_INVALID);
        }
        if (StringUtils.isEmpty(username)) {
            return getVoidMono(response, ResponseCode.TOKEN_INVALID);
        }
        String key = MD5Util.getMD5Str(username);
        if(!redisUtil.hHasKey(TOKEN_CACHE_PREFIX + key, "token")){
            return getVoidMono(response, ResponseCode.TOKEN_INVALID);
        }
        try {
            JWTUtil.verifyToken(issuer,token,secretKey);
        }catch (TokenAuthenticationException ex){
            return getVoidMono(response, ResponseCode.TOKEN_INVALID);
        }catch (Exception e) {
            return getVoidMono(response, ResponseCode.UNKNOWN_ERROR);
        }
        return chain.filter(exchange);
    }

    private Mono<Void> getVoidMono(ServerHttpResponse response, ResponseCode responseCode) {
        response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        ResponseResult build = ResponseResult.builder()
                .code(responseCode.getCode())
                .message(responseCode.getMessage())
                .build();
        DataBuffer wrap = response.bufferFactory().wrap(JSONUtil.toJsonStr(build).getBytes());
        return response.writeWith(Flux.just(wrap));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
