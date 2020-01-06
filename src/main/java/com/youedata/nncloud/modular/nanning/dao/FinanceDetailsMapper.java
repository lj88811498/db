package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.FinanceDetails;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 财务报表详情表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface FinanceDetailsMapper extends BaseMapper<FinanceDetails> {
	 /**
	  * 通过财务报表id和标题类型查询信息
	  * @param financeDetailsFinanceId
	  * @param financeDetailsType
	  * @return
	  */
	 List<FinanceDetails> getFinanceDetails(@Param("financeDetailsFinanceId") Integer financeDetailsFinanceId, @Param("financeDetailsType") String financeDetailsType, @Param("page") Page page);

	/**
	 * 企业图谱-同期累计
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getCumulative(@Param("companyId")Integer companyId,@Param("year")String year);

	/**
	 * 企业图谱-营业收入
	 * @param companyId
	 * @return
	 */
    List<Map<String,String>> getIncome(@Param("companyId")Integer companyId);

	/**
	 * 企业图谱-营业成本
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getCost(@Param("companyId")Integer companyId);

	/**
	 * 企业图谱-利润
	 * @param companyId
	 * @return
	 */
	List<Map<String,String>> getProfit(@Param("companyId")Integer companyId);



	int add(FinanceDetails financeDetails);
}
