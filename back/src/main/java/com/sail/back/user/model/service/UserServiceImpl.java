package com.sail.back.user.model.service;

import com.sail.back.user.model.dto.request.UserInfoRequest;
import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.entity.User;
import com.sail.back.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registUser(UserRegistRequest userRegistRequest){
        User user = User.builder().email(userRegistRequest.getEmail()).password(userRegistRequest.getPassword()).createAt(null).build();
        return userRepository.save(user);
    }

    @Override
    public User infoUser(UserInfoRequest userInfoRequest) {

        User user = userRepository.findById(userInfoRequest.getId()).get();
        return user;
    }

    @Override
    public void withdrawUser(UserRegistRequest userRegistRequest) {

    }

    @Override
    public User updateUser(UserRegistRequest userRegistRequest) {
        return null;
    }

}
