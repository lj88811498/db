package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.CreationArticle;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.ICreationArticleService;


/**
 * 创新创业-技术前沿、产品推荐、项目申报Service
 *
 * @author TC
 * @Date 2019-01-18 16:08:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class CreationArticleServiceImpl extends ServiceImpl<BaseMapper<CreationArticle>,CreationArticle> implements ICreationArticleService {
}
