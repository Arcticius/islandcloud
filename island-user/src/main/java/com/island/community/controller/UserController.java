package com.island.community.controller;

import com.island.community.entity.LoginTicket;
import com.island.community.entity.User;
import com.island.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User findUserById(@PathVariable("id")int id){
        return userService.findById(id);
    }

    @RequestMapping("/register")
    public Map<String ,Object> register(@RequestBody User user){
//        System.out.println("controller: " + user.getUsername());
        return userService.register(user);
    }

    @RequestMapping("/activate")
    public int activation(int userId,String code){
        return userService.activation(userId, code);
    }

    @RequestMapping("/login")
    public Map<String,Object> login(String username,String password,int expiredSeconds){
        return userService.login(username, password, expiredSeconds);
    }

    @RequestMapping("/logout")
    public void logout(String ticket){
        userService.logout(ticket);
    }

    @RequestMapping("/findLoginTicket")
    public LoginTicket findLoginTicket(String ticket){
        return userService.findLoginTicket(ticket);
    }

    @RequestMapping("/updateHeader")
    public int updateHeader(int userId, String headerUrl){
        return userService.updateHeader(userId, headerUrl);
    }
}
