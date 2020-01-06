package com.youedata.nncloud.modular.nanning.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Invest;
import com.youedata.nncloud.modular.nanning.model.vo.InvestVo;

import java.util.List;
import java.util.Map;

/**
 * pro投融资项目余额表Service
 *
 * @author fxh
 * @Date 2018-12-25 10:32:44
 */
public interface IInvestService extends IService<Invest>{
/*-------------------------chenhui--------------------------------*/
	/**
	 * 获取所有信息
	 */
	List<Invest> list();
	/**
	 * 获取所有担保方式
	 */
	List<Invest> guaranteeMode(String startTime, String endTime);
	/**
	 * 通过年份和季度获取未评定的数量
	 */
	int countRating(String startTime, String endTime, String investCreditRating);
	/**
	 * 通过年份和季度获取已评定的数量
	 */
	int countAssessed(String startTime, String endTime, String investCreditRating);
	//公共方法获取评分的数量
	Map<String, Object> ratingTotal(String year, String quarter);
	//公共方法通过担保方式获取该季节的项目数量和项目金额
	Map<String, Object> modeDetails(String year, String quarter);
	/**
	 * 查询所有余额合计和余额
	 */
	InvestVo balance();
	//查询某年中五级分类的所有项目件数
	Map<String, Object> itemNumber();
	/**
	 * 获取所有潜在风险项目接口
	 */
	Page listProject(int size, int curPage);
	/**
	 * 通过年份和季度查询最高利率
	 */
	Map<String, Object> interest(String year, String quarter);
	/**
	 * 通过附表银行id查询信息
	 */
	Map<String, Object> getBankDataId(Integer investBankDataId);
	/**
	 * 保存用于拆分银行平台(平台配套)到期时间
	 */
	void saveExpiryDate();
	/**
	 * 删除平台中所有的到期时间(*慎用)
	 */
	void removeExpiryDate();
	/**
	 * 保存用于拆分银行平台(平台配套)利息
	 */
	void saveInterestRate();
	/**
	 * 删除平台中所有的利息(*慎用)
	 */
	void removeInterestRate();
	/**
	 * 通过附表银行id查询信息
	 */
	List<Invest> findBankDataId(Integer investBankDataId);
	
/*-------------------------xiaohong--------------------------------*/

	void disInvestLoanDay();
	void managingBankDis();

    String getAllCompanyCount();

	String getCurrentBorrowCompCount();

	List financingProject();

	List lendingCompany();

    List loanContract();

    List projectMoneyDistri();

	Map creditMoney();

	List moneyFlow();

    List natureAndMoneyChange();


	List bankInvest(String bankId);

	List bankData();



}
