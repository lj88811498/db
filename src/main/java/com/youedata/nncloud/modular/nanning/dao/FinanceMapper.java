package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Finance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 财务报表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface FinanceMapper extends BaseMapper<Finance> {
	/**
	  * 查询财务报表列表
	  * @param page
	  * @return
	  */
	 List<Finance> getList(@Param("page") Page page, @Param("financeEnterpriseId") String financeEnterpriseId, @Param("financeName") String financeName, @Param("enterpriseName") String enterpriseName, @Param("startTime") String startTime, @Param("endTime") String endTime);
	 /**
	    * 根据财务报表id获取信息
	    * @param roleId
	    * @return
	    */
	 Finance getById(@Param("financeId") Integer financeId);



	 int add(Finance finance);
}
