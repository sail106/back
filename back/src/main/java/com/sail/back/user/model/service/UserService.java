package com.sail.back.user.model.service;

import com.sail.back.user.model.dto.request.UserInfoRequest;
import com.sail.back.user.model.dto.request.UserRegistRequest;
import com.sail.back.user.model.entity.User;

public interface UserService {

    User registUser(UserRegistRequest userRegistRequest);
    User infoUser(UserInfoRequest userInfoRequest);
    void withdrawUser(UserRegistRequest userRegistRequest);
    User updateUser(UserRegistRequest userRegistRequest);

}
