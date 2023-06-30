package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Supervisor;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface ISupervisorService extends IService<Supervisor> {

    RespBean getSupervisorById(Supervisor supervisor);

    int saveSupervisor(Supervisor supervisor);

    RespBean getSupervisorByIdByPass(Supervisor supervisor);
}
