package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.SupervisorMapper;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Supervisor;
import com.example.server.service.ISupervisorService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@Service
public class SupervisorServiceImpl extends ServiceImpl<SupervisorMapper, Supervisor> implements ISupervisorService {

    @Resource
    private SupervisorMapper supervisorMapper;

    @Override
    public RespBean getSupervisorById(Supervisor supervisor) {
        Supervisor supervisor1 = supervisorMapper.selectById(supervisor);
        if (ObjectUtils.isEmpty(supervisor1)){
            return RespBean.success("手机号未注册");
        }else {
            return RespBean.error("手机号已存在");
        }
    }

    @Override
    public int saveSupervisor(Supervisor supervisor) {
        if (supervisor == null) {
            return 0;
        }
        //int rows = supervisorMapper.insert(supervisor);
        if(ObjectUtils.isEmpty(supervisorMapper.selectById(supervisor))){
            supervisorMapper.insert(supervisor);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public RespBean getSupervisorByIdByPass(Supervisor supervisor) {
        QueryWrapper<Supervisor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tel_id",supervisor.getTelId()).eq("password",supervisor.getPassword());
        Supervisor supervisor1 = supervisorMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(supervisor1)){
            return RespBean.error("用户名不存在或密码不正确");
        }else {
            return RespBean.success("登录成功");
        }
    }
}
