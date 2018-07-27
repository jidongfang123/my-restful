package com.kdxc.myrestful.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kdxc.myrestful.mapper.UserMapper;
import com.kdxc.myrestful.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
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
        redisTemplate.opsForValue().set(user.getUphone()+"这是手机号","手机号",300);
        return userMapper.queryUserByid(user);
    }

    @Override
    public Map<String, Object> queryUserList(Integer curr, Integer limit) {
        PageHelper.startPage(curr,limit);
        List<User> list = userMapper.queryUserList();
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }
}
