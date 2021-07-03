package com.refyne.cars.controller;

import com.refyne.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void create(@RequestParam("mobile") String mobileNumber){
        userService.create(mobileNumber);
    }
}
