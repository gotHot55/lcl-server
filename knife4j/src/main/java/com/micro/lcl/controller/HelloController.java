package com.micro.lcl.controller;

import com.micro.lcl.service.QRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/2216:38
 */
@RestController
@Api(tags = "接口测试")
public class HelloController {
    @Autowired
    private QRService qrService;

    @ApiOperation(value = "用户登录测试接口", notes = "用户登录试接口000")
    @GetMapping(value = "/hello")
    public ModelMap hello(String name) {
        ModelMap map = new ModelMap();
        map.addAttribute("code", 1)
                .addAttribute("data", name)
                .addAttribute("time", new Date())
                .addAttribute("message", "SUCCESS");
        return map;
    }

    @ApiOperation(value = "生成二维码", notes = "用户生成二维码测试接口000")
    @GetMapping(value = "/qr")
    public ModelMap qr(String name) {
        ModelMap map = new ModelMap();
        String code = qrService.qrCode(name);
        map.addAttribute("code", 1)
                .addAttribute("data", code)
                .addAttribute("time", new Date())
                .addAttribute("message", "SUCCESS");
        return map;
    }
}
