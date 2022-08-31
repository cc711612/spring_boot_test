package com.roy.spring_boot_mall.service.Impl;

import com.roy.spring_boot_mall.dao.UserDao;
import com.roy.spring_boot_mall.dto.UserRegisterRequest;
import com.roy.spring_boot_mall.model.User;
import com.roy.spring_boot_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
