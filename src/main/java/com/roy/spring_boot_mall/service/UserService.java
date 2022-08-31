package com.roy.spring_boot_mall.service;

import com.roy.spring_boot_mall.dto.UserRegisterRequest;
import com.roy.spring_boot_mall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

}
