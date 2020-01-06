package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.SensitiveWords;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 敏感词 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-29
 */
@Transactional
@Component
public interface SensitiveWordsMapper extends BaseMapper<SensitiveWords> {

    /**
     * 获取所有敏感词
     * @return
     */
    List<String> getWords();
}
