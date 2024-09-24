package com.example.cadastrousuariomicro.user.controller;

import com.example.cadastrousuariomicro.user.model.UserDto;
import com.example.cadastrousuariomicro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDto user) {
        System.out.println(user.toString());
        return userService.save(user);
    }

}
