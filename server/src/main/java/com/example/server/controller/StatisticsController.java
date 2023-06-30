package com.example.server.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.server.pojo.AqiTrendTotalStatisDto;
import com.example.server.pojo.Statistics;
import com.example.server.pojo.page.AllPage;
import com.example.server.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private IStatisticsService statisticsService;

    @PostMapping("/saveStatistics")
    public int SaveStatistics(@RequestBody Statistics statistics){
        try {
            return statisticsService.saveStatistics(statistics);
        }catch (Exception e){
            e.printStackTrace();
            return 0;   //如果插入失败发生异常返回0
        }
    }

    //查询确认AQI信息列表，并有模糊查询和分页功能
    @GetMapping("/listStatisticsPage")
    public IPage<Statistics> ListStatisticsPage(@RequestBody AllPage statisticsPage){
        return statisticsService.listStatisticsPage(statisticsPage);
    }

    @GetMapping("/getStatisticsById")
    public Statistics GetStatisticsById(@RequestBody Statistics statistics){
        return statisticsService.getStatisticsById(statistics);
    }

    //查询省分组AQI超标累计信息
    @GetMapping("/listProvinceItemTotalStatis")
    public List<Map<String,Object>> ListProvinceItemTotalStatis(){
        return statisticsService.listProvinceItemTotalStatis();
    }

    //查询以AQI等级为分组的AQI超标分布统计信息
    @GetMapping("/listAqiDistributeTotalStatis")
    public List<Map<String,Object>> ListAqiDistributeTotalStatis(){
        return statisticsService.listAqiDistributeTotalStatis();
    }

    //查询当前12个月的AQI超标趋势统计信息
    @GetMapping("/listAqiTrendTotalStatis")
    public List<AqiTrendTotalStatisDto> listAqiTrendTotalStatis() {
        return statisticsService.listAqiTrendTotalStatis();
    }

    //查询确认AQI数据数量
    @GetMapping("/getAqiCount")
    public Integer GetAqiCount(){
        return statisticsService.getAqiCount();
    }

    //查询确认AQI良好数据数量
    @GetMapping("/getAqiGoodCount")
    public Integer GetAqiGoodCount(){
        return statisticsService.getAqiGoodCount();
    }

    //查询省网格的全国覆盖率
    @GetMapping("/getProvinceCoverage")
    public String GetProvinceCoverage(){
        return statisticsService.getProvinceCoverage();
    }

    //查询大城市网格的全国覆盖率
    @GetMapping("/getCityCoverage")
    public String GetCityCoverage(){
        return statisticsService.getCityCoverage();
    }
}
