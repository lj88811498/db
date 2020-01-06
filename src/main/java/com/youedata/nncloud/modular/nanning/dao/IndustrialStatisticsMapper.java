package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.IndustrialStatistics;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 工业运行走势分析 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@Transactional
@Component
public interface IndustrialStatisticsMapper extends BaseMapper<IndustrialStatistics> {


    String getMaxOutPut(@Param("userId") int userId);

}
