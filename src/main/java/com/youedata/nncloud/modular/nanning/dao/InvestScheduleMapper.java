package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.InvestSchedule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * pro投融资项目余额表附表(用于拆分存储到期时间); InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-26
 */
@Transactional
@Component
public interface InvestScheduleMapper extends BaseMapper<InvestSchedule> {
	/**
	 * 存储信息
	 */
	void saveInvestSchedule(InvestSchedule investSchedule);
	/**
	 * 获取平台到期合同的数量
	 */
	int platformTotal();
	/**
	 * 获取银行到期合同的数量
	 */
	int bankTotal();
	/**
	 * 通过时间查询(平台银行自营)到期日的数量
	 */
	int bankDateTotal(String investMatchExpiryDate);

}
