package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.QuestionView;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IQuestionViewService;


/**
 * 问题浏览Service
 *
 * @author monkey
 * @Date 2018-10-12 14:39:40
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class QuestionViewServiceImpl extends ServiceImpl<BaseMapper<QuestionView>,QuestionView> implements IQuestionViewService {
}
