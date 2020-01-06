package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IntegralMapper;
import com.youedata.nncloud.modular.nanning.model.Integral;
import com.youedata.nncloud.modular.nanning.service.IIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 积分排名表Service
 *
 * @author sunjian
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IntegralServiceImpl extends ServiceImpl<BaseMapper<Integral>,Integral> implements IIntegralService {

    @Autowired
    IntegralMapper integralMapper;

    /**
     * 获取积分排名列表
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getList(int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Integral> result = integralMapper.getList(page);
        page.setRecords(result);
        return page;
    }
}
