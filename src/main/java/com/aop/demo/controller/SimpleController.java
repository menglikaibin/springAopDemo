package com.aop.demo.controller;

import com.aop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("simpleController")
public class SimpleController {
    @Autowired
    private UserService userService;

    public void test() {
        userService.addUser();
    }
}
