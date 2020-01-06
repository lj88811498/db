package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.IndustrialOutput;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 工业主要产品产量表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-12
 */
@Transactional
@Component
public interface IndustrialOutputMapper extends BaseMapper<IndustrialOutput> {

    /**
     * 获取工业产量列表
     * @param date
     * @return
     */
    List<IndustrialOutput> getList (@Param("date") Integer date);
}
