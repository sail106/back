package com.sail.back.user.controller;

import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.entity.User;
import com.sail.back.user.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/regist")
    public ResponseEntity register(@RequestBody UserRegistRequest userRegistRequest) {

        User user = userService.registUser(userRegistRequest);

        return new ResponseEntity(HttpStatus.OK);
    }



}
