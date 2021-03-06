package com.island.community.controller;

import com.island.community.client.DiscussPostClient;
import com.island.community.client.UserClient;
import com.island.community.entity.DiscussPost;
import com.island.community.entity.Page;
import com.island.community.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController { //controller 类可省略访问路径，直接定位方法

//    @Autowired
//    private DiscussPostService discussPostService;
//    @Autowired
//    private UserService userService;

    @Resource
    private UserClient userClient;
    @Resource
    private DiscussPostClient discussPostClient;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        // 方法调用钱,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.
        //page.setRows(discussPostService.findDiscussPostRows(0));
        page.setRows(discussPostClient.findDiscussPostRows(0));
        System.out.println(page.getRows());
        page.setPath("/index");


        //List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<DiscussPost> list=discussPostClient.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if(list!=null)
        {
            for(DiscussPost post:list)
                {
                    Map<String,Object> map=new HashMap<>();

                    //User user=userService.findById(post.getUserId());
                    User user = userClient.findUserById(post.getUserId());

                    if(user==null)
                        continue;
                    map.put("user",user);
                    map.put("post",post);
                    discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

    @RequestMapping(path = "/")
    public String toindex(){
        return "/mail/demo";
    }
}
