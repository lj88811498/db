package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.PublicResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 两化公共资源信息 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2019-01-17
 */
@Transactional
@Component
public interface PublicResourceMapper extends BaseMapper<PublicResource> {

}
