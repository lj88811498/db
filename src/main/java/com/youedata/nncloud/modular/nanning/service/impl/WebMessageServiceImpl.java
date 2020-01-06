package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.WebMessageMapper;
import com.youedata.nncloud.modular.nanning.model.vo.WebMessageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.WebMessage;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IWebMessageService;

import java.util.List;
import java.util.Map;


/**
 * 系统通知Service
 *
 * @author Tancgheng
 * @Date 2018-11-28 09:20:59
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class WebMessageServiceImpl extends ServiceImpl<BaseMapper<WebMessage>, WebMessage> implements IWebMessageService {

    @Autowired
    WebMessageMapper webMessageMapper;

    @Override
    public List<WebMessage> getCurrentInOneHour() {
        return webMessageMapper.getWebMessageInOneHour();
    }

    @Override
    public Page<List<Map<String, Object>>> selectMessageListPage(int size, int curPage,String context, Integer state) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Map<String, Object>> result= webMessageMapper.selectMessageListPage(page,context,state);
        page.setRecords(result);
        return page;
    }
}
