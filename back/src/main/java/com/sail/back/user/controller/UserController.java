package com.sail.back.user.controller;

import com.sail.back.user.model.dto.request.UserInfoRequest;
import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.dto.response.UserInfoResponse;
import com.sail.back.user.model.entity.User;
import com.sail.back.user.model.service.UserService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @PostMapping("/regist")
    public ResponseEntity<Void> register(@RequestBody UserRegistRequest userRegistRequest) {
        log.debug("UserRegistRequest={}",userRegistRequest);
        User user = userService.registUser(userRegistRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/info")
    public ResponseEntity<User> info(@RequestBody UserInfoRequest userInfoRequest) {
        User user = userService.infoUser(userInfoRequest);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody UserInfoRequest userInfoRequest) {

        return ResponseEntity.ok().build();
    }

}
