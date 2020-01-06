package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.youedata.nncloud.modular.nanning.dao.InvestScheduleMapper;
import com.youedata.nncloud.modular.nanning.model.InvestSchedule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IInvestScheduleService;


/**
 * pro投融资项目余额表附表(用于拆分存储到期时间)Service
 *
 * @author chenhui
 * @Date 2018-12-26 15:15:57
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class InvestScheduleServiceImpl extends ServiceImpl<BaseMapper<InvestSchedule>,InvestSchedule> implements IInvestScheduleService {
	@Resource
	InvestScheduleMapper investScheduleMapper;
	
	@Override
	public void saveInvestSchedule(InvestSchedule investSchedule) {
		investScheduleMapper.saveInvestSchedule(investSchedule);
	}

	@Override
	public int platformTotal() {
		return investScheduleMapper.platformTotal();
	}

	@Override
	public int bankTotal() {
		return investScheduleMapper.bankTotal();
	}

	@Override
	public int bankDateTotal(String investMatchExpiryDate) {
		return investScheduleMapper.bankDateTotal(investMatchExpiryDate);
	}
}
