package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.QuestionView;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 问题浏览 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-10-12
 */
@Transactional
@Component
public interface QuestionViewMapper extends BaseMapper<QuestionView> {

}
