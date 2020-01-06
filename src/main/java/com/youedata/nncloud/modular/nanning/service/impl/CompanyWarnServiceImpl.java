package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.modular.nanning.dao.*;
import com.youedata.nncloud.modular.nanning.model.Enterprise;
import com.youedata.nncloud.modular.nanning.model.IndustrialStatistics;
import com.youedata.nncloud.modular.nanning.model.OutputValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.CompanyWarn;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.ICompanyWarnService;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 重点企业预警Service
 *
 * @author fxh
 * @Date 2018-12-13 13:58:41
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class CompanyWarnServiceImpl extends ServiceImpl<BaseMapper<CompanyWarn>,CompanyWarn> implements ICompanyWarnService {


    @Autowired
    private CompanyWarnMapper companyWarnMapper;


    @Autowired
    private EnterpriseMapper enterpriseMapper;


    @Autowired
    private IndustryMapper industryMapper;


    @Autowired
    private IndustrialStatisticsMapper industrialStatisticsMapper;


    @Autowired
    private OutputValueMapper outputValueMapper;



    @Override
    public List<CompanyWarn> list(String userId, String yearMonth, int sort) {
        return companyWarnMapper.list(userId, yearMonth, sort);
    }


    @Override
    public void calculate(String yearMonth) {
        List<CompanyWarn> companyWarnList = new ArrayList<>();


        List<Map> OutputValueList = outputValueMapper.getAllList();
        CompanyWarn companyWarn;
        int userId;
        String output;  //年产值
        String outputLast;  //上个月年产值


        String outputMonth;  //当月产值
        String outputMonthLast;  //上月产值
        String outputMonthLastYear;  //去年同期产值

        String rank;    //年产值排名
        String rankLast;    //上个月年产值排名

        String timeLastMonth;
        String timeLastYear;

        if (!ObjectUtils.isEmpty(OutputValueList)){
            for(int i = 0; i < OutputValueList.size(); i++){
                companyWarn = new CompanyWarn();
                companyWarn.setCompanyWarnYearMonth(yearMonth);
                userId = Integer.valueOf(OutputValueList.get(i).get("output_value_enterprise_id").toString());
                /**
                 * 企业id
                 */
                companyWarn.setCompanyWarnUserId(userId);

                //获取企业年产值及排名
                Map map = outputValueMapper.getListByRank(userId,yearMonth);
                //年产值
                output = map.get("output_value_detail").toString();
                /**
                 * 年产值
                 */
                companyWarn.setCompanyWarnOutput(output);
                //年产值排名
                rank = String.valueOf(map.get("rank"));
                /**
                 * 排名
                 */
                companyWarn.setCompanyWarnRank(rank);


                SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
                Date currdate = null;
                try {
                    currdate = format.parse(yearMonth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar ca = Calendar.getInstance();
                ca.setTime(currdate);
                ca.add(Calendar.MONTH,-1);
                currdate = ca.getTime();
                //上个月时间：年月
                timeLastMonth = format.format(currdate);



                ca.add(Calendar.YEAR,-1);
                currdate = ca.getTime();
                //去年时间：年月
                timeLastYear = format.format(currdate);




                //获取企业上月年产值及排名
                map = outputValueMapper.getListByRank(userId,timeLastMonth);
                //上个月年产值排名
                rankLast = String.valueOf(map.get("rank"));

                int rankChange = Integer.parseInt(rank) - Integer.parseInt(rankLast);
                /**
                 * 排名变化
                 */
                companyWarn.setCompanyWarnRankChange(String.valueOf(rankChange));



                Map statisMap = new HashMap();
                statisMap.put("industrial_statistics_enterprise_id",userId);
                //获取企业名称
                List<IndustrialStatistics> industriList = industrialStatisticsMapper.selectByMap(statisMap);

                if(!ObjectUtils.isEmpty(industriList)){
                    companyWarn.setCompanyWarnUserName(industriList.get(0).getIndustrialStatisticsCompanyName());
                }

                IndustrialStatistics industrialStatistics = new IndustrialStatistics();
                industrialStatistics.setIndustrialStatisticsEnterpriseId(userId);
                industrialStatistics.setIndustrialStatisticsYearMonth(Integer.parseInt(yearMonth));
                IndustrialStatistics statisticsNow = industrialStatisticsMapper.selectOne(industrialStatistics);
                if(ObjectUtils.isEmpty(statisticsNow)){
                    outputMonth = "0";
                }else{
                    //当月产值
                    outputMonth = statisticsNow.getIndustrialStatisticsOutputValue();
                }

                industrialStatistics.setIndustrialStatisticsYearMonth(Integer.parseInt(timeLastMonth));
                IndustrialStatistics statisticsLast = industrialStatisticsMapper.selectOne(industrialStatistics);
                if(ObjectUtils.isEmpty(statisticsLast)){
                    outputMonthLast = "0";
                }else{
                    //上月产值
                    outputMonthLast = statisticsLast.getIndustrialStatisticsOutputValue();
                }


                industrialStatistics.setIndustrialStatisticsYearMonth(Integer.parseInt(timeLastYear));
                IndustrialStatistics statisticsLastYear = industrialStatisticsMapper.selectOne(industrialStatistics);
                if(ObjectUtils.isEmpty(statisticsLastYear)){
                    outputMonthLastYear = "0";
                }else{
                    //去年同期产值
                    outputMonthLastYear = statisticsLastYear.getIndustrialStatisticsOutputValue();
                }


                //万元换算成亿元
                Double outputChange = (Double.valueOf(outputMonth) - Double.valueOf(outputMonthLast)) / 10000;
                DecimalFormat df   = new DecimalFormat("0.00");
                companyWarn.setCompanyWarnOutputChange(df.format(outputChange));



                //最高产值占比
                String maxOutPut = industrialStatisticsMapper.getMaxOutPut(userId);
                String maxOutPutPropor;
                if(ObjectUtils.isEmpty(maxOutPut)){
                    maxOutPutPropor = "";
                }else{
                    maxOutPutPropor = getCal(Double.parseDouble(outputMonth),Double.parseDouble(maxOutPut));
                }
                companyWarn.setCompanyWarnOutputProportion(maxOutPutPropor);

                //去年同期
                String yearRate = getMom(Double.parseDouble(outputMonth), Double.parseDouble(outputMonthLastYear));
                companyWarn.setCompanyWarnYearRate(yearRate);
                //环比
                String lastRate = getMom(Double.parseDouble(outputMonth), Double.parseDouble(outputMonthLast));
                companyWarn.setCompanyWarnLastRate(lastRate);

                companyWarnList.add(companyWarn);

            }

            insertBatch(companyWarnList);
        }


    }


    /**
     * 计算百分比
     *
     * @param thisYear 除数
     * @param lastYear 被除数
     * @return
     */
    private String getMom(Double thisYear, Double lastYear) {
        if(ObjectUtils.isEmpty(thisYear) || ObjectUtils.isEmpty(lastYear) || lastYear == 0){
            return null;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format((thisYear - lastYear) / lastYear * 100);
    }

    /**
     * @Description: 百分比计算
     * @return:
     * @Author: fxh
     * @Date: 2018/12/18
     **/
    private String getCal(Double thisYear, Double max) {
        if(ObjectUtils.isEmpty(thisYear) || ObjectUtils.isEmpty(max) || max == 0){
            return "";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(thisYear / max * 100);
    }

}
