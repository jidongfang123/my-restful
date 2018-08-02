package com.kdxc.myrestful.service;

import com.kdxc.myrestful.pojo.Users;

import java.util.Map;

public interface LoginService {

    Map<String,Object> queryUserByid(Users user);

    Map<String,Object> queryUserList(Integer curr, Integer limit);

    void insertUser(Users user);

    void deleteUser(Integer uid);
}
