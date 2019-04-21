package com.jeasonlee.module.sys.service.impl;

import com.jeasonlee.module.sys.mapper.UserMapper;
import com.jeasonlee.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

}
