package com.micro.lcl.oauth.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/417:48
 */
@Service
public class SecurityService {
    @PreAuthorize("true")
    public String authorize() {
        return "hello authorize";
    }

    @PreAuthorize("false")
    public String authriz() {
        return "bye authorize";
    }
    @Secured(value = "ROLE_USER")
    public String hello() {
        return "hello ROLE_USER";
    }
}
