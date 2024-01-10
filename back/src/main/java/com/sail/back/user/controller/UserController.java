package com.sail.back.user.controller;

import com.sail.back.user.model.dto.request.UserIdRequest;
import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.dto.request.UserUpdateRequest;
import com.sail.back.user.model.entity.User;
import com.sail.back.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/users")
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
    public ResponseEntity<User> info(@RequestBody UserIdRequest userIdRequest) {
        User user = userService.infoUser(userIdRequest);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<Void> delete(@RequestBody UserIdRequest userIdRequest) {
        userService.withdrawUser(userIdRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserUpdateRequest userUpdateRequest){
        User user = userService.updateUser(userUpdateRequest);

        return ResponseEntity.ok(user);
    }

}
