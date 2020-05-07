package com.rb.login.controller;

import com.rb.login.service.UserService;
import com.rb.login.model.entity.LoginRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginContrller {
    @Autowired
    private UserService userService;

    @PostMapping
    public String login(){
        return "hello word";
    }

    @GetMapping("/info")
    @ResponseStatus(value = HttpStatus.OK)
    public List<LoginRecord> findAllResources() {
        return userService.findAllLoginInfo();
    }
}
