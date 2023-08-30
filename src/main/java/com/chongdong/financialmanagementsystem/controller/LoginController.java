package com.chongdong.financialmanagementsystem.controller;


import com.chongdong.financialmanagementsystem.model.Administrators;
import com.chongdong.financialmanagementsystem.service.AdministratorsService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    AdministratorsService administratorsService;

    @PostMapping("/userLogin")
    public Map adminLogin(Administrators admin, HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(admin.toString()+"@@@@@@@@@@@");
        Administrators admin1 = administratorsService.queryAdmin(admin);
        if (admin1!=null){
            session.setAttribute("adminLogin",admin1);
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }




}
