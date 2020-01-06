package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.ReportConfiguration;

import java.util.List;

/**
 * 填报配置Service
 *
 * @author huangkai
 * @Date 2018-11-26 14:34:39
 */
public interface IReportConfigurationService extends IService<ReportConfiguration>{

    /**
     * 根据填报的类型获取类表
     * @param name
     * @param status
     * @param type
     * @param size
     * @param curPage
     * @return
     */
    Page getListByType(String name ,String status ,String type , int size, int curPage);

    /**
     * 新增考核方案配置
     * @param userId
     * @param name
     * @param reportConfigurationStartTime
     * @param reportConfigurationEndTime
     * @param reportConfigurationStartDay
     * @param reportConfigurationExceptMonth
     * @param reportConfigurationRemindMode
     * @param type
     * @return
     */
    void add (int userId,String name,String reportConfigurationStartTime,String reportConfigurationEndTime,
                             String reportConfigurationStartDay,String reportConfigurationExceptMonth,String reportConfigurationRemindMode,
                             String type);

    /**
     * 删除
     * @param id
     */
    void del (int id ) throws Exception;

    /**
     * 查看详情
     * @param id
     * @return
     */
    ReportConfiguration detail(int id) throws Exception;

    /**
     * 修改状态
     * @param id
     * @throws Exception
     */
    void changeStatus(int id,int userId) throws Exception;

    /**
     * 输入报表名称是否重复
     * @param name
     * @return
     */
     Integer countByName(String name,String type);

    /**
     * 更新报表
     * @param userId
     * @param reportConfigurationId
     * @param name
     * @param reportConfigurationStartTime
     * @param reportConfigurationEndTime
     * @param reportConfigurationStartDay
     * @param reportConfigurationExceptMonth
     * @param reportConfigurationRemindMode
     */
     void updateReportConfiguration(int userId,int reportConfigurationId,String name,String reportConfigurationStartTime,String reportConfigurationEndTime,
                                    String reportConfigurationStartDay,String reportConfigurationExceptMonth,String reportConfigurationRemindMode);


     /**
      * @Description: 查询当天需要催报的消息
      * @return:
      * @Author: fxh
      * @Date: 2018/11/28
      **/
     List<ReportConfiguration> getCurrentInOneDay();
}
