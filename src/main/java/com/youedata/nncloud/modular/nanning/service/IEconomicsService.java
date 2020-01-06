package com.youedata.nncloud.modular.nanning.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Economics;

/**
 * 工业经济运行动态表Service
 *
 * @author chenhui
 * @Date 2018-12-13 11:55:07
 */
public interface IEconomicsService extends IService<Economics>{
	/**
	 * 通过某年查询所有月份的信息
	 */
	List<Economics> listEconomics(String economicsTime);
	/**
	 * 通过起始时间和结束时间查询信息
	 */
	Map countEconomics(String startTime, String endTime);
	/**
	 * 某年月份查询信息
	 */
	Map countMonths(String economicsTime);
	
	//统计全市工业经济运行动态(同比和环比计算)
	Economics calculation();
	
	//统计区县工业经济运行动态(同比和环比计算)
	Map<String, Object> areaCalculation(String economicsTime);
	
	//统计产业经济运行动态(同比和环比计算)
	Economics industryDetails(String industryId, String economicsTime);
	
	//统计所有产业主营业务收入(扇形)
	Map<String, Object> industrySector(String economicsTime);
	
	/**
	 * 通过区县id查询信息(区县接口)
	 */
	Map countDistrictId(int economicsDistrictId, String startTime, String endTime);
	/**
	 * 获取某区县下的某年月份查询信息(区县接口)
	 */
	Map countDistrictMonths(int economicsDistrictId, String economicsTime);
	/**
	 * 根据行业查询
	 */
	Map economicsIndustryId(String economicsIndustryId, String startTime, String endTime);
	
}
