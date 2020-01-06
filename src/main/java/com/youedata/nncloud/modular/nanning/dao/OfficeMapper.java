package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Office;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface OfficeMapper extends BaseMapper<Office> {
    Integer selectOfficeByName(@Param("officeName") String officeName);

    /**
     * 获取角色列表
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<Office> getList(@Param("page") Page page,
                         @Param("orderByField") String orderByField,
                         @Param("isAsc") boolean isAsc);
}
