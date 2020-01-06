package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.InvestSchedule;
/**
 * pro投融资项目余额表附表(用于拆分存储到期时间)Service
 *
 * @author chenhui
 * @Date 2018-12-26 15:15:57
 */
public interface IInvestScheduleService extends IService<InvestSchedule>{
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
