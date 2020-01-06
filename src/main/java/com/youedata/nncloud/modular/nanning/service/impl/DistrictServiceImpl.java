package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.DistrictMapper;
import com.youedata.nncloud.modular.nanning.model.District;
import com.youedata.nncloud.modular.nanning.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 区县得分排名Service
 *
 * @author Sunjian
 * @Date 2018-12-12 11:31:17
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class DistrictServiceImpl extends ServiceImpl<BaseMapper<District>,District> implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 获取区县得分排名
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getList(int size, int curPage){
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<District> result = districtMapper.getList(page);
        page.setRecords(result);
        return page;
    }

	@Override
	public List<District> listDistrict() {
		return districtMapper.listDistrict();
	}
}
