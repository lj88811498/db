package com.youedata.nncloud.modular.nanning.service;
import com.alibaba.fastjson.JSONObject;
import com.youedata.nncloud.modular.nanning.model.FinanceData;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Finance;
import com.youedata.nncloud.modular.nanning.model.Industry;

import java.util.List;
import java.util.Map;

/**
 * 财务报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IFinanceService extends IService<Finance>{
	/**
	  * 查询财务报表列表
	  * @return
	  */
	 Page getList(String financeEnterpriseId, int size, int curPage, String financeName, String enterpriseName, String startTime, String endTime);
	 /**
	   * 根据财务报表id获取信息
	   * @return
	   */
	 Finance getById(@Param("financeId") Integer financeId);

	/**
	 * 查询财务填报数据
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	FinanceData getFinanceData(Integer userId, String startTime, String endTime);

	/**
	 * 企业图谱-经营状况
	 * @param companyId
	 * @param year
	 * @return
	 */
	List<Map<String,String>> getManagement(Integer companyId, String year);

	/**
	 * 企业图谱-同期累计
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getCumulative(Integer companyId,String  year);

	/**
	 * 经营趋势及增长-营业收入
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getIncome(Integer companyId);

	/**
	 * 经营趋势及增长-营业成本
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getCost(Integer companyId);

	/**
	 * 经营趋势及增长-利润
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getProfit(Integer companyId);

	/**
	 *  工业生产情况
	 * @param companyId
	 * @param type
	 * @return
	 */
	JSONObject getProduction(Integer companyId, Integer type, Integer year);


	int add(Finance finance);

}
