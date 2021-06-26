package com.island.community.controller;

import com.island.community.entity.Comment;
import com.island.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/findCommentsByEntity")
    public List<Comment> findCommentsByEntity(int entityType,int entityId,int offset,int limit){
        return commentService.findCommentsByEntity(entityType, entityId, offset, limit);
    }

    @RequestMapping("/findCommentCount")
    public int findCommentCount(int entityType, int entityId){
        return commentService.findCommentCount(entityType, entityId);
    }
}
