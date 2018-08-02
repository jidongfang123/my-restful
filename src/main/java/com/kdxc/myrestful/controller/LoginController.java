package com.kdxc.myrestful.controller;

import com.kdxc.myrestful.pojo.Users;
import com.kdxc.myrestful.service.LoginService;
import com.kdxc.myrestful.util.MD5Util;
import com.kdxc.myrestful.util.ResponseData;
import com.kdxc.myrestful.util.SystemConst;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("user")
@RestController
public class LoginController {
    @Autowired
    private LoginService userService;

    @ApiOperation(value = "登录",notes = "登录方法")
    @PostMapping(value = "userLogin")
    public ResponseData userLogin(Users user, HttpSession session){
        ResponseData rd = null;
        try {
            Map<String,Object> userInfo =  userService.queryUserByid(user);
            String MD5pwd = MD5Util.MD5(user.getPwd());
            if (userInfo == null){
                rd = new ResponseData(SystemConst.ERR_CODE_1101);
            }
            if(userInfo !=null){
                if(userInfo.get("pwd").equals(MD5pwd)){
                    rd = new ResponseData(SystemConst.RESPONSE_SUCCESS);
                    session.setAttribute("user",userInfo);
                    rd.putVal("user",userInfo);
                }else {
                    rd = new ResponseData(SystemConst.ERR_CODE_1102);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            rd.setErrorMsg(e.getMessage());
        }
        return rd;
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping(value = "queryUserList")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,Object> queryUserList(Integer curr,Integer limit){
        return userService.queryUserList(curr,limit);
    }

    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping(value = "insertUser")
    public ResponseData insertUser(Users user){
        ResponseData rd =null;
        Map<String,Object> userInfo = null;
        try {
            userInfo = userService.queryUserByid(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userInfo !=null){
            rd = new ResponseData(SystemConst.ERR_CODE_1103);
        }else {
            String MD5pwd = MD5Util.MD5(user.getPwd());
            user.setPwd(MD5pwd);
            userService.insertUser(user);
            rd = new ResponseData(SystemConst.RESPONSE_SUCCESS);
            rd.putVal("user",user);
        }
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
