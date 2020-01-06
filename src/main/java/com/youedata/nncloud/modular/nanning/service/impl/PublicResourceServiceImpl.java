package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.PublicResource;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IPublicResourceService;


/**
 * 两化公共资源信息Service
 *
 * @author TC
 * @Date 2019-01-17 15:28:11
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class PublicResourceServiceImpl extends ServiceImpl<BaseMapper<PublicResource>,PublicResource> implements IPublicResourceService {
}
