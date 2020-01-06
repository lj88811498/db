package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.CreationArticle;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 创新创业-技术前沿、产品推荐、项目申报 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2019-01-18
 */
@Transactional
@Component
public interface CreationArticleMapper extends BaseMapper<CreationArticle> {

}
