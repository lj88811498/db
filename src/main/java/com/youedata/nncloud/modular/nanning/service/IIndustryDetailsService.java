package com.youedata.nncloud.modular.nanning.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
/**
 * 工业报表详情表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IIndustryDetailsService extends IService<IndustryDetails>{
	 /**
	  * 通过工业报表id和标题类型查询信息
	  * @param industryDetailsIndustryId
	  * @param industryDetailsType
	  * @return
	  */
	 Page getIndustryDetails(Integer industryDetailsIndustryId, String industryDetailsType, int size, int curPage);
}
