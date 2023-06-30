package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.GridMember;
import com.example.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IGridMemberService extends IService<GridMember> {

    List<GridMember> listGridMemberByProvinceId(GridMember gridMember);

    RespBean getGridMemberByCodeByPass(GridMember gridMember);
}
