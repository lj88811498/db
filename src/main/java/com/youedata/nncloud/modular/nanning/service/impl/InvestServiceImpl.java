package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.InvestMapper;
import com.youedata.nncloud.modular.nanning.model.Invest;
import com.youedata.nncloud.modular.nanning.model.vo.InvestVo;

import java.text.DecimalFormat;
import java.util.*;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IInvestService;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;


/**
 * pro投融资项目余额表Service
 *
 * @author fxh
 * @Date 2018-12-25 10:32:44
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class InvestServiceImpl extends ServiceImpl<BaseMapper<Invest>,Invest> implements IInvestService {

	 public static final SimpleDateFormat sdf = new SimpleDateFormat("MM");

	 public static final  SimpleDateFormat sFormat = new SimpleDateFormat("yyyy");

	 public static final DecimalFormat df = new DecimalFormat("#.##");

    @Resource
    InvestMapper investMapper;

    /*-------------------------chenhui--------------------------------*/
    @Override
    public List<Invest> list() {
        return investMapper.list();
    }

    @Override
    public List<Invest> guaranteeMode(String startTime, String endTime) {
        return investMapper.guaranteeMode(startTime, endTime);
    }

    @Override
	public int countRating(String startTime, String endTime,String investCreditRating) {
		return investMapper.countRating(startTime, endTime, investCreditRating);
	}

    @Override
	public int countAssessed(String startTime, String endTime, String investCreditRating) {
		return investMapper.countAssessed(startTime, endTime, investCreditRating);
	}

    @Override
	public Map<String, Object> ratingTotal(String year, String quarter) {
    	 Map<String, Object> result = new HashMap<String, Object>();
    	 InvestVo investVo = new InvestVo();
    	 int countRating = 0;
   	     int countAssessed = 0;
   	     int gradeTotal = 0;
   	     List<Invest> list = null;
   	     InvestVo iVo = null;
   	     List<InvestVo> gradeList = new ArrayList<>();
	   	 //校验参数是否为空
	   	 if(StringUtils.isEmpty(year)){
	   		 year = sFormat.format(new Date());
	   	 }
	   	 if(StringUtils.isEmpty(quarter)){
	   		 //通过计算等式获取某个季度
	   		 quarter = String.valueOf((Integer.parseInt(sdf.format(new Date())) + 2 )/3);
	   	 }
	   	 //获取某个季度未评定的总数
	   	 if(Integer.parseInt(quarter) == 1){
			countRating = investMapper.countRating(year + "01", year + "03", "未评定");
		 }else if(Integer.parseInt(quarter) == 2){
			countRating = investMapper.countRating(year + "04", year + "06", "未评定");
		 }else if(Integer.parseInt(quarter) == 3){
			countRating = investMapper.countRating(year + "07", year + "09", "未评定");
		 }else{
			countRating = investMapper.countRating(year + "10", year + "12", "未评定");
		 }
	   	 
	   	 //获取某个季度已评定的总数
	   	 if(Integer.parseInt(quarter) == 1){
	   		countAssessed = investMapper.countAssessed(year + "01", year + "03", "未评定");
	   		//获取已评定的等级
	   		list = investMapper.grade(year + "01", year + "03", "未评定");
	   		//进行对对应的等级统计
	   		for (Invest invest : list) {
	   			iVo = new InvestVo();
	   			gradeTotal = investMapper.countRating(year + "01", year + "03", invest.getInvestCreditRating());
	   			iVo.setLevel(invest.getInvestCreditRating());
	   			iVo.setCountAssessed(gradeTotal);
	   			iVo.setProportion(df.format(Double.parseDouble(String.valueOf(gradeTotal))/Double.parseDouble(String.valueOf(countAssessed))*100)+"%");
	   			gradeList.add(iVo);
			}
		 }else if(Integer.parseInt(quarter) == 2){
			 countAssessed = investMapper.countAssessed(year + "04", year + "06", "未评定");
			//获取已评定的等级
			 list = investMapper.grade(year + "04", year + "06", "未评定");
			//进行对对应的等级统计
			 for (Invest invest : list) {
				 	iVo = new InvestVo();
		   			gradeTotal = investMapper.countRating(year + "04", year + "06", invest.getInvestCreditRating());
		   			iVo.setLevel(invest.getInvestCreditRating());
		   			iVo.setCountAssessed(gradeTotal);
		   			iVo.setProportion(df.format(Double.parseDouble(String.valueOf(gradeTotal))/Double.parseDouble(String.valueOf(countAssessed))*100)+"%");
		   			gradeList.add(iVo);
			 }
		 }else if(Integer.parseInt(quarter) == 3){
			 countAssessed = investMapper.countAssessed(year + "07", year + "09", "未评定");
			 list = investMapper.grade(year + "07", year + "09", "未评定");
			//进行对对应的等级统计
			 for (Invest invest : list) {
				 	iVo = new InvestVo();
		   			gradeTotal = investMapper.countRating(year + "07", year + "09", invest.getInvestCreditRating());
		   			iVo.setLevel(invest.getInvestCreditRating());
		   			iVo.setCountAssessed(gradeTotal);
		   			iVo.setProportion(df.format(Double.parseDouble(String.valueOf(gradeTotal))/Double.parseDouble(String.valueOf(countAssessed))*100)+"%");
		   			gradeList.add(iVo);
			 }
		 }else{
			 countAssessed = investMapper.countAssessed(year + "10", year + "12", "未评定");
			 list = investMapper.grade(year + "10", year + "12", "未评定");
			 //进行对对应的等级统计
			 for (Invest invest : list) {
				 	iVo = new InvestVo();
		   			gradeTotal = investMapper.countRating(year + "10", year + "12", invest.getInvestCreditRating());
		   			iVo.setLevel(invest.getInvestCreditRating());
		   			iVo.setCountAssessed(gradeTotal);
		   			iVo.setProportion(df.format(Double.parseDouble(String.valueOf(gradeTotal))/Double.parseDouble(String.valueOf(countAssessed))*100)+"%");
		   			gradeList.add(iVo);
			 }
		 }
	   	 if(countAssessed !=0 ){
	   		investVo.setCountAssessed(countAssessed);
	   	 }
	   	 if(countRating !=0 ){
	   		investVo.setCountRating(countRating);
		   	investVo.setProportion(df.format((Double.parseDouble(String.valueOf(countAssessed))/(Double.parseDouble(String.valueOf(countAssessed))+Double.parseDouble(String.valueOf(countRating))) * 100))+"%");
	   	 }
	   	result.put("invest", investVo);
	   	result.put("gradeList", gradeList);
	   	return result;
	}

    @Override
	public Map<String, Object> modeDetails(String year, String quarter) {
    	 Map<String, Object> result = new HashMap<String, Object>();
	     List<Invest> modes = null;
	     InvestVo iVo = null;
	     List<InvestVo> list = new ArrayList<>();
	     //校验参数是否为空
	   	 if(StringUtils.isEmpty(year)){
	   		 year = sFormat.format(new Date());
	   	 }
	   	 if(StringUtils.isEmpty(quarter)){
	   		 //通过计算等式获取某个季度
	   		 quarter = String.valueOf((Integer.parseInt(sdf.format(new Date())) + 2 )/3);
	   	 }
	     //获取某个季度中担保方式
	   	 if(Integer.parseInt(quarter) == 1){
	   		modes = investMapper.guaranteeMode(year + "01", year + "03");
	   		//循环担保方式里的方式查询对应的信息
	   		for (Invest invest : modes) {
	   			Map map = investMapper.modeDeatils(year + "01", year + "03", invest.getInvestGuaranteeMethod());
	   			iVo = new InvestVo();
	   			iVo.setProjectToltal(Integer.parseInt(map.get("projectName").toString()));
	   			iVo.setAmount(Double.parseDouble(map.get("amount").toString())/10000);
	   			list.add(iVo);
			}

		 }else if(Integer.parseInt(quarter) == 2){
			 modes = investMapper.guaranteeMode(year + "04", year + "06");
		 	 //循环担保方式里的方式查询对应的信息
			 for (Invest invest : modes) {
		   			Map map = investMapper.modeDeatils(year + "01", year + "03", invest.getInvestGuaranteeMethod());
		   			iVo = new InvestVo();
		   			iVo.setProjectToltal(Integer.parseInt(map.get("projectName").toString()));
		   			iVo.setAmount(Double.parseDouble(map.get("amount").toString())/10000);
		   			list.add(iVo);
			 }
		 }else if(Integer.parseInt(quarter) == 3){
			 modes = investMapper.guaranteeMode(year + "07", year + "09");
		 	//循环担保方式里的方式查询对应的信息
			 for (Invest invest : modes) {
		   			Map map = investMapper.modeDeatils(year + "01", year + "03", invest.getInvestGuaranteeMethod());
		   			iVo = new InvestVo();
		   			iVo.setProjectToltal(Integer.parseInt(map.get("projectName").toString()));
		   			iVo.setAmount(Double.parseDouble(map.get("amount").toString())/10000);
		   			list.add(iVo);
				}
		 }else{
			 modes = investMapper.guaranteeMode(year + "10", year + "12");
			 //循环担保方式里的方式查询对应的信息
			 for (Invest invest : modes) {
	   			Map map = investMapper.modeDeatils(year + "01", year + "03", invest.getInvestGuaranteeMethod());
	   			iVo = new InvestVo();
	   			iVo.setProjectToltal(Integer.parseInt(map.get("projectName").toString()));
	   			iVo.setAmount(Double.parseDouble(map.get("amount").toString())/10000);
	   			list.add(iVo);
			}
		 }
	   	 //获取所有担保方式
	   	 result.put("modes", modes);
	   	 result.put("list", list);
	   	 return result;
	}

    @Override
	public InvestVo balance() {
    	Map map = investMapper.balance();
    	InvestVo investVo = new InvestVo();
    	investVo.setAccumulate(Double.parseDouble(map.get("accumulate").toString()));
    	investVo.setBankBalance(Double.parseDouble(map.get("bankBalance").toString()));
    	investVo.setMatchBalance(Double.parseDouble(map.get("matchBalance").toString()));
    	investVo.setProportion(df.format(Double.parseDouble(map.get("matchBalance").toString())/Double.parseDouble(map.get("accumulate").toString())*100)+"%");
    	investVo.setBankproportion(df.format(Double.parseDouble(map.get("bankBalance").toString())/Double.parseDouble(map.get("accumulate").toString())*100)+"%");
		return investVo;
	}
    
    @Override
	public Map<String, Object> itemNumber() {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		//获取五级分类
		List<Invest> classification = investMapper.classification();
		result.put("classification", classification);
		Calendar cal = Calendar.getInstance();
		//当年信息
   	  	int year = cal.get(Calendar.YEAR);
		for (Invest invest : classification) {
    		  int count = investMapper.classificationTotal(String.valueOf(year), invest.getInvestFiveClass());
    		  map.put(invest.getInvestFiveClass(), count);
		}
		result.put(String.valueOf(year), map);
		
		//当年信息减1
		for (Invest invest : classification) {
    		  int count = investMapper.classificationTotal(String.valueOf(year-1), invest.getInvestFiveClass());
    		  map1.put(invest.getInvestFiveClass(), count);
		}
		result.put(String.valueOf(year-1), map1);
		
		//当年信息减2
		for (Invest invest : classification) {
    		  int count = investMapper.classificationTotal(String.valueOf(year-2), invest.getInvestFiveClass());
    		  map2.put(invest.getInvestFiveClass(), count);
		}
		result.put(String.valueOf(year-2), map2);
		
		//当年信息减3
		for (Invest invest : classification) {
    		  int count = investMapper.classificationTotal(String.valueOf(year-3), invest.getInvestFiveClass());
    		  map3.put(invest.getInvestFiveClass(), count);
		}
		result.put(String.valueOf(year-3), map3);
		return result;
	}

    @Override
	public Page listProject(int size, int curPage) {
    	Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
    	List result = investMapper.listProject(page);
    	page.setRecords(result);
		return page;
	}

    @Override
	public Map<String, Object> interest(String year, String quarter) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	List<InvestVo> inVos = new ArrayList<>();
    	InvestVo inVo = null;
    	//校验参数是否为空
	   	if(StringUtils.isEmpty(year)){
	   		 year = sFormat.format(new Date());
	   	}
	   	if(StringUtils.isEmpty(quarter)){
	   		//通过计算等式获取某个季度
	   		 quarter = String.valueOf((Integer.parseInt(sdf.format(new Date())) + 2 )/3);
	   	}
    	//通过年份和季度查询最高利率
    	List<InvestVo> list = investMapper.interest(year, quarter);
    	if(list.size() >0){
    		for (InvestVo investVo : list) {
    			//通过id查询信息
				Invest invest = investMapper.getById(Integer.parseInt(investVo.getInterestRateId()));
				inVo = new InvestVo();
				inVo.setInvestSelfLoanAmount(invest.getInvestSelfLoanAmount());//放款额-平台银行自营
				inVo.setInvestMatchLoanAmount(invest.getInvestMatchLoanAmount());//放款额-平台配套
				inVo.setInterestRate(investVo.getInterestRate());//最高利率
				inVos.add(inVo);
			}
    		result.put("list", inVos);
    	}
		return result;
	}

    @Override
	public Map<String, Object> getBankDataId(Integer investBankDataId) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	InvestVo investVo = null;
    	List<InvestVo> list = new ArrayList<>();
    	List<Invest> invest = investMapper.getBankDataId(investBankDataId);
    	if(invest.size() > 0){
    		for (Invest inv : invest) {
    			investVo = new InvestVo();
    			investVo.setLevel(inv.getInvestFiveClass());//等级
        		investVo.setInvestCreditAmount(inv.getInvestCreditAmount());
        		investVo.setProjectName(inv.getInvestProjectName());
        		list.add(investVo);
			}
    		result.put("list", list);
    	}
		return result;
	}


    @Override
	public void saveExpiryDate() {
    	investMapper.saveSelfExpiryDate();
    	investMapper.saveMatchExpiryDate();
	}

    @Override
	public void removeExpiryDate() {
    	investMapper.removeExpiryDate();
	}

    @Override
	public void saveInterestRate() {
    	investMapper.saveMatchInterestRate();
    	investMapper.saveSelfInterestRate();
	}

	@Override
	public void removeInterestRate() {
		investMapper.removeInterestRate();
	}
	
	@Override
	public List<Invest> findBankDataId(Integer investBankDataId) {
		return investMapper.getBankDataId(investBankDataId);
	}

    /*-------------------------xiaohong--------------------------------*/



    /***
     * @Description: 百分比计算
     * @return:
     * @Author: fxh
     * @Date: 2018/12/27
     **/
    public String percent(double a, double b) {
        String ret = "";// 接受百分比的值
        if (ObjectUtils.isEmpty(b)){
            return ret;
        }
        if (ObjectUtils.isEmpty(a)){
            return "0";
        }
        double per = a / b;
        // 百分比格式，后面不足2位的用0补齐
        DecimalFormat df1 = new DecimalFormat("##.00%");
        ret = df1.format(per);
        return ret;
    }


    /***
     * @Description: 同比百分比计算
     * @return:
     * @Author: fxh
     * @Date: 2018/12/27
     **/
    public String yearPercent(double a, double b) {
        String ret = "";// 接受百分比的值
        if (ObjectUtils.isEmpty(b)){
            return ret;
        }
        if (ObjectUtils.isEmpty(a)){
            return "0";
        }
        double per = ( a - b ) / b;
        // 百分比格式，后面不足2位的用0补齐
        DecimalFormat df1 = new DecimalFormat("##.00%");
        ret = df1.format(per);
        return ret;
    }


    /***
     * @Description: 计算过去6个月的同比数据
     * @return:
     * @Author: fxh
     * @Date: 2018/12/27
     **/
    public List<Map<String,String>> calListPercent(List<Map<String,String>> thisYearList, List<Map<String,String>> lastYearList) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMM");

        //将数据放到同一个map里，方便同比计算拿值
        List<Map<String,String>> retList = new ArrayList<>();
        Map<String,String> allMap = new HashMap();
        String yearMonth;
        String counts;

        for (int i = 0; i < thisYearList.size(); i++){
            yearMonth = String.valueOf(thisYearList.get(i).get("yearmonth"));
            counts = String.valueOf(thisYearList.get(i).get("counts"));
            allMap.put(yearMonth,counts);
        }
        for (int i = 0; i < lastYearList.size(); i++){
            yearMonth = String.valueOf(lastYearList.get(i).get("yearmonth"));
            counts = String.valueOf(lastYearList.get(i).get("counts"));
            allMap.put(yearMonth,counts);
        }

        //计算同比,并拼凑数据返回
        String thisYear;
        String lastYear;
        String per;
        Map retMap;
        Calendar thisCal = Calendar.getInstance(); //今年
        Calendar lastCal = Calendar.getInstance(); //去年
        lastCal.add(Calendar.YEAR, -1);
        for (int i = 0; i < 6; i++){
            retMap = new HashMap();
            if(i != 0) {
                thisCal.add(Calendar.MONTH, -1);
                lastCal.add(Calendar.MONTH, -1);
            }
            thisYear = ft.format(thisCal.getTime());
            lastYear = ft.format(lastCal.getTime());

            retMap.put("yearmonth", thisYear);
            //今年月份无数据
            if(!allMap.containsKey(thisYear)){
                retMap.put("counts","");
                retMap.put("per","");
            }
            //去年月份无数据，则不用计算同比
            else if(!allMap.containsKey(lastYear)){
                retMap.put("counts",allMap.get(thisYear));
                retMap.put("per","");
            }
            else{
                String thisCount =  allMap.get(thisYear);
                String lastCount = allMap.get(lastYear);
                per = yearPercent(Double.parseDouble(thisCount),Double.parseDouble(lastCount));
                retMap.put("counts",allMap.get(thisYear));
                retMap.put("per",per);
            }
            retList.add(retMap);
        }
        return retList;
    }


    /***
     * @Description:  拆分字段到新表：放款日(平台银行自营、平台配套)
     * @return:
     * @Author: fxh
     * @Date: 2018/12/26
     **/
    @Override
    public void disInvestLoanDay() {
        investMapper.disInvestSelfLoanDay();
        investMapper.disInvestMatchLoanDay();
    }



    /***
     * @Description:  拆分字段到新表：经办银行
     * @return:
     * @Author: fxh
     * @Date: 2018/12/29
     **/
    @Override
    public void managingBankDis() {
        investMapper.managingBankDis();
        investMapper.bankData();

    }

    /***
     * @Description: 累计帮助企业数:  根据《pro投融资项目余额表》-企业名称字段，统计企业数量；
     * @return:
     * @Author: fxh
     * @Date: 2018/12/26
     **/
    @Override
    public String getAllCompanyCount() {
        return investMapper.getAllCompanyCount();
    }


    /***
     * @Description: 当前借贷企业数：
     * 取《pro投融资项目余额表》-平台银行自营部分-到期日，以及《pro投融资项目余额表》-平台配套部分-到期日，
     * 获得这两个字段中的所有时间点，若这些时间点至少有一个在当前时间点之后，则该项目对应的企业，算作当前借贷企业，当前借贷企业数+1
     * @return:
     * @Author: fxh
     * @Date: 2018/12/26
     **/
    @Override
    public String getCurrentBorrowCompCount() {
        return investMapper.getCurrentBorrowCompCount();
    }


    /***
     * @Description: 融资项目
     * 横坐标：最近6个月
     * 纵坐标：左侧，项目个数；右侧，同比比值
     * 柱状图：项目个数，取《pro投融资项目余额表》-平台银行自营部分-放款日，以及《pro投融资项目余额表》-平台配套部分-放款日，
     * 获得这两个字段中的所有时间点，取这些时间点中较早的时间，根据其所在年月，对应年月的项目数+1
     * @return:
     * @Author: fxh
     * @Date: 2018/12/27
     **/
    @Override
    public List financingProject() {

        //获取最近6个月时间组成数组，时间格式201810
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMM");
        String startYearMonth;
        String endYearMonth;

        //今年6个月数据
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal.getTime());
        endYearMonth = ft.format(new Date());
        List<Map<String,String>> ret = investMapper.financingProject(startYearMonth,endYearMonth);


        //去年6个月数据
        Calendar cal2 = Calendar.getInstance();//获取当前日期
        cal2.add(Calendar.YEAR, -1);
        endYearMonth = ft.format(cal2.getTime());
        cal2.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal2.getTime());
        List<Map<String,String>> retLast = investMapper.financingProject(startYearMonth,endYearMonth);

        //调用工具计算同比，并形成返回数据
        List<Map<String,String>> retList = calListPercent(ret,retLast);

        return retList;
    }



    /***
     * @Description: 借贷企业
     * 横坐标：最近6个月
     * 纵坐标：左侧，企业个数；右侧，同比比值
     * 柱状图：企业个数，取《pro投融资项目余额表》-平台银行自营部分-放款日，以及《pro投融资项目余额表》-平台配套部分-放款日，
     * 获得这两个字段中的所有时间点，取这些时间点中较早的时间，根据其所在年月，对应年月的企业数+1
     * @return:
     * @Author: fxh
     * @Date: 2018/12/27
     **/
    @Override
    public List lendingCompany() {
        //获取最近6个月时间组成数组，时间格式201810
        SimpleDateFormat ft = new SimpleDateFormat("YYYYMM");
        String startYearMonth;
        String endYearMonth;

        //今年6个月数据
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal.getTime());
        endYearMonth = ft.format(new Date());
        List<Map<String,String>> ret = investMapper.lendingCompany(startYearMonth,endYearMonth);


        //去年6个月数据
        Calendar cal2 = Calendar.getInstance();//获取当前日期
        cal2.add(Calendar.YEAR, -1);
        endYearMonth = ft.format(cal2.getTime());
        cal2.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal2.getTime());
        List<Map<String,String>> retLast = investMapper.lendingCompany(startYearMonth,endYearMonth);

        //调用工具计算同比，并形成返回数据
        List<Map<String,String>> retList = calListPercent(ret,retLast);

        return retList;
    }



    /***
     * @Description:  放款合同
     * @return:
     * @Author: fxh
     * @Date: 2018/12/28
     **/
    @Override
    public List loanContract() {
        //获取最近6个月时间组成数组，时间格式201810
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMM");
        String startYearMonth;
        String endYearMonth;

        //今年6个月数据
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal.getTime());
        endYearMonth = ft.format(new Date());
        List<Map<String,String>> ret = investMapper.loanContract(startYearMonth,endYearMonth);


        //去年6个月数据
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.YEAR, -1);
        endYearMonth = ft.format(cal2.getTime());
        cal2.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal2.getTime());
        List<Map<String,String>> retLast = investMapper.loanContract(startYearMonth,endYearMonth);

        //调用工具计算同比，并形成返回数据
        List<Map<String,String>> retList = calListPercent(ret,retLast);

        return retList;
    }

	

    /***
     * @Description:  项目金额分布
     * @return:
     * @Author: fxh
     * @Date: 2018/12/28
     **/
    @Override
    public List projectMoneyDistri() {
        List retList = new ArrayList();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy");

        Calendar cal= Calendar.getInstance();
        String year;
        Map map;
        List<Map<String,String>> ret;
        for (int i = 0 ;i < 5 ;i++){
            map = new HashMap();
            if(i > 0){
                cal.add(Calendar.YEAR,-i);
            }
            year = ft.format(cal.getTime());
            ret = investMapper.projectMoneyDistri(year);
            map.put("year",year);
            map.put("children",ret);
            retList.add(map);
        }
        return retList;
    }


    /***
     * @Description: 授信金额
     * @return:
     * @Author: fxh
     * @Date: 2018/12/28
     **/
    @Override
    public Map creditMoney() {
        Map ret = new HashMap();
        String creditMoney = investMapper.creditMoney();
        String bankLending = investMapper.bankLending();
        String centralLending = investMapper.centralLending();
        String bankPercent = percent(Double.parseDouble(bankLending),Double.parseDouble(creditMoney));
        String centralPercent = percent(Double.parseDouble(centralLending),Double.parseDouble(creditMoney));
        ret.put("creditMoney",creditMoney);
        ret.put("bankLending",bankLending);
        ret.put("centralLending",centralLending);
        ret.put("bankPercent",bankPercent);
        ret.put("centralPercent",centralPercent);
        return ret;
    }


    /***
     * @Description:  资金流向
     * @return:
     * @Author: fxh
     * @Date: 2018/12/29
     **/
    @Override
    public List moneyFlow() {
        return investMapper.moneyFlow();
    }


    /***
     * @Description: 投融资性质及金额变化
     * @return:
     * @Author: fxh
     * @Date: 2018/12/29
     **/
    @Override
    public List natureAndMoneyChange() {
/*
        String startYearMonth;
        String endYearMonth;

        //今年6个月数据
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.MONTH, -5);
        startYearMonth = ft.format(cal.getTime());
        endYearMonth = ft.format(new Date());
		return investMapper.natureAndMoneyChange(startYearMonth,endYearMonth);
*/


		List<Map<String,String>> natureList = investMapper.getNature();
		if(ObjectUtils.isEmpty(natureList)){
			return null;
		}


        Map<String,String> map;
        List<Map<String,String>> retList = new ArrayList();

		SimpleDateFormat ft = new SimpleDateFormat("yyyyMM");
		Calendar cal = Calendar.getInstance();//获取当前日期
        for(int i=0;i<6;i++){
        	if(i != 0 ){
				cal.add(Calendar.MONTH, -1);
			}
			String time = ft.format(cal.getTime());

        	for( int j=0; j<natureList.size(); j++){
				map = new HashMap();
				String nature = natureList.get(j).get("nature");
        		String amount = investMapper.getByNatureAndTime(nature,time);
        		if(StringUtils.isEmpty(amount)){
        			amount = "0";
				}
        		map.put("nature",nature);
        		map.put("time",time);
        		map.put("amount",amount);
				retList.add(map);
			}
		}
		return retList;
    }



    /***
     * @Description:  经办银行基础数据
     * @return:
     * @Author: fxh
     * @Date: 2018/12/29
     **/
    @Override
    public List bankData() {
        return investMapper.bankData();
    }

    /***
     * @Description:  金融机构投资情况
     * @return:
     * @Author: fxh
     * @Date: 2018/12/29
     **/
    @Override
    public List bankInvest(String bankId) {
        List retList = new ArrayList();

        SimpleDateFormat ftYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat ftMonth = new SimpleDateFormat("MM");

        Calendar cal= Calendar.getInstance();
        Calendar calLast= Calendar.getInstance();
        calLast.add(Calendar.YEAR,-1);

        for(int i = 0; i < 4; i++){
            Map<String,String> retMap = new HashMap();
            if(i != 0){
                cal.add(Calendar.MONTH,-3);
                calLast.add(Calendar.MONTH,-3);
            }

            //当季数据
            String year = ftYear.format(cal.getTime());
            String month = ftMonth.format(cal.getTime());
            String quarter = String.valueOf ((( Integer.parseInt(month) - 1 ) / 3 ) + 1);
            String yearQuarter = year + quarter;
            Map map = investMapper.bankInvest(yearQuarter,bankId);

            //返回数据设置
            retMap.put("year",year);
            retMap.put("quarter",quarter);

            if(ObjectUtils.isEmpty(map)){
                retMap.put("amount","0");
                retMap.put("projectcounts","0");
                retMap.put("amountPer","0");
                retMap.put("projectcountsPer","0");
                retList.add(retMap);
                continue;
            }

            String amount = map.get("amount").toString();
            String projectcounts = map.get("projectcounts").toString();
            //返回数据设置
            retMap.put("amount",amount);
            retMap.put("projectcounts",projectcounts);

            //同比季度数据
            String yearLast = ftYear.format(calLast.getTime());
            String monthLast = ftMonth.format(calLast.getTime());
            String quarterLast = String.valueOf ((( Integer.parseInt(monthLast) - 1 ) / 3 ) + 1);
            String yearQuarterLast = yearLast + quarterLast;
            Map mapLast = investMapper.bankInvest(yearQuarterLast,bankId);

            if(ObjectUtils.isEmpty(mapLast)){
                retMap.put("amountPer","");
                retMap.put("projectcountsPer","");
                retList.add(retMap);
                continue;
            }
            String amountLast = mapLast.get("amount").toString();
            String projectcountsLast = mapLast.get("projectcounts").toString();

            String amountPer = yearPercent(Double.parseDouble(amount) , Double.parseDouble(amountLast));
            String projectcountsPer = yearPercent(Double.parseDouble(projectcounts) , Double.parseDouble(projectcountsLast));

            retMap.put("amountPer",amountPer);
            retMap.put("projectcountsPer",projectcountsPer);
            retList.add(retMap);

        }
        return retList;
    }

	

	

	

	

	
}
