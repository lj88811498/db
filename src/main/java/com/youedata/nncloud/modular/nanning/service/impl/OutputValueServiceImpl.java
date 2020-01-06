package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IndustryDetailsMapper;
import com.youedata.nncloud.modular.nanning.dao.IndustryMapper;
import com.youedata.nncloud.modular.nanning.dao.OutputValueMapper;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
import com.youedata.nncloud.modular.nanning.model.OutputValue;
import com.youedata.nncloud.modular.nanning.service.IOutputValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunjian
 * @Date 2018/12/12
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class OutputValueServiceImpl extends ServiceImpl<BaseMapper<OutputValue>,OutputValue> implements IOutputValueService {

    @Autowired
    private OutputValueMapper outputValueMapper;

    @Autowired
    private IndustryMapper industryMapper;

    @Autowired
    private IndustryDetailsMapper industryDetailsMapper;

    public Map getData(Date date, Integer minValue, Integer maxValue, int size, int curPage){
        Map map = new HashMap();
        Page page = this.getList(date,minValue,maxValue,size,curPage);
        List regionList = this.getRegionList(date,minValue,maxValue);
        List typeList = this.getTypeList(date,minValue,maxValue);
        map.put("page",page);
        map.put("regionList",regionList);
        map.put("typeList",typeList);
        return map;
    }

    /**
     * 获取重点企业信息
     * @param date 日期
     * @param minValue 最小产值
     * @param maxValue 最大产值
     * @param size
     * @param curPage
     * @return
     */
    public Page getList(Date date, Integer minValue, Integer maxValue, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
        Integer date2 = null;
        if(date==null){
            date2 = Integer.parseInt(sdf.format(new Date()).toString());
        }else{
            date2 = Integer.parseInt(sdf.format(date).toString());
        }
        List<Map> result = outputValueMapper.getList(date2,minValue,maxValue,page);
        page.setRecords(result);
        return page;
    }

    /**
     * 获取区县分布(饼图)
     * @return
     */
    public List getRegionList(Date date, Integer minValue, Integer maxValue) {
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
        Integer date2 = null;
        if(date==null){
            date2 = Integer.parseInt(sdf.format(new Date()).toString());
        }else{
            date2 = Integer.parseInt(sdf.format(date).toString());
        }
        List list = outputValueMapper.getRegionList(date2,minValue,maxValue);
        return list;
    }

    /**
     * 获取企业性质(柱形图)
     * @return
     */
    public List getTypeList(Date date, Integer minValue, Integer maxValue) {
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
        Integer date2 = null;
        if(date==null){
            date2 = Integer.parseInt(sdf.format(new Date()).toString());
        }else{
            date2 = Integer.parseInt(sdf.format(date).toString());
        }
        List list = outputValueMapper.getTypeList(date2,minValue,maxValue);
        return list;
    }

    /**
     * 获取年产值
     * @param industryEnterpriseId
     * @param industryYear
     * @return
     */
    public Double getAnnualOutputValue(String industryEnterpriseId, Integer industryYear){
        Double annualOutputValue;
        IndustryDetails industryDetails = this.getIndustryDetails(industryEnterpriseId,industryYear);
        int industryDetailsAccumulate1 = industryDetails.getIndustryDetailsAccumulate1();//今年到当前月份的累积产值
        int industryDetailsAccumulate2 = industryDetails.getIndustryDetailsAccumulate2();//去年到当前月份的累积产值
        Integer industryLastYear = industryYear - 100;
        if(String.valueOf(industryLastYear).substring(4,6).equals("12")){
            annualOutputValue = (double)industryDetailsAccumulate1;
            return annualOutputValue/100000;
        }
        String industryLastYearString = String.valueOf(industryLastYear).substring(0,4) + "12";//得到去年十二月份
        Integer industryLastYearFinally = Integer.parseInt(industryLastYearString);
        IndustryDetails industryDetailsOfLastYear = this.getIndustryDetails(industryEnterpriseId,industryLastYearFinally);
        int industryDetailsAccumulate1OfLastYear = industryDetailsOfLastYear.getIndustryDetailsAccumulate1();//去年一月至十二月的累积产值
        annualOutputValue = (double)((industryDetailsAccumulate1OfLastYear - industryDetailsAccumulate2) + industryDetailsAccumulate1);
        return annualOutputValue/100000;
    }

    /**
     * 获取年产值相关表的详情
     * @return
     */
    public IndustryDetails getIndustryDetails(String industryEnterpriseId, Integer industryYear){
        int industryId = industryMapper.getId(industryEnterpriseId,industryYear);
        IndustryDetails industryDetails = industryDetailsMapper.getIndustryDetailsByIdAndType(industryId,"1");
        return industryDetails;
    }

}
