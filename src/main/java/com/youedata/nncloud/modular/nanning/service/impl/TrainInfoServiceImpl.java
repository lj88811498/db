package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.TrainInfo;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.ITrainInfoService;


/**
 * 培训信息Service
 *
 * @author TC
 * @Date 2019-01-21 13:41:31
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class TrainInfoServiceImpl extends ServiceImpl<BaseMapper<TrainInfo>,TrainInfo> implements ITrainInfoService {
}
