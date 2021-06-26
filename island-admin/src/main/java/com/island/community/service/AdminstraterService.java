package com.island.community.service;

import com.island.community.dao.AdminstraterMapper;
import com.island.community.entity.Administrator;
import com.island.community.util.CommunityConstant;
import com.island.community.util.CommunityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdminstraterService {

    @Autowired
    private AdminstraterMapper adminstraterMapper;

    public List<Administrator> findAllAdminstrater(){
         return  adminstraterMapper.selectAll();
    }

    public int insertAdminstrater(Administrator administrator){
        return adminstraterMapper.insertAdminstrater(administrator);
    }

    public int updatePassword(int id,String password){
        return adminstraterMapper.updatePassword(id,password);
    }

    public Map<String ,Object> registerAsAdminstrater(Administrator administrator, String adminstraterCode){
        Map<String,Object> map =new HashMap<>();

        //判断空值
        if(administrator ==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(StringUtils.isBlank(administrator.getUsername())){
            map.put("usernameMsg","账号不能为空");
            System.out.println("账号不能为空");
            return map;
        }
        if(StringUtils.isBlank(administrator.getPassword())){
            map.put("passwordMsg","密码不能为空 ");
            System.out.println("存在问题并返回问题");
            return map;
        }

        if(adminstraterCode!= CommunityConstant.ADMINSTRATER_CODE){
            map.put("codeMsg","邀请码错误");
            System.out.println("检测到邀请码错误");
            return map;
        }

        administrator.setSalt(CommunityUtil.generateUUID().substring(0,5));
        administrator.setPassword(CommunityUtil.md5(administrator.getPassword()+ administrator.getSalt()));
        administrator.setHeaderUrl("null");

        return map;
    }
}
