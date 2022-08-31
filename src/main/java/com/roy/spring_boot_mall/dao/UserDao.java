package com.roy.spring_boot_mall.dao;

import com.roy.spring_boot_mall.dto.UserRegisterRequest;
import com.roy.spring_boot_mall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
