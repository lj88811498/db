package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.util.DateUtil;
import com.youedata.nncloud.modular.nanning.dao.ReportConfigurationMapper;
import com.youedata.nncloud.modular.nanning.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.ReportConfiguration;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IReportConfigurationService;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 填报配置Service
 *
 * @author huangkai
 * @Date 2018-11-26 14:34:39
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class ReportConfigurationServiceImpl extends ServiceImpl<BaseMapper<ReportConfiguration>,ReportConfiguration> implements IReportConfigurationService {
    @Autowired
    private ReportConfigurationMapper reportConfigurationMapper;

    @Override
    public Page getListByType(String name, String status, String type, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<ReportConfiguration> list = reportConfigurationMapper.getListByType(page,name,status,type);
        for(ReportConfiguration reportConfiguration : list){
            StringBuffer explain = new StringBuffer();
            String startDay = reportConfiguration.getReportConfigurationStartDay();
            String exceptMonth = reportConfiguration.getReportConfigurationExceptMonth();
            explain.append("每月"+startDay+"号开始填报。");
            reportConfiguration.setExplian(explain.toString());
        }
        page.setRecords(list);
        return page;
    }

    @Override
    public void add(int userId, String name, String reportConfigurationStartTime, String reportConfigurationEndTime, String reportConfigurationStartDay,
                    String reportConfigurationExceptMonth, String reportConfigurationRemindMode, String type)  {

        ReportConfiguration reportConfiguration = new ReportConfiguration();
        reportConfiguration.setReportConfigurationCreateBy(userId);
        reportConfiguration.setReportConfigurationCreateTime(new Date());
        reportConfiguration.setReportConfigurationName(name);
        reportConfiguration.setReportConfigurationStartTime(DateUtil.parseDate(reportConfigurationStartTime));
        reportConfiguration.setReportConfigurationEndTime(DateUtil.parseDate(reportConfigurationEndTime));
        reportConfiguration.setReportConfigurationStartDay(reportConfigurationStartDay);
        reportConfiguration.setReportConfigurationExceptMonth(reportConfigurationExceptMonth);
        reportConfiguration.setReportConfigurationRemindMode(reportConfigurationRemindMode);
        reportConfiguration.setReportConfigurationType(type);
        this.insert(reportConfiguration);
    }

    @Override
    public void del(int id) throws Exception {
        reportConfigurationMapper.updateReportConfigurationDel("1",id);
    }

    @Override
    public ReportConfiguration detail(int id) throws Exception {
        ReportConfiguration reportConfiguration = this.selectById(id);
        if(null == reportConfiguration){
            throw new Exception("信息不存在");
        }
        return  reportConfiguration;
    }

    @Override
    public void changeStatus(int id,int userId) throws Exception {
        ReportConfiguration reportConfiguration = this.selectById(id);
        if(null == reportConfiguration){
            throw new Exception("信息不存在");
        }
        //当前状态禁用，则改变为启用
        if(reportConfiguration.getReportConfigurationStatus().equals("0")){
            reportConfiguration.setReportConfigurationStatus("1");
        }else if(reportConfiguration.getReportConfigurationStatus().equals("1")){
            reportConfiguration.setReportConfigurationStatus("0");
        }
        Date updateTime = new Date();
        reportConfigurationMapper.updateReportConfigurationStatus(reportConfiguration.getReportConfigurationStatus(),id,userId,updateTime);
    }

    @Override
    public Integer countByName(String name,String type){
        return reportConfigurationMapper.countByName(name,type);
    }

    @Override
    public void updateReportConfiguration(int userId, int reportConfigurationId, String name, String reportConfigurationStartTime, String reportConfigurationEndTime,
                                          String reportConfigurationStartDay, String reportConfigurationExceptMonth, String reportConfigurationRemindMode) {
        Date updateTime = new Date();
        reportConfigurationMapper.updateReportConfiguration(userId,reportConfigurationId,name,DateUtil.parseDate(reportConfigurationStartTime),DateUtil.parseDate(reportConfigurationEndTime),
                reportConfigurationStartDay,reportConfigurationExceptMonth,reportConfigurationRemindMode,updateTime);
    }


    @Override
    public List<ReportConfiguration> getCurrentInOneDay() {
        return reportConfigurationMapper.getCurrentInOneDay();
    }
}
