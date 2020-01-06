package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.District;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 区县得分排名表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-12
 */
@Transactional
@Component
public interface DistrictMapper extends BaseMapper<District> {

    /**
     * 获取区县得分排名列表
     * @return
     */
    List<District> getList(@Param("page") Page page);
    /**
     * 查询所有区县
     */
    List<District> listDistrict();

}
