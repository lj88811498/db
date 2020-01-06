package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.Economics;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 工业经济运行动态表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@Transactional
@Component
public interface EconomicsMapper extends BaseMapper<Economics> {
	/**
	 * 通过某年查询所有月份的信息
	 */
	List<Economics> listEconomics(@Param("economicsTime") String economicsTime);
	/**
	 * 通过起始时间和结束时间查询信息
	 */
	Map countEconomics(@Param("startTime") String startTime, @Param("endTime") String endTime);
	/**
	 * 某年月份查询信息
	 */
	Map countMonths(@Param("economicsTime") String economicsTime);
	/**
	 * 通过区县id查询信息(区县)
	 */
	Map countDistrictId(@Param("economicsDistrictId") int economicsDistrictId, @Param("startTime") String startTime, @Param("endTime") String endTime);
	/**
	 * 获取某区县下的某年月份查询信息(区县)
	 */
	Map countDistrictMonths(@Param("economicsDistrictId") int economicsDistrictId, @Param("economicsTime") String economicsTime);
	/**
	 * 根据行业查询
	 */
	Map economicsIndustryId(@Param("economicsIndustryId") String economicsIndustryId, @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	
}
