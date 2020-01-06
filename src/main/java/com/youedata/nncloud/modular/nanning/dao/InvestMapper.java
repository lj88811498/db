package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.Industry;
import com.youedata.nncloud.modular.nanning.model.Invest;
import com.youedata.nncloud.modular.nanning.model.vo.InvestVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * pro投融资项目余额表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-25
 */
@Transactional
@Component
public interface InvestMapper extends BaseMapper<Invest> {
/*-------------------------chenhui--------------------------------*/
	/**
	 * 获取所有信息
	 */
	List<Invest> list();
	/**
	 * 获取所有担保方式
	 */
	List<Invest> guaranteeMode(@Param("startTime") String startTime, @Param("endTime") String endTime);
	/**
	 * 通过年份和季度获取未评定的数量
	 */
	int countRating(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("investCreditRating") String investCreditRating);
	/** 
	 * 通过年份和季度获取已评定的数量
	 */
	int countAssessed(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("investCreditRating") String investCreditRating);
	/**
	 * 通过年份和季度获取已评定的等级
	 */
	List<Invest> grade(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("investCreditRating") String investCreditRating);
	/**
	 * 通过年份和季度及贷款方式获取项目总数和项目总金额
	 */
	Map modeDeatils(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("investGuaranteeMethod") String investGuaranteeMethod); 
	/**
	 * 查询所有余额合计和余额
	 */
	Map balance();
	/**
	 * 查询五级分类
	 */
	List<Invest> classification();
	/**
	 * 通过级分类和年份统计信息
	 */
	int classificationTotal(@Param("year") String year, @Param("investFiveClass") String investFiveClass);
	/**
	 * 获取所有潜在风险项目接口
	 */
	List<Invest> listProject(@Param("page") Page page);
	/**
	 * 通过年份和季度查询最高利率
	 */
	List<InvestVo> interest(@Param("investLoanYear") String investLoanYear, @Param("investLoanQuarter") String investLoanQuarter);
	/**
	 * 通过id查询信息
	 */
	Invest getById(@Param("investId") int investId);
	/**
	 * 通过附表银行id查询信息
	 */
	List<Invest> getBankDataId(@Param("investBankDataId") Integer investBankDataId);
	/**
	 * 保存用于拆分银行平台到期时间
	 */
	void saveSelfExpiryDate();
	/**
	 * 保存用于拆分平台配套到期时间
	 */
	void saveMatchExpiryDate();
	/**
	 * 删除平台中所有的到期时间(*慎用)
	 */
	void removeExpiryDate();
	/**
	 * 保存用于拆分银行平台利息
	 */
	void saveSelfInterestRate();
	/**
	 * 保存用于拆分平台配套利息
	 */
	void saveMatchInterestRate();
	/**
	 * 删除平台中所有的利息(*慎用)
	 */
	void removeInterestRate();
	
/*-------------------------xiaohong--------------------------------*/

    void disInvestSelfLoanDay();

    void disInvestMatchLoanDay();

	void managingBankDis();

	void bankDataDis();



    /***
     * @Description: 累计帮助企业数:  根据《pro投融资项目余额表》-企业名称字段，统计企业数量；
     * @return:
     * @Author: fxh
     * @Date: 2018/12/26
     **/
    String getAllCompanyCount();

    String getCurrentBorrowCompCount();

	List<Map<String,String>> financingProject(@Param("startYearMonth") String startYearMonth, @Param("endYearMonth") String endYearMonth);



	List<Map<String,String>> lendingCompany(@Param("startYearMonth") String startYearMonth, @Param("endYearMonth") String endYearMonth);

	List<Map<String,String>> loanContract(@Param("startYearMonth") String startYearMonth, @Param("endYearMonth") String endYearMonth);

	List<Map<String,String>> projectMoneyDistri(@Param("year") String year );



	String creditMoney();


	String bankLending();


	String centralLending();




	List<Map<String,String>> moneyFlow();





	List<Map<String,String>> natureAndMoneyChange(@Param("startYearMonth") String startYearMonth, @Param("endYearMonth") String endYearMonth);




	Map<String,String> bankInvest(@Param("yearQuarter") String yearQuarter, @Param("bankId") String bankId);




	List<Map<String,String>> bankData();

	List<Map<String,String>> getNature();


	String getByNatureAndTime(@Param("nature") String nature, @Param("time") String time);

}
