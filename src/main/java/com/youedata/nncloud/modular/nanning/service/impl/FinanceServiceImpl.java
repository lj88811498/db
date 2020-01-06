package com.youedata.nncloud.modular.nanning.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.modular.nanning.dao.*;
import com.youedata.nncloud.modular.nanning.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youedata.nncloud.core.common.constant.factory.PageFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IFinanceService;


/**
 * 财务报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class FinanceServiceImpl extends ServiceImpl<BaseMapper<Finance>, Finance> implements IFinanceService {
    @Resource
    FinanceMapper financeMapper;
    @Resource
    FinanceDataMapper financeDataMapper;
    @Resource
    EnterpriseMapper enterpriseMapper;
    @Resource
    FinanceDetailsMapper financeDetailsMapper;
    @Autowired
    IndustryDetailsMapper industryDetailsMapper;

    /**
     * 查询财务报表列表
     */
    @Override
    public Page getList(String financeEnterpriseId, int size, int curPage, String financeName, String enterpriseName, String startTime, String endTime) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        if (!StringUtils.isEmpty(financeEnterpriseId)) {
            Enterprise enterprise = enterpriseMapper.findUserId(Integer.parseInt(financeEnterpriseId));
            if (enterprise != null) {
                List<Finance> result = financeMapper.getList(page, String.valueOf(enterprise.getEnterpriseId()), financeName, null, null, null);
                for (int i = 0; i < result.size(); i++) {
                    result.get(i).setEnterpriseName(enterprise.getEnterpriseName());
                    ;
                }
                page.setRecords(result);
                return page;
            }
        }else if(StringUtils.isEmpty(financeEnterpriseId)){
        	 List<Finance> result = financeMapper.getList(page, null, financeName, enterpriseName, startTime, endTime);
             for (int i = 0; i < result.size(); i++) {
                 Enterprise epn = enterpriseMapper.findById(Integer.parseInt(result.get(i).getFinanceEnterpriseId()));
                 if (epn != null) {
                     result.get(i).setEnterpriseName(epn.getEnterpriseName());
                 }
             }
             page.setRecords(result);
             return page;
        }
        return page;
    }

    /**
     * 根据财务报表id获取信息
     */
    @Override
    public Finance getById(Integer financeId) {
        Finance finance = financeMapper.getById(financeId);
        Enterprise enterprise = enterpriseMapper.findById(Integer.parseInt(finance.getFinanceEnterpriseId()));
        if (enterprise != null) {
            finance.setEnterpriseName(enterprise.getEnterpriseName());
        }
        return finance;
    }

    /**
     * 查询财务填报数据
     *
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public FinanceData getFinanceData(Integer userId, String startTime, String endTime) {
        return financeDataMapper.getFinanceData(userId, startTime, endTime);
    }

    /**
     * 企业图谱-经营状况
     *
     * @param companyId
     * @param year
     * @return
     */
    @Override
    public List<Map<String, String>> getManagement(Integer companyId, String year) {
        return financeDataMapper.getManagement(companyId, year);
    }

    /**
     * 企业图谱-同期累计
     *
     * @param companyId
     * @return
     */
    @Override
    public List<Map<String, String>> getCumulative(Integer companyId, String year) {
        List<Map<String, String>> result = financeDetailsMapper.getCumulative(companyId, year);
        return result;
    }

    /**
     * 经营趋势及增长-营业收入
     *
     * @param companyId
     * @return
     */
    @Override
    public List<Map<String, String>> getIncome(Integer companyId) {
        List<Map<String, String>> result = financeDetailsMapper.getIncome(companyId);
        return result;
    }

    /**
     * 企业图谱-营业成本
     *
     * @param companyId
     * @return
     */
    @Override
    public List<Map<String, String>> getCost(Integer companyId) {
        List<Map<String, String>> result = financeDetailsMapper.getCost(companyId);
        return result;
    }

    /**
     * 企业图谱-利润
     *
     * @param companyId
     * @return
     */
    @Override
    public List<Map<String, String>> getProfit(Integer companyId) {
        List<Map<String, String>> result = financeDetailsMapper.getProfit(companyId);
        return result;
    }

    /**
     * @param companyId
     * @param type:0、工业总产值；1、行业小分类；2、主要产品产量
     * @return
     */
    @Override
    public JSONObject getProduction(Integer companyId, Integer type, Integer year) {
        JSONObject object = new JSONObject();
        List<Map<String, String>> result = null;
        List<Map<String, String>> name = null;
        switch (type) {
            case 0:
                result = industryDetailsMapper.getTotal(companyId);
                object.put("name", name);
                object.put("data", result);
                break;
            case 1:
                result = industryDetailsMapper.getClassification(companyId, year, year - 5);
                name = industryDetailsMapper.getClassificationName(companyId, year, year - 5);
                object.put("name", name);
                object.put("data", result);
                break;
            case 2:
                result = industryDetailsMapper.getProducts(companyId, year, year - 5);
                name = industryDetailsMapper.getProductsName(companyId, year, year - 5);
                object.put("name", name);
                object.put("data", result);
                break;

        }
        return object;
    }



    public int add(Finance finance){
        int ret = financeMapper.add(finance);
        return ret;
    }
}
