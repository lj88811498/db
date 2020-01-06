package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.GovernmentOnline;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 政府在线 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-14
 */
@Transactional
@Component
public interface GovernmentOnlineMapper extends BaseMapper<GovernmentOnline> {

    List<GovernmentOnline> selectList(@Param("name")String governmentOnlineName,
                                      @Param("status")String governmentOnlineStatus,
                                      @Param("page")Page page);
}
