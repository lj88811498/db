package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IndustryInfoMapper;
import com.youedata.nncloud.modular.nanning.model.IndustryInfo;
import com.youedata.nncloud.modular.nanning.service.IIndustryInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 行业信息表Service
 *
 * @author TC
 * @Date 2018-12-17 13:32:51
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IndustryInfoServiceImpl extends ServiceImpl<BaseMapper<IndustryInfo>, IndustryInfo> implements IIndustryInfoService {
    @Resource
    IndustryInfoMapper industryInfoMapper;

    @Override
    public Page getList(int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<IndustryInfo> result = industryInfoMapper.getList(page);
        page.setRecords(result);
        return page;
    }

    @Override
    public List<IndustryInfo> list() {
        return industryInfoMapper.list();
    }

    @Override
    public List<IndustryInfo> getSecondIndustry() {
        return industryInfoMapper.getSecondIndustry();
    }

	@Override
	public List<IndustryInfo> getById(Integer industryInfoPid) {
		return industryInfoMapper.getById(industryInfoPid);
	}

	@Override
	public List<IndustryInfo> getInId(Integer industryInfoPid) {
		return industryInfoMapper.getInId(industryInfoPid);
	}
}
