package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.util.ToolUtil;
import com.youedata.nncloud.modular.nanning.dao.TitleEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.TitleEvaluation;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.ITitleEvaluationService;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 职称评审Service
 *
 * @author lich
 * @Date 2018-11-15 15:46:53
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class TitleEvaluationServiceImpl extends ServiceImpl<BaseMapper<TitleEvaluation>, TitleEvaluation> implements ITitleEvaluationService {
    @Autowired
    TitleEvaluationMapper titleEvaluationMapper;

    /**
     * 查询列表
     *
     * @param titleEvaluationTitle
     * @param titleEvaluationUpdateTime
     * @param titleEvaluationStatus
     * @param size
     * @param curPage
     * @return
     * @throws Exception
     */
    @Override
    public Page selectList(String titleEvaluationTitle, String titleEvaluationUpdateTime, String titleEvaluationUpdateTimeEnd, String titleEvaluationStatus, int size, int curPage) throws Exception {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<TitleEvaluation> result = titleEvaluationMapper.selectList(titleEvaluationTitle, titleEvaluationUpdateTime, titleEvaluationUpdateTimeEnd, titleEvaluationStatus, page);
        page.setRecords(result);
        return page;
    }

    /**
     * 新增
     *
     * @param governmentOnline
     */
    @Override
    public void add(TitleEvaluation governmentOnline) throws Exception {
        if (ToolUtil.isEmpty(governmentOnline.getTitleEvaluationStatus())) {
            governmentOnline.setTitleEvaluationStatus("0");
        }
        governmentOnline.setTitleEvaluationIsDelete("0");
        governmentOnline.setTitleEvaluationCreateBy(1);
        governmentOnline.setTitleEvaluationCreateTime(new Date());
        governmentOnline.setTitleEvaluationUpdateBy(1);
        governmentOnline.setTitleEvaluationUpdateTime(new Date());
        governmentOnline.insert();
    }

    /**
     * 删除
     *
     * @param titleEvaluationId
     * @throws Exception
     */
    @Override
    public void delete(Integer titleEvaluationId) throws Exception {
        TitleEvaluation titleEvaluation = titleEvaluationMapper.selectById(titleEvaluationId);
        if (titleEvaluation == null) {
            throw new Exception("信息不存在");
        }
        titleEvaluation.setTitleEvaluationIsDelete("1");
        titleEvaluation.setTitleEvaluationUpdateBy(1);
        titleEvaluation.setTitleEvaluationUpdateTime(new Date());
        titleEvaluation.updateById();
    }

    /**
     * 上下线接口
     *
     * @param titleEvaluationId
     * @param titleEvaluationStatus
     * @throws Exception
     */
    @Override
    public void updateStatus(String titleEvaluationId, String titleEvaluationStatus) throws Exception {
        TitleEvaluation titleEvaluation = titleEvaluationMapper.selectById(titleEvaluationId);
        if (titleEvaluation == null) {
            throw new Exception("信息不存在");
        }
        titleEvaluation.setTitleEvaluationStatus(titleEvaluationStatus);
        titleEvaluation.updateById();

    }
}
