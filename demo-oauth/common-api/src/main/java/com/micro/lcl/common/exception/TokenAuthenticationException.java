package com.micro.lcl.common.exception;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/4 11:58
 */
public class TokenAuthenticationException extends RuntimeException {

    private Integer code;

    private String message;

    public TokenAuthenticationException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
