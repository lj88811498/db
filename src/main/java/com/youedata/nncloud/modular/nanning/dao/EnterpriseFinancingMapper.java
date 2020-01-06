package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.EnterpriseFinancing;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 企业融资信息 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2019-01-23
 */
@Transactional
@Component
public interface EnterpriseFinancingMapper extends BaseMapper<EnterpriseFinancing> {

}
