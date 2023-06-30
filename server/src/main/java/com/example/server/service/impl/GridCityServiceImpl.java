package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.GridCityMapper;
import com.example.server.pojo.AqiFeedback;
import com.example.server.pojo.GridCity;
import com.example.server.pojo.GridMember;
import com.example.server.service.IGridCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@Service
public class GridCityServiceImpl extends ServiceImpl<GridCityMapper, GridCity> implements IGridCityService {

    @Resource
    private GridCityMapper gridCityMapper;

    @Override
    public List<GridCity> listGridCityByProvinceId(GridCity gridCity) {
        QueryWrapper<GridCity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province_id",gridCity.getProvinceId());
        return gridCityMapper.selectList(queryWrapper);
    }

}
