package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.ReportConfiguration;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 填报配置 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-26
 */
@Transactional
@Component
public interface ReportConfigurationMapper extends BaseMapper<ReportConfiguration> {

    /**
     * 根据填报的类型获取列表
     * @param page
     * @param name
     * @param status
     * @param type
     * @return
     */
     List<ReportConfiguration> getListByType(@Param("page") Page page,
                                             @Param("name") String name,
                                             @Param("status") String status,
                                             @Param("type") String type);

    /**
     * 删除
     * @param delflag
     * @param id
     */
     void updateReportConfigurationDel (@Param("delflag") String delflag,
                                        @Param("id") int id);

    /**
     * 改变状态
     * @param status
     * @param id
     */
     void updateReportConfigurationStatus (@Param("status") String status,
                                           @Param("id") int id,
                                           @Param("userId") int userId,
                                           @Param("updateTime")Date updateTime);

    /**
     * 报表名称是否重复
     * @param name
     * @param type
     * @return
     */
     Integer countByName(@Param("name") String name,
                         @Param("type") String type);


     void updateReportConfiguration(@Param("userId") int userId,
                                    @Param("id") int id,
                                    @Param("name") String name,
                                    @Param("reportConfigurationStartTime") Date reportConfigurationStartTime,
                                    @Param("reportConfigurationEndTime") Date reportConfigurationEndTime,
                                    @Param("reportConfigurationStartDay") String reportConfigurationStartDay,
                                    @Param("reportConfigurationExceptMonth") String reportConfigurationExceptMonth,
                                    @Param("reportConfigurationRemindMode") String reportConfigurationRemindMode,
                                    @Param("updateTime") Date updateTime);


     /**
      * @Description: 查询当天需要催报的消息
      * @return:
      * @Author: fxh
      * @Date: 2018/11/28
      **/
     List<ReportConfiguration> getCurrentInOneDay();
}
