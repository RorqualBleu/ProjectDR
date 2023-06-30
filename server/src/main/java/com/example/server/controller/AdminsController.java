package com.example.server.controller;

import com.example.server.pojo.Admins;
import com.example.server.pojo.RespBean;
import com.example.server.service.IAdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private IAdminsService adminsService;

    @PostMapping("/getAdminsByCode")
    public RespBean login(@RequestBody Admins admins){
        return adminsService.login(admins);
    }
}
