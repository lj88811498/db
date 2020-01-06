package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Collet;
import com.youedata.nncloud.modular.nanning.model.Question;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionListVo;

import java.util.List;

/**
 * 收藏Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IColletService extends IService<Collet>{

    /**
     * 根据问题Id查询收藏
     * @param questionId
     * @return
     */
    Collet getByQuestionId(Integer questionId, int colletUserId);
    /**
     * 根据用户Id查询收藏
     * @param userId
     * @return
     */
    Page getByUserId(Integer userId, String title, String type, String beginTime, String endTime, String progress, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 根据问题Id删除收藏
     * @param questionId
     */
    void deleteByQuestionId(Integer questionId, int colletUserId);
}
