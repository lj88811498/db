package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.IndustrialStatistics;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IIndustrialStatisticsService;


/**
 * 工业运行走势分析Service
 *
 * @author TC
 * @Date 2018-12-13 13:24:41
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IndustrialStatisticsServiceImpl extends ServiceImpl<BaseMapper<IndustrialStatistics>,IndustrialStatistics> implements IIndustrialStatisticsService {
}
