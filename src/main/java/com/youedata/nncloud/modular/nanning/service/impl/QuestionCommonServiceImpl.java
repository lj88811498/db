package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.QuestionCommonMapper;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.QuestionCommon;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IQuestionCommonService;

import java.util.List;
import java.util.Map;


/**
 * 常见问题表Service
 *
 * @author monkey
 * @Date 2018-11-09 15:19:35
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class QuestionCommonServiceImpl extends ServiceImpl<BaseMapper<QuestionCommon>,QuestionCommon> implements IQuestionCommonService {

    @Autowired
    private QuestionCommonMapper questionCommonMapper;

    @Override
    public Page getList(String title, String type, String beginTime, String endTime, String status, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<QuestionCommon> result = questionCommonMapper.getList(title, type, beginTime, endTime, status, page, "question_common_update_time", false);
        page.setRecords(result);
        return page;
    }

    /**
     * 添加并返回id
     * @param questionCommon
     * @return
     */
    @Override
    public Integer insertGetId(QuestionCommon questionCommon) {
        return questionCommonMapper.insertGetId(questionCommon);
    }
}
