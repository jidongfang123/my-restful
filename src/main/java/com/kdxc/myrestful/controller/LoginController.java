package com.kdxc.myrestful.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @ApiOperation(value = "跳转至首页",notes = "跳转至首页")
    @GetMapping(value = "/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "login";
    }
    @ApiOperation(value = "退出登陆",notes = "退出")
    @RequestMapping(value = "loginOut")
    public String loginOut(Model model,HttpSession session) throws Exception {
        //清除session
        model.addAttribute("name", "simonsfan");
        session.invalidate();
        return "login";
    }

    @ApiOperation(value = "跳转至首页",notes = "跳转至首页")
    @GetMapping(value = "index")
    public String toindex(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "index";
    }

    @ApiOperation(value = "跳转至首页",notes = "跳转至首页")
    @GetMapping(value = "user_list")
    public String user_list() {
        return "user-list";
    }

}
