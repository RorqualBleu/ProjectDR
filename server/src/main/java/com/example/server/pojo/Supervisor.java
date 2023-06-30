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
public class Supervisor implements Serializable {

    //private static final long serialVersionUID = 1L;

    @TableField("tel_id")
    private String telId;

    private String password;

    @TableField("real_name")
    private String realName;

    private String birthday;

    private Integer sex;

    private String remarks;


}
