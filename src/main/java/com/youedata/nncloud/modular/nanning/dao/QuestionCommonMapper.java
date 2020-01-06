package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.QuestionCommon;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 常见问题表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-09
 */
@Transactional
@Component
public interface QuestionCommonMapper extends BaseMapper<QuestionCommon> {

    List<QuestionCommon> getList(@Param("title") String title,
                                 @Param("type") String type,
                                 @Param("beginTime") String beginTime,
                                 @Param("endTime") String endTime,
                                 @Param("status") String status,
                                 @Param("page") Page page,
                                 @Param("orderByField") String orderByField,
                                 @Param("isAsc") boolean isAsc);

    /**
     * 添加并返回id
     * @return
     */
    Integer insertGetId(QuestionCommon questionCommon);
}
