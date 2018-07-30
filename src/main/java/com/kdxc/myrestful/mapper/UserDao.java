package com.kdxc.myrestful.mapper;

import com.kdxc.myrestful.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findByUsername(String username);
}
