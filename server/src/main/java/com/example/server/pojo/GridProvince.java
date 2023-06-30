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
public class GridProvince implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "province_id", type = IdType.AUTO)
    private Integer provinceId;

    @TableField("province_name")
    private String provinceName;

    @TableField("province_abbr")
    private String provinceAbbr;

    private String remarks;


}
