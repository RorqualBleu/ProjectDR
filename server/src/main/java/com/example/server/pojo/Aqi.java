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
public class Aqi implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "aqi_id", type = IdType.AUTO)
    private Integer aqiId;

    @TableField("chinese_explain")
    private String chineseExplain;

    @TableField("aqi_explain")
    private String aqiExplain;

    private String color;

    @TableField("health_impact")
    private String healthImpact;

    @TableField("take_steps")
    private String takeSteps;

    @TableField("so2_min")
    private Integer so2Min;

    @TableField("so2_max")
    private Integer so2Max;

    @TableField("co_min")
    private Integer coMin;

    @TableField("co_max")
    private Integer coMax;

    @TableField("spm_min")
    private Integer spmMin;

    @TableField("spm_max")
    private Integer spmMax;

    private String remarks;


}
