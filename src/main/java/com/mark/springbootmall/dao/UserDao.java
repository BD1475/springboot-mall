package com.mark.springbootmall.dao;

import com.mark.springbootmall.dto.UserRegisterRequest;
import com.mark.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserByEmail(String email);

    User getUserById(Integer userId);
}
