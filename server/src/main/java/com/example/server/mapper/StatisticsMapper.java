package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.AqiTrendTotalStatisDto;
import com.example.server.pojo.Statistics;

import java.util.List;


public interface StatisticsMapper extends BaseMapper<Statistics> {
    //十二个月AQI超标趋势统计
    public List<AqiTrendTotalStatisDto> listAqiTrendTotalStatis(List<AqiTrendTotalStatisDto> list);
}
