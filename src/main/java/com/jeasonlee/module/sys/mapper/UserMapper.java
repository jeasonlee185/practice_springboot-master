package com.jeasonlee.module.sys.mapper;

import com.jeasonlee.module.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jeasonlee
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    User userLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 注册新用户(方式1)
     *
     * @return
     */
    int addUser(Map<String, Object> map);//insert 如果要用到返回的自增长的主键,不要用@Param("")
//    int addUser(@Param("username") String username, @Param("password") String password, @Param("age") int age);

    /**
     * 注册新用户（方式2
     */
    int addUser1(@Param("username") String username, @Param("password") String password, @Param("age") int age);
}
