package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.FinanceData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 财务填报数据查询 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@Transactional
@Component
public interface FinanceDataMapper extends BaseMapper<FinanceData> {

    FinanceData getFinanceData(@Param("userId") Integer userId,
                               @Param("startTime") String startTime,
                               @Param("endTime") String endTime);

    /**
     * 企业图谱-营业状况
     * @param companyId
     * @param year
     * @return
     */
    List<Map<String,String>> getManagement(@Param("companyId") Integer companyId, @Param("year")String year);
}
