package com.kdxc.myrestful.controller;

import com.alibaba.fastjson.JSONObject;
import com.kdxc.myrestful.pojo.User;
import com.kdxc.myrestful.service.UserService;
import com.kdxc.myrestful.util.ResponseData;
import com.kdxc.myrestful.util.SystemConst;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",notes = "登录方法")
    @PostMapping(value = "userLogin")
    public ResponseData userLogin(User user){
        ResponseData rd = null;
        try {
            Map<String,Object> userInfo =  userService.queryUserByid(user);
            if (userInfo == null){
                rd = new ResponseData(SystemConst.ERR_CODE_1101);
            }
            if(userInfo !=null){
                if(userInfo.get("upwd").equals(user.getUpwd())){
                    rd = new ResponseData(SystemConst.RESPONSE_SUCCESS);
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
    public String queryUserList(){
        List <User> list =userService.queryUserList();
        //list转成json
//		 JSONArray array =new JSONArray();
        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",1000);
        obj.put("data",list);
//		  array.add(obj);
        return obj.toString();

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
