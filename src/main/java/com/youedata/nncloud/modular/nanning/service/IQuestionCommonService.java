package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.QuestionCommon;
/**
 * 常见问题表Service
 *
 * @author monkey
 * @Date 2018-11-09 15:19:35
 */
public interface IQuestionCommonService extends IService<QuestionCommon>{

    Page getList(String title, String type, String beginTime, String endTime, String status, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 添加并返回id
     * @param questionCommon
     * @return
     */
    Integer insertGetId(QuestionCommon questionCommon);
}
