package com.kdxc.myrestful.controller;

import com.kdxc.myrestful.pojo.User;
import com.kdxc.myrestful.service.UserService;
import com.kdxc.myrestful.util.ResponseData;
import com.kdxc.myrestful.util.SystemConst;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping(value = "/queryUserList")
    @ResponseStatus(HttpStatus.OK)
    public List<User> queryUserList(){
        return userService.queryUserList();
    }

    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping(value = "insertUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData insertUser(User user){
        ResponseData rd =null;
        userService.insertUser(user);
        rd = new ResponseData(SystemConst.RESPONSE_SUCCESS);
        rd.putVal("user",user);
     return rd;
    }
	
	//删除
    @ApiOperation(value = "删除用户",notes = "删除用户")
    @DeleteMapping(value = "deleteUser/{uid}")
    public ResponseData deleteUser(@PathVariable("uid") Integer uid){
        ResponseData rd =null;
            userService.deleteUser(uid);
            rd = new ResponseData(SystemConst.RESPONSE_SUCCESS);
        return  rd;
    }
}
