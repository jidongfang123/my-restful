package com.kdxc.myrestful.service;

import com.kdxc.myrestful.pojo.User;

public interface UserService {

    User findByUsername(String username);
}
