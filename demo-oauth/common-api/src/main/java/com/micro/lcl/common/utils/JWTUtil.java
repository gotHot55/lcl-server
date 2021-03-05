package com.micro.lcl.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.micro.lcl.common.api.ResponseCode;
import com.micro.lcl.common.exception.TokenAuthenticationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/411:25
 */
@Slf4j
public class JWTUtil {
    private static final String USER_INFO_KEY="username";

    /**
     * 生成token
     * @param issuer  签发者
     * @param username 用户标识（唯一）
     * @param secretKey 签名算法及密钥
     * @param tokenExpireTime 过期时间
     * @return
     */
    public static String generatorToken(String issuer,String username,String secretKey,Long tokenExpireTime) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + tokenExpireTime);
        String token = JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withExpiresAt(expireTime)
                .withClaim(USER_INFO_KEY, username)
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     * @param issuer 签发者
     * @param token  访问密钥
     * @param secretKey 签名算法及密钥
     */
    public static void verifyToken(String issuer, String token, String secretKey) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(issuer).build();
            jwtVerifier.verify(token);
        }  catch (JWTDecodeException jwtDecodeException) {
            throw new TokenAuthenticationException(ResponseCode.TOKEN_INVALID.getCode(), ResponseCode.TOKEN_INVALID.getMessage());
        } catch (SignatureVerificationException signatureVerificationException) {
            signatureVerificationException.printStackTrace();
//            throw new TokenAuthenticationException(ResponseCode.TOKEN_SIGNATURE_INVALID.getCode(), ResponseCode.TOKEN_SIGNATURE_INVALID.getMessage());
        } catch (TokenExpiredException tokenExpiredException) {
            throw new TokenAuthenticationException(ResponseCode.TOKEN_EXPIRED.getCode(), ResponseCode.TOKEN_INVALID.getMessage());
        } catch (Exception ex) {
            throw new TokenAuthenticationException(ResponseCode.UNKNOWN_ERROR.getCode(), ResponseCode.UNKNOWN_ERROR.getMessage());
        }
    }

    /**
     * 从token中获取用户信息
     * @param token
     * @return
     */
    public static String getUserInfo(String token) {
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim(USER_INFO_KEY).asString();
        return username;
    }

//    public static void main(String[] args) {
////        Algorithm hmac256 = Algorithm.HMAC256("!@#$%^&*");
////        System.out.println(hmac256);
//        String token = JWTUtil.generatorToken("mark", "tom", "!@#$%^&*", 30L);
//        System.out.println(token);
//    }
}
