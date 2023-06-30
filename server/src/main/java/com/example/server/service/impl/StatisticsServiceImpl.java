package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.StatisticsMapper;
import com.example.server.pojo.AqiTrendTotalStatisDto;
import com.example.server.pojo.Statistics;
import com.example.server.pojo.page.AllPage;
import com.example.server.pojo.page.PageResult;
import com.example.server.service.IStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@Service
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, Statistics> implements IStatisticsService {

    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public int saveStatistics(Statistics statistics) {
        int rows = statisticsMapper.insert(statistics);
        if(rows > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public Statistics getStatisticsById(Statistics statistics) {
        return statisticsMapper.selectById(statistics.getId());
    }

    @Override
    public IPage<Statistics> listStatisticsPage(AllPage statisticsPage) {
        Page<Statistics> page = new Page<>(statisticsPage.getPageNum(), statisticsPage.getPageSize());
        //System.out.println("danyin:"+statisticsPage.getPageNum()+statisticsPage.getPageSize());

        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("province_id",statisticsPage.getProvinceId()).like("city_id",statisticsPage.getCityId()).like("confirm_date",statisticsPage.getConfirmDate());
        return statisticsMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listProvinceItemTotalStatis() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("province_id", "COUNT(*) AS count").groupBy("province_id");
        return statisticsMapper.selectMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listAqiDistributeTotalStatis() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("aqi_id", "COUNT(*) AS count").groupBy("aqi_id");
        return statisticsMapper.selectMaps(queryWrapper);
    }

    @Override
    public Integer getAqiCount() {
        return statisticsMapper.selectCount(null);
    }

    @Override
    public Integer getAqiGoodCount() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("aqi_id", 2);//aqi_id<=2
        return statisticsMapper.selectCount(queryWrapper);
    }

    @Override
    public String getProvinceCoverage() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("COUNT(DISTINCT province_id) AS count");
        Map<String, Object> resultMap = statisticsMapper.selectMaps(queryWrapper).get(0);
        Long count = (Long) resultMap.get("count");
        double percentage = (double) count / 34 * 100;
        String result = String.format("%.2f%%", percentage);
        return result;
    }

    @Override
    public String getCityCoverage() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("COUNT(DISTINCT province_id) AS count");
        Map<String, Object> resultMap = statisticsMapper.selectMaps(queryWrapper).get(0);
        Long count = (Long) resultMap.get("count");
        double percentage = (double) count / 660 * 100;
        String result = String.format("%.2f%%", percentage);
        return result;
    }

    @Override
    public List<AqiTrendTotalStatisDto> listAqiTrendTotalStatis() {
        //获取当前12个月列表，作为查询参数
        List<AqiTrendTotalStatisDto> parameList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        for(int i=0;i<12;i++) {
            //计算当前日期的前一个月
            calendar.add(Calendar.MONTH, -1);
            AqiTrendTotalStatisDto dto = new AqiTrendTotalStatisDto();
            dto.setMonth(sdf.format(calendar.getTime()));
            parameList.add(dto);
        }
        return statisticsMapper.listAqiTrendTotalStatis(parameList);
    }

}
