package com.mark.springbootmall.service;

import com.mark.springbootmall.dto.UserLoginRequest;
import com.mark.springbootmall.dto.UserRegisterRequest;
import com.mark.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);

}
