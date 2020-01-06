package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.TitleEvaluation;

/**
 * 职称评审Service
 *
 * @author lich
 * @Date 2018-11-15 15:46:53
 */
public interface ITitleEvaluationService extends IService<TitleEvaluation> {
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
    Page selectList(String titleEvaluationTitle, String titleEvaluationUpdateTime, String titleEvaluationUpdateTimeEnd, String titleEvaluationStatus, int size, int curPage) throws Exception;

    /**
     * 新增
     *
     * @param governmentOnline
     */
    void add(TitleEvaluation governmentOnline) throws Exception;

    /**
     * 删除
     *
     * @param titleEvaluationId
     */
    void delete(Integer titleEvaluationId) throws Exception;

    /**
     * 上下线
     *
     * @param titleEvaluationId
     * @param titleEvaluationStatus
     * @throws Exception
     */
    void updateStatus(String titleEvaluationId, String titleEvaluationStatus) throws Exception;
}
