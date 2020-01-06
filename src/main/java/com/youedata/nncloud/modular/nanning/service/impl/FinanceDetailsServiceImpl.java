package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.FinanceDetailsMapper;
import com.youedata.nncloud.modular.nanning.dao.FinanceMapper;
import com.youedata.nncloud.modular.nanning.model.Finance;
import com.youedata.nncloud.modular.nanning.model.FinanceDetails;
import com.youedata.nncloud.modular.nanning.service.IFinanceDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 财务报表详情表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class FinanceDetailsServiceImpl extends ServiceImpl<BaseMapper<FinanceDetails>,FinanceDetails> implements IFinanceDetailsService {
	 @Resource
	 FinanceDetailsMapper financeDetailsMapper;
	 
	 @Resource
	 FinanceMapper financeMapper;
	
	@Override
	public Page getFinanceDetails(Integer financeDetailsFinanceId, String financeDetailsType, int size, int curPage) {
		 Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
		 List<FinanceDetails> result = financeDetailsMapper.getFinanceDetails(financeDetailsFinanceId, financeDetailsType, page);
		//查询工业中的年份进行处理
		 Finance finance = financeMapper.getById(financeDetailsFinanceId);
		 if(!StringUtils.isEmpty(String.valueOf(finance.getFinanceYear()))){
			int year = Integer.parseInt(String.valueOf(finance.getFinanceYear()).substring(0,4));
			String month = String.valueOf(finance.getFinanceYear()).substring(4,6);
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


	@Override
	public int add(FinanceDetails financeDetails) {
		int ret = financeDetailsMapper.add(financeDetails);
		return ret;
	}
}
