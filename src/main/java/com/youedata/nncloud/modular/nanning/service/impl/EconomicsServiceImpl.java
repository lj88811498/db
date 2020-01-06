package com.youedata.nncloud.modular.nanning.service.impl;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.District;
import com.youedata.nncloud.modular.nanning.model.Economics;
import com.youedata.nncloud.modular.nanning.model.IndustryInfo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IDistrictService;
import com.youedata.nncloud.modular.nanning.service.IEconomicsService;
import com.youedata.nncloud.modular.nanning.service.IIndustryInfoService;
import com.youedata.nncloud.modular.nanning.dao.EconomicsMapper;
/**
 * 工业经济运行动态表Service
 *
 * @author chenhui
 * @Date 2018-12-13 11:55:07
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class EconomicsServiceImpl extends ServiceImpl<BaseMapper<Economics>,Economics> implements IEconomicsService {
	@Resource
	EconomicsMapper EconomicsMapper;
	
	@Autowired
	private IEconomicsService economicsService;
	
    @Autowired
    private IDistrictService districtService;
    
    @Autowired
    private IIndustryInfoService industryInfoService;
	
	public static final SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM");
	
	public static final SimpleDateFormat sfm = new SimpleDateFormat("yyyy");
	
	public static final DecimalFormat df = new DecimalFormat("#.##");
	
	
	@Override
	public List<Economics> listEconomics(String economicsTime) {
		return EconomicsMapper.listEconomics(economicsTime);
	}


	@Override
	public Map countEconomics(String startTime, String endTime) {
		return EconomicsMapper.countEconomics(startTime, endTime);
	}


	@Override
	public Map countMonths(String economicsTime) {
		return EconomicsMapper.countMonths(economicsTime);
	}
	
	//统计全市工业经济运行动态(同比和环比计算)
	public Economics calculation(){
	   Calendar calendar  = Calendar.getInstance();
	   Calendar cal  = Calendar.getInstance();
	   Economics ec = new Economics();
		//声明主营业务收入参数
	   Double yearOnIncome = 0.00;
	   Double yearOnProfit =0.00;
		
		//声明利润参数
	   Double chainRatioProfit = 0.00;
	   Double chainRatioIncome = 0.00;
		//获取到当年的所有收入
    	Map economics = economicsService.countEconomics((sfm.format(calendar.getTime())+"-01"),sFormat.format(calendar.getTime()));
    	//获取到去年的所有收入
    	calendar.add(Calendar.YEAR, -1);
    	Map economics1 = economicsService.countEconomics((sfm.format(calendar.getTime())+"-01"),sFormat.format(calendar.getTime()));
    	if(economics !=null && economics1 !=null){
        	//同比率(主营业务收入)
        	if(!StringUtils.isEmpty(economics.get("economicsIncome").toString()) && !StringUtils.isEmpty(economics1.get("economicsIncome").toString())){
        		/*yearOnIncome = ((Double.parseDouble(economics.get("economicsIncome").toString()) - Double.parseDouble(economics1.get("economicsIncome").toString()) ) / Double.parseDouble(economics1.get("economicsIncome").toString())) * 100;*/
        		yearOnIncome = EconomicsServiceImpl.yearOnFormula(Double.parseDouble(economics.get("economicsIncome").toString()), Double.parseDouble(economics1.get("economicsIncome").toString()));
        	}
        	
        	//同比率(利润)
        	if(!StringUtils.isEmpty(economics.get("economicsProfit").toString()) && !StringUtils.isEmpty(economics1.get("economicsProfit").toString())){
        		/*yearOnProfit = ((Double.parseDouble(economics.get("economicsProfit").toString()) - Double.parseDouble(economics1.get("economicsProfit").toString()) ) / Double.parseDouble(economics1.get("economicsProfit").toString())) * 100;*/
        		yearOnProfit = EconomicsServiceImpl.yearOnFormula(Double.parseDouble(economics.get("economicsProfit").toString()), Double.parseDouble(economics1.get("economicsProfit").toString()));
        	}
    	}
    	
    	//获取当月的所有的收入
    	Map map = economicsService.countMonths(sFormat.format(cal.getTime()));
    	//获取上个月的收入
    	cal.add(Calendar.MONTH, -1);
    	Map map1 = economicsService.countMonths(sFormat.format(cal.getTime()));
    	if(map !=null && map1 !=null){
        	//环比率(收入)
        	if(!StringUtils.isEmpty(map.get("economicsIncome").toString()) && !StringUtils.isEmpty(map1.get("economicsIncome").toString())){
        		/*chainRatioProfit = ((Double.parseDouble(map.get("economicsIncome").toString()) - Double.parseDouble(map1.get("economicsIncome").toString()) ) / Double.parseDouble(map1.get("economicsIncome").toString())) * 100;*/
        		chainRatioProfit = EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(map.get("economicsIncome").toString()), Double.parseDouble(map1.get("economicsIncome").toString()));
        	}
        	//环比率(利润)
        	if(!StringUtils.isEmpty(map.get("economicsProfit").toString()) && !StringUtils.isEmpty(map1.get("economicsProfit").toString())){
        		/*chainRatioIncome = ((Double.parseDouble(map.get("economicsProfit").toString()) - Double.parseDouble(map1.get("economicsProfit").toString()) ) / Double.parseDouble(map1.get("economicsProfit").toString())) * 100;*/
        		chainRatioIncome = EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(map.get("economicsProfit").toString()), Double.parseDouble(map1.get("economicsProfit").toString()));
        	}
    	}
		ec.setYearOnIncome(df.format(yearOnIncome));
		ec.setYearOnProfit(df.format(yearOnProfit));
		ec.setChainRatioIncome(df.format(chainRatioIncome));
		ec.setChainRatioProfit(df.format(chainRatioProfit));
		ec.setEconomicsIncome(Double.parseDouble(economics.get("economicsIncome").toString()));
		ec.setEconomicsProfit(Double.parseDouble(economics.get("economicsProfit").toString()));
		return ec;
		
	}
	
	//同比方法Math.abs()
	public static Double yearOnFormula(Double calculation, Double calculation1){
		Double yearOn = ((calculation - calculation1) / Math.abs(calculation1))  * 100;
		return yearOn;
	}
	
	//环比比方法
	public static Double chainRatioFormula(Double calculation, Double calculation1){
		Double chainRatio = ((calculation - calculation1) / calculation1)  * 100;
		return chainRatio;
	}


	@Override
	public Map countDistrictId(int economicsDistrictId, String startTime, String endTime) {
		return EconomicsMapper.countDistrictId(economicsDistrictId, startTime, endTime);
	}


	@Override
	public Map<String, Object> areaCalculation(String economicsTime) {
		Calendar calendar  = Calendar.getInstance();
		Calendar cal  = Calendar.getInstance();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> economicsIncome = new HashMap<String, Object>();
		Map<String, Object> economicsIncome1 = new HashMap<String, Object>();
		
		Map<String, Object> chainRatioProfit = new HashMap<String, Object>();
		Map<String, Object> chainRatioIncome = new HashMap<String, Object>();
		//获取所有区县信息
		List<District> list = districtService.listDistrict();
		for (District district : list) {
			//同比
			if(!StringUtils.isEmpty(economicsTime)){
				try {
					//将时间转为时间戳
					Long pastTime = sFormat.parse(economicsTime).getTime();
					economicsIncome = economicsService.countDistrictId(district.getDistrictId(),(sfm.format(pastTime)+"-01"),sFormat.format(pastTime));
					//减去一年的时间戳
					DateTime dateTime = new DateTime(pastTime);
				    economicsIncome1 = economicsService.countDistrictId(district.getDistrictId(),(sfm.format(dateTime.plusYears(-1).toDate())+"-01"),sFormat.format(dateTime.plusYears(-1).toDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				 economicsIncome = economicsService.countDistrictId(district.getDistrictId(), (sfm.format(calendar.getTime())+"-01"), sFormat.format(calendar.getTime()));
				/* calendar.add(Calendar.YEAR, -1);*/
				 DateTime dateTime = new DateTime(calendar);
				 economicsIncome1 = economicsService.countDistrictId(district.getDistrictId(), (sfm.format(dateTime.plusYears(-1).toDate())+"-01"), sFormat.format(dateTime.plusYears(-1).toDate()));
			}
			//环比
			if(!StringUtils.isEmpty(economicsTime)){
				try {
					//将时间转为时间戳
					Long pastTime = sFormat.parse(economicsTime).getTime();
					chainRatioProfit = economicsService.countDistrictMonths(district.getDistrictId(), sFormat.format(pastTime));
					//减去一月的时间戳
					DateTime dateTime = new DateTime(pastTime);
				    chainRatioIncome = economicsService.countDistrictMonths(district.getDistrictId(), sFormat.format(dateTime.plusMonths(-1).toDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}else{
				chainRatioProfit = economicsService.countDistrictMonths(district.getDistrictId(), sFormat.format(cal.getTime()));
				/*cal.add(Calendar.MONTH, -1);*/
				DateTime dateTime = new DateTime(cal);
				chainRatioIncome = economicsService.countDistrictMonths(district.getDistrictId(), sFormat.format(dateTime.plusMonths(-1).toDate()));
				
			}
			
			
			Economics economics = new Economics();
			if (economicsIncome != null) {
				economics.setDistrictName(district.getDistrictName());
				economics.setEconomicsIncome(Double.parseDouble(economicsIncome.get("economicsIncome").toString()));
				economics.setEconomicsProfit(Double.parseDouble(economicsIncome.get("economicsProfit").toString()));
				if(economicsIncome1 != null){
					economics.setYearOnIncome(df.format(EconomicsServiceImpl.yearOnFormula(Double.parseDouble(economicsIncome.get("economicsIncome").toString()), Double.parseDouble(economicsIncome1.get("economicsIncome").toString()))));
					economics.setYearOnProfit(df.format(EconomicsServiceImpl.yearOnFormula(Double.parseDouble(economicsIncome.get("economicsProfit").toString()), Double.parseDouble(economicsIncome1.get("economicsProfit").toString()))));
				}
			}
			if(chainRatioProfit !=null && chainRatioIncome !=null){
				economics.setChainRatioIncome(df.format(EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(chainRatioProfit.get("economicsIncome").toString()), Double.parseDouble(chainRatioIncome.get("economicsIncome").toString()))));
				economics.setChainRatioProfit(df.format(EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(chainRatioProfit.get("economicsProfit").toString()), Double.parseDouble(chainRatioIncome.get("economicsProfit").toString()))));
			}
			result.put(district.getDistrictName(), economics);
		}
		return result;
		
	}


	@Override
	public Map countDistrictMonths(int economicsDistrictId, String economicsTime) {
		return EconomicsMapper.countDistrictMonths(economicsDistrictId, economicsTime);
	}


	@Override
	public Map economicsIndustryId(String economicsIndustryId, String startTime, String endTime) {
		return EconomicsMapper.economicsIndustryId(economicsIndustryId, startTime, endTime);
	}


	@Override
	public Economics industryDetails(String industryId, String economicsTime) {
		Calendar calendar  = Calendar.getInstance();
		Calendar cal  = Calendar.getInstance();
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		Map<String, Object> smap = new HashMap<String, Object>();
		Map<String, Object> smap1 = new HashMap<String, Object>();
		//同比
		if(!StringUtils.isEmpty(economicsTime)){
			try {
				//将时间转为时间戳
				Long pastTime = sFormat.parse(economicsTime).getTime();
			    map = economicsService.economicsIndustryId(industryId,(sfm.format(pastTime)+"-01"), sFormat.format(pastTime));
				//减去一年的时间戳 
			    DateTime dateTime = new DateTime(pastTime);
			    map1 = economicsService.economicsIndustryId(industryId, (sfm.format(dateTime.plusYears(-1).toDate())+"-01"), sFormat.format(dateTime.plusYears(-1).toDate()));
			    
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}else{
			 map = economicsService.economicsIndustryId(industryId,(sfm.format(calendar.getTime())+"-01"), sFormat.format(calendar.getTime()));
			 calendar.add(Calendar.YEAR, -1);
			 map1 = economicsService.economicsIndustryId(industryId, (sfm.format(calendar.getTime())+"-01"), sFormat.format(calendar.getTime()));
		}
		
		//环比
		if(!StringUtils.isEmpty(economicsTime)){
			try {
				//将时间转为时间戳
				Long pastTime1 = sFormat.parse(economicsTime).getTime();
				smap = economicsService.economicsIndustryId(industryId,(sfm.format(pastTime1)+"-01"), sFormat.format(pastTime1));
				//减去一月的时间戳
				DateTime dateTime = new DateTime(pastTime1);
			    smap1 = economicsService.economicsIndustryId(industryId, (sfm.format(dateTime.plusMonths(-1).toDate())+"-01"), sFormat.format(dateTime.plusMonths(-1).toDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}else{
			 smap = economicsService.economicsIndustryId(industryId,(sfm.format(cal.getTime())+"-01"), sFormat.format(cal.getTime()));
			 cal.add(Calendar.MONTH, -1);
			 smap1 = economicsService.economicsIndustryId(industryId, (sfm.format(cal.getTime())+"-01"), sFormat.format(cal.getTime()));
		}
		
		Economics economics = new Economics();
		if(map !=null){
			economics.setEconomicsIncome(Double.parseDouble(map.get("economicsIncome").toString()));
			economics.setEconomicsProfit(Double.parseDouble(map.get("economicsProfit").toString()));
			if(map1 != null){
				economics.setYearOnIncome(df.format(EconomicsServiceImpl.yearOnFormula(Double.parseDouble(map.get("economicsIncome").toString()), Double.parseDouble(map1.get("economicsIncome").toString()))));
				economics.setYearOnProfit(df.format(EconomicsServiceImpl.yearOnFormula(Double.parseDouble(map.get("economicsProfit").toString()), Double.parseDouble(map1.get("economicsProfit").toString()))));
			}
		}
		
		if(smap !=null && smap1 !=null){
			economics.setChainRatioIncome(df.format(EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(smap.get("economicsIncome").toString()), Double.parseDouble(smap1.get("economicsIncome").toString()))));
			economics.setChainRatioProfit(df.format(EconomicsServiceImpl.chainRatioFormula(Double.parseDouble(smap.get("economicsProfit").toString()), Double.parseDouble(smap1.get("economicsProfit").toString()))));
		}
		return economics;
	}


	@Override
	public Map<String, Object> industrySector(String economicsTime) {
		Map<String, Object> result = new HashMap<String, Object>();
		Calendar calendar  = Calendar.getInstance();
		Map<String, Object> map = new HashMap<String, Object>();
		List<IndustryInfo> list = industryInfoService.list();
		//循环所有行业
		for (IndustryInfo industry : list) {
			//同比
			if(!StringUtils.isEmpty(economicsTime)){
				try {
					//将时间转为时间戳
					Long pastTime = sFormat.parse(economicsTime).getTime();
				    map = economicsService.economicsIndustryId(String.valueOf(industry.getIndustryInfoId()),(sfm.format(pastTime)+"-01"), sFormat.format(pastTime));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				 map = economicsService.economicsIndustryId(String.valueOf(industry.getIndustryInfoId()),(sfm.format(calendar.getTime())+"-01"), sFormat.format(calendar.getTime()));
			}
			Economics economics = new Economics();
			if(map !=null){
				economics.setEconomicsIncome(Double.parseDouble(map.get("economicsIncome").toString()));
				result.put(industry.getIndustryInfoName(), map.get("economicsIncome"));
			}
		}
		return result;
	}
	
	
}
