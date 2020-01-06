package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Integral;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 积分排名表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author sunjian
 * @since 2018-11-27
 */
@Transactional
@Component
public interface IntegralMapper extends BaseMapper<Integral> {

    /**
     * 获取积分排名列表
     * @return
     */
    List<Integral> getList(@Param("page") Page page);

}
