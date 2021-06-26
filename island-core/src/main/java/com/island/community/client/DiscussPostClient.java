package com.island.community.client;

import com.island.community.entity.DiscussPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "island-discusspost")
public interface DiscussPostClient {

    @RequestMapping("/community/discuss/{id}")
    public int findDiscussPostRows(@PathVariable("id") int userId);

    @RequestMapping("/community/discuss/posts")
    public List<DiscussPost> findDiscussPosts(@RequestParam("userId") int userId, @RequestParam("offset") int offset, @RequestParam("limit") int limit);


    @RequestMapping("/community/discuss/findDiscussPostById")
    public DiscussPost findDiscussPostById(@RequestParam("id")int id);


    @RequestMapping("/community/discuss/addDiscussPost")
    public int addDiscussPost(@RequestBody DiscussPost post);
}
