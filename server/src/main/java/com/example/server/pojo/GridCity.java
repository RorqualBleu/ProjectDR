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
public class GridCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "city_id", type = IdType.AUTO)
    private Integer cityId;

    @TableField("city_name")
    private String cityName;

    @TableField("province_id")
    private Integer provinceId;

    private String remarks;


}
