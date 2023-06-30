package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.AdminsMapper;
import com.example.server.pojo.Admins;
import com.example.server.pojo.RespBean;
import com.example.server.service.IAdminsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements IAdminsService {

    @Resource
    private AdminsMapper adminsMapper;

    @Override
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
    }

    //查询数据库的用户名是否存在
    public Admins selectByCode(String code){
        //构造条件
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        //将前端传来的学号和数据库进行对比
        wrapper.lambda().eq(Admins::getAdminCode,code);
        //发送给mapper的方法来获取返回值
        List<Admins> adminstList = adminsMapper.selectList(wrapper);
        //若返回结果为空，就没有这个学号
        if(CollectionUtils.isEmpty(adminstList)){
            return null;
        }else{
            return adminstList.get(0);                    //若有就把这个集合返回回去
        }
    }
}
