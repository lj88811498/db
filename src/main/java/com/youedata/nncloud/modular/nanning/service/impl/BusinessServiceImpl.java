package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.BusinessMapper;
import com.youedata.nncloud.modular.nanning.dao.DeclarationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Business;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IBusinessService;

import java.util.List;
import java.util.Map;


/**
 * 流转情况(业务流程表)Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class BusinessServiceImpl extends ServiceImpl<BaseMapper<Business>,Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public Page getList(int size,int curPage,Integer id) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Map> list = businessMapper.getList(id);
        page.setRecords(list);
        return page;
    }
}
