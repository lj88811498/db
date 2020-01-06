package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.TitleEvaluation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 职称评审 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-15
 */
@Transactional
@Component
public interface TitleEvaluationMapper extends BaseMapper<TitleEvaluation> {

    List<TitleEvaluation> selectList(@Param("title")String titleEvaluationTitle,
                                     @Param("updateTime")String titleEvaluationUpdateTime,
                                     @Param("updateTimeEnd")String titleEvaluationUpdateTimeEnd,
                                     @Param("status")String titleEvaluationStatus,
                                     @Param("page")Page page);
}
