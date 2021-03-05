package com.micro.lcl.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/417:47
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello world";
    }
}
