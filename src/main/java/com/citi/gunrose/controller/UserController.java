package com.citi.gunrose.controller;

import com.citi.gunrose.persistence.model.User;
import com.citi.gunrose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Controller
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public String register() {

        return "/register";
    }

    @RequestMapping("login")
    public String login() {

        return "/login";
    }

    @RequestMapping("toLogin")
    public String loginSuccess(@ModelAttribute("user") User user, RedirectAttributes attr) {

        List<User> users = userService.queryList(user);
        if(users.isEmpty()) {
            return "/register";
        }

        return "/main";
    }

    @RequestMapping("toRegister")
    public String toRegister(@ModelAttribute("user") User user, RedirectAttributes attr) {

        userService.save(user);
        attr.addFlashAttribute(user);
        return "/login";
    }


}
