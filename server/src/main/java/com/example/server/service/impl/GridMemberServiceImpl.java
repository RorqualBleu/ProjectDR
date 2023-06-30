package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.GridMemberMapper;
import com.example.server.pojo.Admins;
import com.example.server.pojo.GridMember;
import com.example.server.pojo.RespBean;
import com.example.server.service.IGridMemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
@Service
public class GridMemberServiceImpl extends ServiceImpl<GridMemberMapper, GridMember> implements IGridMemberService {

    @Resource
    private GridMemberMapper gridMemberMapper;
    @Override
    public List<GridMember> listGridMemberByProvinceId(GridMember gridMember) {
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",0).eq("province_id",gridMember.getProvinceId()).eq("city_id",gridMember.getCityId());
        return gridMemberMapper.selectList(queryWrapper);
    }

/*    @Override
    public GridMember getGridMemberByCodeByPass(GridMember gridMember) {
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gm_code",gridMember.getGmCode()).eq("password",gridMember.getPassword());
        return gridMemberMapper.selectOne(queryWrapper);
    }*/

    @Override
    public RespBean getGridMemberByCodeByPass(GridMember gridMember) {
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gm_code",gridMember.getGmCode()).eq("password",gridMember.getPassword());
        GridMember gridMember1 = gridMemberMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(gridMember1)){
            return RespBean.error("用户名不存在或密码不正确");
        }else {
            return RespBean.success("登录成功");
        }

    }

/*    @Override
    public RespBean login(Admins admins) {
        //先查询学号是否存在(从数据库查询来的用studentDB命名)
        Admins adminsDB = selectByCode(admins.getAdminCode());
        //查询是否为空 若为空，就提示用户名不存在或密码不正确
        if(ObjectUtils.isEmpty(adminsDB)) {
            return RespBean.success("用户名不存在或密码不正确");
        }else{
            if(adminsDB.getPassword().equals(admins.getPassword())){
                //若密码一致就登录成功
                return RespBean.success("登录成功");
            }else{
                //密码错误
                return RespBean.error("用户名不存在或密码不正确");
            }
        }
    }*/
}
