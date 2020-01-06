package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.IndustryInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 行业信息表Service
 *
 * @author TC
 * @Date 2018-12-17 13:32:51
 */
public interface IIndustryInfoService extends IService<IndustryInfo> {
    /**
     * 获取行业信息(分页)
     */
    Page getList(int size, int curPage);

    /**
     * 获取行业信息
     */
    List<IndustryInfo> list();

    /**
     * 获取所有二级行业
     *
     * @return
     */
    List<IndustryInfo> getSecondIndustry();
    /**
     * 通过子id查询信息
     */
    List<IndustryInfo> getById(Integer industryInfoPid); 
    /**
     * 通过子id查询信息
     */
    List<IndustryInfo> getInId(Integer industryInfoPid); 
}
