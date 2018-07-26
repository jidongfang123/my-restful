package com.kdxc.myrestful.service;

import com.kdxc.myrestful.pojo.User;

import java.util.List;

public interface UserService {

    List<User> queryUserList();

    int insertUser(User user);

    void deleteUser(Integer uid);
}
