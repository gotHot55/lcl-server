package com.micro.lcl.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.micro.lcl.auth.beans.ReferRequest;
import com.micro.lcl.auth.beans.TokenRequest;
import com.micro.lcl.auth.beans.TokenResult;
import com.micro.lcl.auth.entity.User;
import com.micro.lcl.auth.service.UserService;
import com.micro.lcl.auth.util.RedisUtil;
import com.micro.lcl.common.api.ResponseCode;
import com.micro.lcl.common.api.ResponseResult;
import com.micro.lcl.common.utils.JWTUtil;
import com.micro.lcl.common.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/414:26
 */

@RestController
public class TokenController {
    @Value("${secretKey: !@#$%^&*}")
    private String secretKey;
    @Value("${issuer:mark}")
    private String issuer;
    @Value("${expireTIme: 30}")
    private Long expireTime;

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    private static final String TOKEN_CACHE_PREFIX = "auth-service:";

    @PostMapping(value = "/getToken")
    public ResponseResult getToken(@Validated @RequestBody TokenRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  ResponseResult
                    .builder()
                    .code(ResponseCode.PARAMETER_ILLEGAL.getCode())
                    .message(ResponseCode.PARAMETER_ILLEGAL.getMessage())
                    .build();
        }
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
//        User user = new User();
        wrapper.eq(User::getUsername, request.getUsername());
        wrapper.eq(User::getPassword, request.getPassword());
        User one = userService.getOne(wrapper);
        if (one != null) {
            //生成token
            String token = JWTUtil.generatorToken(issuer, one.getUsername(), secretKey, expireTime);
            //刷新token
            String referToken = UUID.randomUUID().toString().replace("-", "");
            //放入缓存
            String key = MD5Util.getMD5Str(one.getUsername());
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("referToken", referToken);
            boolean hmset = redisUtil.hmset(TOKEN_CACHE_PREFIX + key, map, expireTime);
            TokenResult data = TokenResult.builder()
                    .access_token(token)
                    .refresh_token(referToken)
                    .username(one.getUsername())
                    .expires_in(expireTime)
                    .build();
            return ResponseResult
                    .builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(ResponseCode.SUCCESS.getMessage())
                    .data(data)
                    .build();
        }
        return ResponseResult
                .builder()
                .code(ResponseCode.LOGIN_ERROR.getCode())
                .message(ResponseCode.LOGIN_ERROR.getMessage())
                .build();
    }

    /**
     * 删除token
     */
    @GetMapping(value = "/delToken")
    public ResponseResult delToken(@RequestParam("username") String username) {
        String key = MD5Util.getMD5Str(username);
        redisUtil.hdel(TOKEN_CACHE_PREFIX + key);
        return ResponseResult
                .builder()
                .code(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMessage())
                .build();
    }

    @GetMapping(value = "/referToken")
    public ResponseResult referToken(@RequestBody ReferRequest request) {
        String referToken = request.getReferToken();
        String key = MD5Util.getMD5Str(request.getUsername());
        String tokenRefer = (String) redisUtil.hget(TOKEN_CACHE_PREFIX + key, "referToken");
        if (StringUtils.isBlank(tokenRefer) || !referToken.equals(tokenRefer)) {
            return ResponseResult
                    .builder()
                    .code(ResponseCode.REFRESH_TOKEN_INVALID.getCode())
                    .message(ResponseCode.REFRESH_TOKEN_INVALID.getMessage())
                    .build();
        }
        //生成新token
        String newToken = JWTUtil.generatorToken(issuer, request.getUsername(), secretKey, expireTime);
        redisUtil.hset(TOKEN_CACHE_PREFIX + key, "Token", newToken, expireTime);
        return ResponseResult
                .builder()
                .code(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMessage())
                .data(newToken)
                .build();
    }

    @GetMapping(value = "/test")
    public String test() {
        return "hello world";
    }
}
