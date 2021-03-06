package com.island.community.dao;

import com.island.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(@Param(("userId"))int userId, @Param(("offset"))int offset, @Param(("limit"))int limit);

    DiscussPost selectDiscussPostById(int id);

    int selectDiscussPostRows(@Param(("userId")) int userId); //动态拼接，且只有一个参数条件，需要用注释param取别名

    int insertDiscussPost(DiscussPost discussPost);


}
