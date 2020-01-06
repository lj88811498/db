package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.EnterpriseFinancing;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IEnterpriseFinancingService;


/**
 * 企业融资信息Service
 *
 * @author TC
 * @Date 2019-01-23 10:15:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class EnterpriseFinancingServiceImpl extends ServiceImpl<BaseMapper<EnterpriseFinancing>,EnterpriseFinancing> implements IEnterpriseFinancingService {
}
