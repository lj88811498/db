package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.IndustryInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 行业信息表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-17
 */
@Transactional
@Component
public interface IndustryInfoMapper extends BaseMapper<IndustryInfo> {
    /**
     * 获取行业信息(分页)
     */
    List<IndustryInfo> getList(@Param("page") Page page);

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
    List<IndustryInfo> getById(@Param("industryInfoPid") Integer industryInfoPid); 
    /**
     * 通过子id查询信息
     */
    List<IndustryInfo> getInId(@Param("industryInfoPid") Integer industryInfoPid); 
}
