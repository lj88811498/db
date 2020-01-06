package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.Business;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 流转情况(业务流程表); InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface BusinessMapper extends BaseMapper<Business> {

    List<Map> getList(@Param("id") Integer id);

}
