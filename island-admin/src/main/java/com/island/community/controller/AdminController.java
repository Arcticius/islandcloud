package com.island.community.controller;

import com.island.community.dao.AdminstraterMapper;
import com.island.community.entity.Administrator;
import com.island.community.service.AdminstraterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminstraterService adminstraterService;

    @RequestMapping("/admin/findAllAdminstrater")
    public List<Administrator> findAllAdminstrater(){
        return adminstraterService.findAllAdminstrater();
    }

    @RequestMapping("/admin/insertAdminstrater")
    public int insertAdminstrater(@RequestBody Administrator administrator){
        return adminstraterService.insertAdminstrater(administrator);
    }

    @RequestMapping("/admin/updatePassword")
    public int updatePassword(int id,String password){
        return adminstraterService.updatePassword(id, password);
    }

    @RequestMapping("/admin/registerAsAdminstrater")
    public Map<String ,Object> registerAsAdminstrater(@RequestBody Administrator administrator, String adminstraterCode){
        return adminstraterService.registerAsAdminstrater(administrator, adminstraterCode);
    }
}
