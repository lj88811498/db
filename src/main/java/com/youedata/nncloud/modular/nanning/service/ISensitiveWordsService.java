package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.SensitiveWords;
/**
 * 敏感词Service
 *
 * @author TC
 * @Date 2018-12-29 09:18:31
 */
public interface ISensitiveWordsService extends IService<SensitiveWords>{

    /**
     * 昵称敏感词过滤
     * @param nickname
     * @return 包含true，否则false
     */
    String checkNickName(String nickname);
}
