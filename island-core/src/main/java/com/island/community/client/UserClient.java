package com.island.community.client;

import com.island.community.entity.LoginTicket;
import com.island.community.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "island-user")
public interface UserClient {

    @RequestMapping("/community/user/{id}")
    public User findUserById(@PathVariable("id")int id);

    @RequestMapping("/community/register")
    public Map<String ,Object> register(@RequestBody User user);

    @RequestMapping("/community/activate")
    public int activation(@RequestParam("userId")int userId,@RequestParam("code")String code);

    @RequestMapping("/community/login")
    public Map<String,Object> login(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("expiredSeconds")int expiredSeconds);

    @RequestMapping("/community/logout")
    public void logout(@RequestParam("ticket")String ticket);

    @RequestMapping("/community/findLoginTicket")
    public LoginTicket findLoginTicket(@RequestParam("ticket")String ticket);

    @RequestMapping("/community/updateHeader")
    public int updateHeader(@RequestParam("userId")int userId, @RequestParam("headerUrl")String headerUrl);

}
