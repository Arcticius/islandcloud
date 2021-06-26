package com.island.community.client;

import com.island.community.entity.Administrator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "island-admin")
public interface AdminClient {

    @RequestMapping("/community/admin/findAllAdminstrater")
    public List<Administrator> findAllAdminstrater();

    @RequestMapping("/community/admin/insertAdminstrater")
    public int insertAdminstrater(@RequestBody Administrator administrator);

    @RequestMapping("/community/admin/updatePassword")
    public int updatePassword(@RequestParam("id") int id, @RequestParam("password")String password);

    @RequestMapping("/community/admin/registerAsAdminstrater")
    public Map<String ,Object> registerAsAdminstrater(@RequestBody Administrator administrator, @RequestParam("adminstraterCode")String adminstraterCode);
}
