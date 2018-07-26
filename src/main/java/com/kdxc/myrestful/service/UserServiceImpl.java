package com.kdxc.myrestful.service;

import com.kdxc.myrestful.mapper.UserMapper;
import com.kdxc.myrestful.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer uid) {
        userMapper.deleteUser(uid);
    }

    @Override
    public Map<String, Object> queryUserByid(User user) {
        return userMapper.queryUserByid(user);
    }
}
