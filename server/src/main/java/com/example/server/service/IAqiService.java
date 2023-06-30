package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Aqi;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IAqiService extends IService<Aqi> {

    List<Aqi> selectAll();
}
