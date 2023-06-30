package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Admins;
import com.example.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IAdminsService extends IService<Admins> {


    RespBean login(Admins admins);
}
