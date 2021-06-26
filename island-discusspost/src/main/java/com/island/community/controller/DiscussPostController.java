package com.island.community.controller;

import com.island.community.entity.DiscussPost;
import com.island.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscussPostController {

    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping("/discuss/{id}")
    public int findDiscussPostRows(@PathVariable("id") int userId){
        return discussPostService.findDiscussPostRows(userId);
    }

    @RequestMapping("/discuss/findDiscussPostById")
    public DiscussPost findDiscussPostById(int id){
        return discussPostService.findDiscussPostById(id);
    }

    @RequestMapping("/discuss/posts")
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostService.findDiscussPosts(userId, offset, limit);
    }

    @RequestMapping("/discuss/addDiscussPost")
    public int addDiscussPost(@RequestBody DiscussPost post){
        return discussPostService.addDiscussPost(post);
    }
}
