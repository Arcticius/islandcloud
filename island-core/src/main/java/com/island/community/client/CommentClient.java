package com.island.community.client;

import com.island.community.entity.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "island-comment")
public interface CommentClient {

    @RequestMapping("/community/findCommentsByEntity")
    public List<Comment> findCommentsByEntity(@RequestParam("entityType") int entityType, @RequestParam("entityId")int entityId, @RequestParam("offset")int offset, @RequestParam("limit")int limit);


    @RequestMapping("/community/findCommentCount")
    public int findCommentCount(@RequestParam("entityType")int entityType, @RequestParam("entityId")int entityId);
}
