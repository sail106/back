package com.sail.back.user.model.service;

import com.sail.back.user.model.dto.request.UserInfoRequest;
import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.entity.User;
import com.sail.back.user.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registUser(UserRegistRequest userRegistRequest){
        User user = User.builder().email(userRegistRequest.getEmail()).password(userRegistRequest.getPassword()).build();
        return userRepository.save(user);
    }

    @Override
    public User infoUser(UserInfoRequest userInfoRequest) {
        User user = User.builder().email(userInfoRequest.getEmail()).password(userInfoRequest.getPassword()).build();
        return userRepository.save(user);
    }

}
