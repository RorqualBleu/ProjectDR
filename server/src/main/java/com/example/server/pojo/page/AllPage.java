package com.example.server.pojo.page;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AllPage {

    private int provinceId;

    private int cityId;

    private String confirmDate;//确认时间

    private int pageNum;//当前页码
    private int pageSize;//每页显示数量

    private String afDate;
    private String estimatedGrade;

}
