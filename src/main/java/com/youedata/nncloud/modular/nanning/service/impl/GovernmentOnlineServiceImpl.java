package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.util.GlobalHashMap;
import com.youedata.nncloud.core.util.ToolUtil;
import com.youedata.nncloud.modular.nanning.dao.GovernmentOnlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.GovernmentOnline;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IGovernmentOnlineService;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 政府在线Service
 *
 * @author monkey
 * @Date 2018-11-14 16:36:24
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class GovernmentOnlineServiceImpl extends ServiceImpl<BaseMapper<GovernmentOnline>,GovernmentOnline> implements IGovernmentOnlineService {
    @Autowired
    GovernmentOnlineMapper governmentOnlineMapper;

    /**
     * 查询政府在线列表
     * @param governmentOnlineName
     * @param governmentOnlineStatus
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page selectList(String governmentOnlineName, String governmentOnlineStatus, int size, int curPage) throws Exception{
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<GovernmentOnline> result = governmentOnlineMapper.selectList(governmentOnlineName, governmentOnlineStatus, page);
        page.setRecords(result);
        return page;
    }

    /**
     *
     * 添加在线信息
     */
    @Override
    public void add(GovernmentOnline governmentOnline) throws Exception{
        governmentOnline.setGovernmentOnlineCreateBy(1);
        governmentOnline.setGovernmentOnlineCreateTime(new Date());
        if(ToolUtil.isEmpty(governmentOnline.getGovernmentOnlineStatus())){
            governmentOnline.setGovernmentOnlineStatus("0");
        }
        governmentOnline.setGovernmentOnlineIsDelete("0");
        governmentOnline.insert();
    }


    @Override
    public void updateStatus(String governmentOnlineId, String governmentOnlineStatus) throws Exception {
        GovernmentOnline governmentOnline = governmentOnlineMapper.selectById(governmentOnlineId);
        if (governmentOnline == null) {
            throw new Exception("信息不存在");
        }
        governmentOnline.setGovernmentOnlineStatus(governmentOnlineStatus);
        governmentOnline.updateById();
    }
}
