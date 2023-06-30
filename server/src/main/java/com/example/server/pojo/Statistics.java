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
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("province_id")
    private Integer provinceId;

    @TableField("city_id")
    private Integer cityId;

    private String address;

    @TableField("so2_value")
    private Integer so2Value;

    @TableField("so2_level")
    private Integer so2Level;

    @TableField("co_value")
    private Integer coValue;

    @TableField("co_level")
    private Integer coLevel;

    @TableField("spm_value")
    private Integer spmValue;

    @TableField("spm_level")
    private Integer spmLevel;

    @TableField("aqi_id")
    private Integer aqiId;

    @TableField("confirm_date")
    private String confirmDate;

    @TableField("confirm_time")
    private String confirmTime;

    @TableField("gm_id")
    private Integer gmId;

    @TableField("fd_id")
    private String fdId;

    private String information;

    private String remarks;


}
