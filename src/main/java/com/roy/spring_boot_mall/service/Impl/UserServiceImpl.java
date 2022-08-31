package com.roy.spring_boot_mall.service.Impl;

import com.roy.spring_boot_mall.dao.UserDao;
import com.roy.spring_boot_mall.dto.UserRegisterRequest;
import com.roy.spring_boot_mall.model.User;
import com.roy.spring_boot_mall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊Email
        if (userDao.getUserByEmail(userRegisterRequest.getEmail()) != null) {
            log.warn("該 email : {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
