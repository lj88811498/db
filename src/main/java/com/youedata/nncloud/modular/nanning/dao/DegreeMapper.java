package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.Degree;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 满意度 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface DegreeMapper extends BaseMapper<Degree> {

    /**
     * 整体满意度
     * @return
     */
    Double getMainAvg(@Param("date")String date, @Param("serviceId")Integer serviceId);

    /**
     * 客服回复满意度
     * @return
     */
    Double getAnswerAvg(@Param("date")String date, @Param("serviceId")Integer serviceId);

    /**
     * 客服工作态度满意度
     * @return
     */
    Double getWorkAvg(@Param("date")String date, @Param("serviceId")Integer serviceId);
    /**
     * 客服工作态度满意度
     * @return
     */
    Double getOfficeAvg(@Param("date")String date, @Param("serviceId")Integer serviceId);

    /**
     * 根据问题id和用户id查询
     * @param questionId
     * @param userId
     * @return
     */
    Degree getByUserIdAndQuestionId(@Param("questionId")Integer questionId, @Param("userId")Integer userId);
}
