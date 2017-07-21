package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.impl.UserServiceIMP;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserServiceIMP userServiceIMP;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userServiceIMP.getAllUser();
        model.addAttribute("userList",userList);
//        showUser.jsp,和之前的前后缀拼接
        return "showUser";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response){
        try {
            String user=request.getParameter("userID");
            String password=request.getParameter("password");
            log.info("userID"+user+"password"+password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jsonArray=new JSONArray();
        String p="success";
        jsonArray.add(p);
        return jsonArray.toString();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String Login(HttpServletRequest request, HttpServletResponse response){
        User user = null;
        try {
            String userID=request.getParameter("userID");
            String password=request.getParameter("password");
            log.info(userID+ " " + password);
            user = userServiceIMP.checklogin(userID, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        if(user != null){
            jsonArray.add(user);
        } else {
            String p = "false";
            jsonArray.add(p);
        }
        return jsonArray.toString();
    }
}
