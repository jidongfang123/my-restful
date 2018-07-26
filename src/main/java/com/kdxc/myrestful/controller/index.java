package com.kdxc.myrestful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class index {

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "index";
    }



}
