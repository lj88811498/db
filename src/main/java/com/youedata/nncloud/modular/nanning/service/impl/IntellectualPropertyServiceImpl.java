package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.IntellectualProperty;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IIntellectualPropertyService;


/**
 * 知识产权Service
 *
 * @author TC
 * @Date 2019-01-21 11:03:04
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IntellectualPropertyServiceImpl extends ServiceImpl<BaseMapper<IntellectualProperty>,IntellectualProperty> implements IIntellectualPropertyService {
}
