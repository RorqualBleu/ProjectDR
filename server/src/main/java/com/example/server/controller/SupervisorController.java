package com.example.server.controller;


import com.example.server.pojo.RespBean;
import com.example.server.pojo.Supervisor;
import com.example.server.service.ISupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private ISupervisorService supervisorService;

    //根据主键查询公众监督员，用于注册时手机号码是否存在验证
    @GetMapping("/getSupervisorById")
    public RespBean GetSupervisorById(@RequestBody Supervisor supervisor){
        return supervisorService.getSupervisorById(supervisor);
    }

    //保存公众监督员信息，用于注册
    @PostMapping("/saveSupervisor")
    public int SaveSupervisor(@RequestBody Supervisor supervisor){
        return supervisorService.saveSupervisor(supervisor);
    }

    //根据公众监督员手机号码和密码查询，用于登录。
    @GetMapping("/getSupervisorByIdByPass")
    public RespBean GetSupervisorByIdByPass(@RequestBody Supervisor supervisor){
        return supervisorService.getSupervisorByIdByPass(supervisor);
    }
}
