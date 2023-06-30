package com.example.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.AqiTrendTotalStatisDto;
import com.example.server.pojo.Statistics;
import com.example.server.pojo.page.AllPage;
import com.example.server.pojo.page.PageResult;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IStatisticsService extends IService<Statistics> {

    int saveStatistics(Statistics statistics);

    Statistics getStatisticsById(Statistics statistics);

    IPage<Statistics> listStatisticsPage(AllPage statisticsPage);


    List<Map<String, Object>> listProvinceItemTotalStatis();

    List<Map<String, Object>> listAqiDistributeTotalStatis();

    Integer getAqiCount();

    Integer getAqiGoodCount();

    String getProvinceCoverage();

    String getCityCoverage();

    List<AqiTrendTotalStatisDto> listAqiTrendTotalStatis();
}
