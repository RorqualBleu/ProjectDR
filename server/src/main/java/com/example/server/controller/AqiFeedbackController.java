package com.example.server.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.server.pojo.AqiFeedback;
import com.example.server.pojo.page.AllPage;
import com.example.server.service.IAqiFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/aqiFeedback")
public class AqiFeedbackController {

    @Autowired
    private IAqiFeedbackService aqiFeedbackService;

    //保存公众监督员的AQI反馈信息
    @PostMapping("/saveAqiFeedback")
    public int SaveAqiFeedback(@RequestBody AqiFeedback aqiFeedback){
        try {
            return aqiFeedbackService.saveAqiFeedback(aqiFeedback);
        }catch (Exception e){
            e.printStackTrace();
            return 0;   //如果插入失败发生异常返回0
        }
    }

    //保存公众监督员的AQI反馈信息
    @PostMapping("/listAqiFeedbackByTelId")
    public List<AqiFeedback> ListAqiFeedbackByTelId(@RequestBody AqiFeedback aqiFeedback){
        return aqiFeedbackService.listAqiFeedbackByTelId(aqiFeedback);
    }

    //查询AQI反馈信息，并有模糊查询和分页功能
    @GetMapping("/listAqiFeedbackPage")
    public IPage<AqiFeedback> ListAqiFeedbackPage(@RequestBody AllPage allPage){
        return aqiFeedbackService.listAqiFeedbackPage(allPage);
    }

    //根据主键查询AQI反馈信息
    @GetMapping("/getAqiFeedbackById")
    public AqiFeedback GetAqiFeedbackById(@RequestBody AqiFeedback aqiFeedback){
        return aqiFeedbackService.getAqiFeedbackById(aqiFeedback);
    }

    //根据主键更新AQI反馈信息（更新指派信息）
    @PostMapping("/updateAqiFeedbackAssign")
    public int UpdateAqiFeedbackAssign(@RequestBody AqiFeedback aqiFeedback){
        try {
            return aqiFeedbackService.updateAqiFeedbackAssign(aqiFeedback);
        }catch (Exception e){
            e.printStackTrace();
            return 0;   //如果插入失败发生异常返回0
        }
    }

    //根据网格员编号查询指派给网格员的AQI反馈信息
    @GetMapping("/listAqiFeedbackByGmId")
    public List<AqiFeedback> ListAqiFeedbackByGmId(@RequestBody AqiFeedback aqiFeedback){
        System.out.println("-------------------------------");
        System.out.println(aqiFeedback);
        System.out.println("-------------------------------");

        return aqiFeedbackService.listAqiFeedbackByGmId(aqiFeedback);
    }

    //根据主键更新AQI反馈信息（更新状态）
    @PostMapping("/updateAqiFeedbackState")
    public int UpdateAqiFeedbackState(@RequestBody AqiFeedback aqiFeedback){
        try {
            return aqiFeedbackService.updateAqiFeedbackState(aqiFeedback);
        }catch (Exception e){
            e.printStackTrace();
            return 0;   //如果插入失败发生异常返回0
        }
    }

}
