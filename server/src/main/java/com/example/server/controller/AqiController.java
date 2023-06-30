package com.example.server.controller;


import com.example.server.pojo.Aqi;
import com.example.server.service.IAqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/aqi")
public class AqiController {
    @Autowired
    private IAqiService aqiService;


    @GetMapping("/listAqiAll")
    public List<Aqi> selectAll(){
        return aqiService.selectAll();
    }
}
