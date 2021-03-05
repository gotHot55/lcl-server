package com.micro.lcl.auth.beans;

import lombok.Builder;
import lombok.Data;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/414:33
 */
@Builder
@Data
public class TokenResult {
    private String username;

    private String access_token;

    private String refresh_token;

    private long expires_in;
}
