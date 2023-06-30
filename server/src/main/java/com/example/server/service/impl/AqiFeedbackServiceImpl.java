package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.AqiFeedbackMapper;
import com.example.server.pojo.AqiFeedback;
import com.example.server.pojo.Statistics;
import com.example.server.pojo.page.AllPage;
import com.example.server.service.IAqiFeedbackService;
import org.springframework.stereotype.Service;

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
public class AqiFeedbackServiceImpl extends ServiceImpl<AqiFeedbackMapper, AqiFeedback> implements IAqiFeedbackService {

    @Resource
    private AqiFeedbackMapper aqiFeedbackMapper;
    @Override
    public int saveAqiFeedback(AqiFeedback aqiFeedback) {
        int rows = aqiFeedbackMapper.insert(aqiFeedback);//返回插入的记录数
        if (rows > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<AqiFeedback> listAqiFeedbackByTelId(AqiFeedback aqiFeedback) {
         int rows = aqiFeedbackMapper.insert(aqiFeedback);
         if(rows > 0){
             QueryWrapper<AqiFeedback> queryWrapper = new QueryWrapper<>();
             queryWrapper.eq("af_id", aqiFeedback.getAfId());
             return aqiFeedbackMapper.selectList(queryWrapper);
         }else {
             return null;
         }
    }

    @Override
    public AqiFeedback getAqiFeedbackById(AqiFeedback aqiFeedback) {
        return aqiFeedbackMapper.selectById(aqiFeedback.getAfId());
    }

    @Override
    public int updateAqiFeedbackAssign(AqiFeedback aqiFeedback) {
        int rows = aqiFeedbackMapper.updateById(aqiFeedback);//会根据主键信息更新
        if (rows > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<AqiFeedback> listAqiFeedbackByGmId(AqiFeedback aqiFeedback) {
        QueryWrapper<AqiFeedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gm_id",aqiFeedback.getGmId());
        return aqiFeedbackMapper.selectList(queryWrapper);
    }

    @Override
    public int updateAqiFeedbackState(AqiFeedback aqiFeedback) {
        int rows = aqiFeedbackMapper.updateById(aqiFeedback);//会根据主键信息更新
        if (rows > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public IPage<AqiFeedback> listAqiFeedbackPage(AllPage allPage) {
        Page<AqiFeedback> page = new Page<>(allPage.getPageNum(), allPage.getPageSize());
        QueryWrapper<AqiFeedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("province_id",allPage.getProvinceId()).like("city_id",allPage.getCityId()).like("af_date",allPage.getAfDate()).like("estimated_grade",allPage.getEstimatedGrade());
        return aqiFeedbackMapper.selectPage(page, queryWrapper);
    }


}
