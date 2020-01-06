package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.EmpInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.EmpInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 招聘信息表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@Transactional
@Component
public interface EmpInfoMapper extends BaseMapper<EmpInfo> {
    /**
     * 获取列表
     * @param title
     * @param industry
     * @param positionType
     * @param area
     * @param property
     * @param education
     * @param experience
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<EmpInfoVo> getList(@Param("title") String title,
                            @Param("industry") String industry,
                            @Param("positionType") String positionType,
                            @Param("area") String area,
                            @Param("property") String property,
                            @Param("education") String education,
                            @Param("experience") String experience,
                            @Param("page") Page page,
                            @Param("orderByField") String orderByField,
                            @Param("isAsc") boolean isAsc);
}
