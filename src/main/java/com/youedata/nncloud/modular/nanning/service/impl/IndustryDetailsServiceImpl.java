package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IndustryDetailsMapper;
import com.youedata.nncloud.modular.nanning.dao.IndustryMapper;
import com.youedata.nncloud.modular.nanning.model.Industry;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IIndustryDetailsService;


/**
 * 工业报表详情表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IndustryDetailsServiceImpl extends ServiceImpl<BaseMapper<IndustryDetails>,IndustryDetails> implements IIndustryDetailsService {
	 @Resource
	 IndustryDetailsMapper industryDetailsMapper;
	 
	 @Resource
	 IndustryMapper industryMapper;

	@Override
	public Page getIndustryDetails(Integer industryDetailsIndustryId, String industryDetailsType, int size, int curPage) {
		 Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
		 List<IndustryDetails> result = industryDetailsMapper.getIndustryDetails(industryDetailsIndustryId, industryDetailsType, page);
		 //查询工业中的年份进行处理
		 Industry industry = industryMapper.getById(industryDetailsIndustryId);
		 if(!StringUtils.isEmpty(String.valueOf(industry.getIndustryYear()))){
			int year = Integer.parseInt(String.valueOf(industry.getIndustryYear()).substring(0,4));
			String month = String.valueOf(industry.getIndustryYear()).substring(4,6);
			 for (int i = 0; i < result.size(); i++) {
		    	 result.get(i).setNewYear(year+"年"+Integer.parseInt(month)+"月");
		    	 result.get(i).setOldYear((year-1)+"年"+Integer.parseInt(month)+"月");
		    	 if(Integer.parseInt(month) !=1){
			    	 result.get(i).setNewAccumulate(year+"年1-"+Integer.parseInt(month)+"月累计");
			    	 result.get(i).setOldAccumulate((year-1)+"年1-"+Integer.parseInt(month)+"月累计");
		    	 }else{
		    		 result.get(i).setNewAccumulate(year+"年"+Integer.parseInt(month)+"月累计");
			    	 result.get(i).setOldAccumulate((year-1)+"年"+Integer.parseInt(month)+"月累计");
		    	 }
		    	 result.get(i).setEstimate(year+"年"+(Integer.parseInt(month)+1)+"月预计");
			}
		}
		 page.setRecords(result);
		 return page;
	}
	
}
