package com.kdxc.myrestful.mapper;

import com.kdxc.myrestful.pojo.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {

    List<Users> queryUserList();

    int insertUser(Users user);

    @Delete("delete from users where uid = #{uid}")
    void deleteUser(Integer uid);

    Map<String, Object> queryUserByid(Users user);
}
