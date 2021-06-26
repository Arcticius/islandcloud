package com.island.community.dao;


import com.island.community.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminstraterMapper {
    public List<Administrator> selectAll();

    public int insertAdminstrater(Administrator administrator);

    public int updatePassword(int id, String password);
}
