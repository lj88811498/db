package com.youedata.nncloud.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.system.model.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 操作日志 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
public interface OperationLogMapper extends BaseMapper<OperationLog> {

    /**
     * 获取操作日志
     */
    List<Map<String, Object>> getOperationLogs(@Param("page") Page<OperationLog> page, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("logName") String logName, @Param("logType") String logType, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    /**
     * 获取操作日志
     * @param userInfoId
     * @param beginTime
     * @param endTime
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<Map<String,Object>> getLogList(@Param("userInfoId") Integer userInfoId,
                              @Param("beginTime") String beginTime,
                              @Param("endTime") String endTime,
                              @Param("page") Page page,
                              @Param("orderByField") String orderByField,
                              @Param("isAsc") boolean isAsc);

}