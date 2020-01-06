package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.FinanceDetails;
/**
 * 财务报表详情表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IFinanceDetailsService extends IService<FinanceDetails>{
	/**
	 * 通过财务报表id和标题类型查询信息
	 * @param financeDetailsFinanceId
	 * @param financeDetailsType
	 * @param size
	 * @param curPage
	 * @return
	 */
	 Page getFinanceDetails(Integer financeDetailsFinanceId, String financeDetailsType, int size, int curPage);


	int add(FinanceDetails financeDetails);
}
