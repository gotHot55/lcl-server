package com.micro.lcl.sleb.controller;

import com.micro.lcl.sleb.model.LoginModel;
import com.micro.lcl.sleb.model.UserModel;
import com.micro.lcl.sleb.repository.core.UserRepository;
import com.micro.lcl.sleb.repository.master.LoginRepository;
import com.micro.lcl.sleb.service.UserService;
import com.micro.lcl.sleb.util.MailUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/1315:54
 */
@RestController
public class TestController {
    private final LoginRepository loginRepository;
    private final MailUtil mailUtil;

    public TestController( LoginRepository loginRepository, MailUtil mailUtil) {
        this.loginRepository = loginRepository;
        this.mailUtil = mailUtil;
    }

    /*@GetMapping("/user/{id}")
    public ModelMap getById(@PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        UserModel model = null;
        try {
            model = userService.getById(id);
        } catch (Exception e) {
            mailUtil.sendMail("访问oracle数据库异常", "异常信息为" + e.getMessage());
            e.printStackTrace();
        }

        if (StringUtils.isBlank(model.getUsername())) {
            modelMap.addAttribute("code", "2001")
                    .addAttribute("message", "查询失败")
                    .addAttribute("result", model);
        } else {
            modelMap.addAttribute("code", "0000")
                    .addAttribute("message", "查询成功")
                    .addAttribute("result", model);
        }
        return modelMap;
    }*/

    @GetMapping("/login/{id}")
    public ModelMap getById2(@PathVariable("id") Integer id) {
        ModelMap modelMap = new ModelMap();
        LoginModel model = null;
        try {
            model = loginRepository.getById(id);
        } catch (Exception e) {
            mailUtil.sendMail("访问mysql数据库异常", "异常信息为" + e.getMessage());
            e.printStackTrace();
        }

        if (StringUtils.isBlank(model.getUsername())) {
            modelMap.addAttribute("code", "2001")
                    .addAttribute("message", "查询失败")
                    .addAttribute("result", model);
        } else {
            modelMap.addAttribute("code", "0000")
                    .addAttribute("message", "查询成功")
                    .addAttribute("result", model);
        }
        return modelMap;
    }
}
