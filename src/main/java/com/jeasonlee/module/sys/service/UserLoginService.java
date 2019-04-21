package com.jeasonlee.module.sys.service;

import com.jeasonlee.module.sys.entity.User;
import com.jeasonlee.module.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserLoginService {

    /**
     * 注入dao
     */
    @Autowired

    private UserMapper usermapper;

    //用户登录
    public User userLogin(String username, String password) {
        User user = usermapper.userLogin(username, password);
        return user;
    }

    //注册新用户
    public int addUser(String username, String password, int age) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("age", age);
        return usermapper.addUser(map);
    }
}
