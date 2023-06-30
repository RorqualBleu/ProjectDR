package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AqiFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "af_id", type = IdType.AUTO)
    private Integer afId;

    @TableField("tel_id")
    private String telId;

    @TableField("province_id")
    private Integer provinceId;

    @TableField("city_id")
    private Integer cityId;

    private String address;

    private String information;

    @TableField("estimated_grade")
    private Integer estimatedGrade;

    @TableField("af_date")
    private String afDate;

    @TableField("af_time")
    private String afTime;

    @TableField("gm_id")
    private Integer gmId;

    @TableField("assign_date")
    private String assignDate;

    @TableField("assign_time")
    private String assignTime;

    private Integer state;

    private String remarks;


}
