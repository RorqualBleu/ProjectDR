package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.GridCity;
import com.example.server.pojo.GridMember;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IGridCityService extends IService<GridCity> {

    List<GridCity> listGridCityByProvinceId(GridCity gridCity);
}
