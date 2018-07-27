package com.kdxc.myrestful.controller;

import com.alibaba.fastjson.JSONObject;
import com.kdxc.myrestful.pojo.User;
import com.kdxc.myrestful.service.UserService;
import com.kdxc.myrestful.util.MD5;
import com.kdxc.myrestful.util.ResponseData;
import com.kdxc.myrestful.util.SystemConst;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",notes = "登录方法")
    @PostMapping(value = "userLogin")
    public ResponseData userLogin(User user, HttpSession session){
        ResponseData rd = null;
        try {
            Map<String,Object> userInfo =  userService.queryUserByid(user);
            user = MD5.md5(user);
            if (userInfo == null){
                rd = new ResponseData(SystemConst.ERR_CODE_1101);
            }
            if(userInfo !=null){
                if(userInfo.get("upwd").equals(user.getUpwd())){
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
    @GetMapping(value = "/queryUserList")
    @ResponseStatus(HttpStatus.OK)
    public  Map<String,Object> queryUserList(Integer curr,Integer limit){
        return userService.queryUserList(curr,limit);
    }

    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping(value = "insertUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData insertUser(User user){
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
            MD5.md5(user);
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
