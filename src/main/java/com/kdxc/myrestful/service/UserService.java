package com.kdxc.myrestful.service;

import com.kdxc.myrestful.pojo.User;

import java.util.Map;

public interface UserService {


    int insertUser(User user);

    void deleteUser(Integer uid);

    Map<String, Object> queryUserByid(User user);

    Map<String, Object> queryUserList(Integer curr, Integer limit);
}
