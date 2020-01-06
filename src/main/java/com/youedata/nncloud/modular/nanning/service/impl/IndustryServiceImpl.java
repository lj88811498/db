package com.youedata.nncloud.modular.nanning.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.youedata.nncloud.modular.nanning.dao.EnterpriseMapper;
import com.youedata.nncloud.modular.nanning.dao.IndustryDataMapper;
import com.youedata.nncloud.modular.nanning.model.IndustryData;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IndustryMapper;
import com.youedata.nncloud.modular.nanning.model.Enterprise;
import com.youedata.nncloud.modular.nanning.model.Industry;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
import com.youedata.nncloud.modular.nanning.service.IIndustryService;


/**
 * 工业报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IndustryServiceImpl extends ServiceImpl<BaseMapper<Industry>,Industry> implements IIndustryService {
	@Resource
	IndustryMapper industryMapper;
	@Resource
	IndustryDataMapper industryDataMapper;
	@Resource
	EnterpriseMapper enterpriseMapper;
	/**
	 * 查询工业报表列表
	 */
	@Override
	public Page getList(String industryEnterpriseId, int size, int curPage, String industryName, String enterpriseName, String startTime, String endTime) {
	    Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
	    //如果userId不为空
	    if(!StringUtils.isEmpty(industryEnterpriseId)){
	    	Enterprise enterprise = enterpriseMapper.findUserId(Integer.parseInt(industryEnterpriseId));
	    	if(enterprise !=null){
	    		List<Industry> result = industryMapper.getList(page,String.valueOf(enterprise.getEnterpriseId()),industryName,null,null,null);
	    		for (int i = 0; i < result.size(); i++) {
	    			result.get(i).setEnterpriseName(enterprise.getEnterpriseName());;
				}
	    		page.setRecords(result);
	    		return page;
	    	}
	    }else if(StringUtils.isEmpty(industryEnterpriseId)){
	    	 List<Industry> result = industryMapper.getList(page,null,industryName,enterpriseName,startTime,endTime);
	         for (int i = 0; i < result.size(); i++) {
	         	Enterprise epn = enterpriseMapper.findById(Integer.parseInt(result.get(i).getIndustryEnterpriseId()));
	         	if(epn !=null){
	         		result.get(i).setEnterpriseName(epn.getEnterpriseName());
	         	}
	 		}
	         page.setRecords(result);
	         return page;
	    }
	    return page;
	}
	/**
	 * 根据工业报表id获取信息
	 */
	@Override
	public Industry getById(Integer industryId) {
		Industry industry = industryMapper.getById(industryId);
		Enterprise enterprise = enterpriseMapper.findById(Integer.parseInt(industry.getIndustryEnterpriseId()));
		if(enterprise !=null){
			industry.setEnterpriseName(enterprise.getEnterpriseName());
		}
		return industry;
	}

	/**
	 * 工业数据填报查询
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Override
	public IndustryData getIndustryData(Integer userId, String startTime, String endTime) {
		return industryDataMapper.getIndustryData(userId, startTime, endTime);
	}
}
