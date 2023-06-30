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
public class GridMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gm_id", type = IdType.AUTO)
    private Integer gmId;

    @TableField("gm_name")
    private String gmName;

    @TableField("gm_code")
    private String gmCode;

    private String password;

    @TableField("province_id")
    private Integer provinceId;

    @TableField("city_id")
    private Integer cityId;

    private String tel;

    private Integer state;

    private String remarks;


}
