package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.EmpInfoMapper;
import com.youedata.nncloud.modular.nanning.model.vo.EmpInfoVo;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.EmpInfo;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IEmpInfoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 招聘信息Service
 *
 * @author lee
 * @Date 2018-11-28 15:10:06
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class EmpInfoServiceImpl extends ServiceImpl<BaseMapper<EmpInfo>,EmpInfo> implements IEmpInfoService {
    @Resource
    private EmpInfoMapper empInfoMapper;

    /**
     * 获取列表
     * @param title
     * @param industry
     * @param positionType
     * @param area
     * @param property
     * @param education
     * @param experience
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getList(String title, String industry, String positionType, String area, String property, String education, String experience, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<EmpInfoVo> result = empInfoMapper.getList(title, industry, positionType, area, property, education, experience, page, orderByField, isAsc);
        page.setRecords(result);
        return page;
    }
}
