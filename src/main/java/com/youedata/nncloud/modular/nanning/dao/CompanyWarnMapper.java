package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.CompanyWarn;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 重点企业预警 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@Transactional
@Component
public interface CompanyWarnMapper extends BaseMapper<CompanyWarn> {

    List<CompanyWarn> list(@Param("userId")String userId, @Param("yearMonth")String yearMonth, @Param("sort")int sort);

}
