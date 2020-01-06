package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.IndustryData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 工业填报数据查询 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@Transactional
@Component
public interface IndustryDataMapper extends BaseMapper<IndustryData> {
    /**
     * 工业数据填报查询
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    IndustryData getIndustryData(@Param("userId") Integer userId,
                                 @Param("startTime") String startTime,
                                 @Param("endTime") String endTime);
}
