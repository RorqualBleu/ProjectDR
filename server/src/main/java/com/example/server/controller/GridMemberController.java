package com.example.server.controller;


import com.example.server.pojo.GridMember;
import com.example.server.pojo.RespBean;
import com.example.server.service.IGridCityService;
import com.example.server.service.IGridMemberService;
import com.example.server.service.impl.GridMemberServiceImpl;
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
@RequestMapping("/gridMember")
public class GridMemberController {

    @Autowired
    private IGridMemberService gridMemberService;

    //根据省和市查询可工作状态的所属网格员信息列表
    @GetMapping("/listGridMemberByProvinceId")
    public List<GridMember> ListGridMemberByProvinceId(@RequestBody GridMember gridMember){
        return gridMemberService.listGridMemberByProvinceId(gridMember);
    }

    //根据网格员登录编码和密码进行查询，用于登录
    @GetMapping("/getGridMemberByCodeByPass")
    public RespBean GetGridMemberByCodeByPass(@RequestBody GridMember gridMember){
        return gridMemberService.getGridMemberByCodeByPass(gridMember);
    }
}
