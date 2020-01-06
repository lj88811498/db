package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Degree;
/**
 * 满意度Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IDegreeService extends IService<Degree>{

    /**
     * 整体满意度
     * @return
     */
    int getMainAvg(String date, Integer serviceId);

    /**
     * 客服回复满意度
     * @return
     */
    int getAnswerAvg(String date, Integer serviceId);

    /**
     * 客服工作态度满意度
     * @return
     */
    int getWorkAvg(String date, Integer serviceId);

    /**
     * 委办局满意度
     * @return
     */
    int getOfficeAvg(String date, Integer serviceId);

    /**
     * 根据问题id和用户id查询
     * @param questionId
     * @param userId
     * @return
     */
    Degree getByUserIdAndQuestionId(Integer questionId, Integer userId);
}
