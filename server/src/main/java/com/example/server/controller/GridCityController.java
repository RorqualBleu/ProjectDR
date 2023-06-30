package com.example.server.controller;


import com.example.server.pojo.GridCity;
import com.example.server.service.IGridCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/gridCity")
public class GridCityController {

    @Autowired
    private IGridCityService gridCityService;

    //根据所属省查询市信息列表
    @GetMapping("/listGridCityByProvinceId")
    public List<GridCity> ListGridCityByProvinceId(@RequestBody GridCity gridCity){
        return gridCityService.listGridCityByProvinceId(gridCity);
    }
}
