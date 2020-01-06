package com.youedata.nncloud.modular.nanning.service;
import com.youedata.nncloud.modular.nanning.model.IndustryData;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Industry;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
/**
 * 工业报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IIndustryService extends IService<Industry>{
	/**
	  * 查询工业报表列表
	  * @param page
	  * @return
	  */
	 Page getList(String industryEnterpriseId, int size, int curPage, String industryName, String enterpriseName, String startTime, String endTime);
	 /**
     * 根据工业报表id获取信息
     * @param roleId
     * @return
     */
	 Industry getById(@Param("industryId") Integer industryId);

	/**
	 * 工业数据填报查询
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	 IndustryData getIndustryData(Integer userId, String startTime, String endTime);
}
