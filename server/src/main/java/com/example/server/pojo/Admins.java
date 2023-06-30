package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Collection;

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
public class Admins implements Serializable{

    private static final long serialVersionUID = 1L;


    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    @TableField("admin_code")
    private String adminCode;


    private String password;


    private String remarks;

}
