package com.example.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.AqiFeedback;
import com.example.server.pojo.page.AllPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lin
 * @since 2023-06-27
 */
public interface IAqiFeedbackService extends IService<AqiFeedback> {

    int saveAqiFeedback(AqiFeedback aqiFeedback);

    List<AqiFeedback> listAqiFeedbackByTelId(AqiFeedback aqiFeedback);

    AqiFeedback getAqiFeedbackById(AqiFeedback aqiFeedback);

    int updateAqiFeedbackAssign(AqiFeedback aqiFeedback);

    List<AqiFeedback> listAqiFeedbackByGmId(AqiFeedback aqiFeedback);

    int updateAqiFeedbackState(AqiFeedback aqiFeedback);

    IPage<AqiFeedback> listAqiFeedbackPage(AllPage allPage);
}
