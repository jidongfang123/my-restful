package com.kdxc.myrestful.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kdxc.myrestful.mapper.LoginMapper;
import com.kdxc.myrestful.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;



    @Override
    public Map<String, Object> queryUserByid(Users user) {
        return loginMapper.queryUserByid(user);
    }

    @Override
    public Map<String, Object> queryUserList(Integer curr, Integer limit) {
        PageHelper.startPage(Integer.valueOf(curr), Integer.valueOf(limit));
        List<Users> list = loginMapper.queryUserList();
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public void insertUser(Users user) {
        loginMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer uid) {
        loginMapper.deleteUser(uid);
    }
}
