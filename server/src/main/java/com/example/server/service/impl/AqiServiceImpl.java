package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.AqiMapper;
import com.example.server.pojo.Aqi;
import com.example.server.service.IAqiService;
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
public class AqiServiceImpl extends ServiceImpl<AqiMapper, Aqi> implements IAqiService {

    @Resource
    private AqiMapper aqiMapper;

    @Override
    public List<Aqi> selectAll() {
        List<Aqi> aqiList = aqiMapper.selectList(null);
        return aqiList;
    }
}
