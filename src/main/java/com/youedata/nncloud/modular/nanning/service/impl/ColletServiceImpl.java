package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.ColletMapper;
import com.youedata.nncloud.modular.nanning.dao.QuestionMapper;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Collet;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IColletService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 收藏Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class ColletServiceImpl extends ServiceImpl<BaseMapper<Collet>,Collet> implements IColletService {

    @Resource
    private ColletMapper colletMapper;
    @Resource
    private QuestionMapper questionMapper;
    /**
     * 根据问题Id查询收藏
     * @param questionId
     * @return
     */
    @Override
    public Collet getByQuestionId(Integer questionId, int colletUserId) {
        return colletMapper.getByQuestionId(questionId, colletUserId);
    }

    /**
     * 根据用户id查询收藏
     * @param userId
     * @return
     */
    @Override
    public  Page getByUserId(Integer userId, String title, String type, String beginTime, String endTime, String progress, String orderByField, boolean isAsc, int size, int curPage) {
        Page page =  new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<QuestionListVo> result = questionMapper.getByCollentUserId(page,orderByField,isAsc, userId, title, type, beginTime, endTime, progress);
        page.setRecords(result);
        return page;
    }

    @Override
    public void deleteByQuestionId(Integer questionId,  int colletUserId) {
        colletMapper.deleteByQuestionId(questionId, colletUserId);
    }
}
