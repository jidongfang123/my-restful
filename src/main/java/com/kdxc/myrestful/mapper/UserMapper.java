package com.kdxc.myrestful.mapper;

import com.kdxc.myrestful.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> queryUserList();

    int insertUser(User user);

    @Delete("delete from user where uid = #{uid}")
    void deleteUser(Integer uid);

    Map<String, Object> queryUserByid(User user);
}
