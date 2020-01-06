package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.GovernmentOnline;

/**
 * 政府在线Service
 *
 * @author monkey
 * @Date 2018-11-14 16:36:24
 */
public interface IGovernmentOnlineService extends IService<GovernmentOnline> {
    /**
     * 查询政府在线列表
     *
     * @param governmentOnlineName
     * @param governmentOnlineStatus
     * @param size
     * @param curPage
     * @return
     */
    Page selectList(String governmentOnlineName, String governmentOnlineStatus, int size, int curPage) throws Exception;

    /**
     * 添加政府在线信息
     *
     * @param governmentOnline
     * @throws Exception
     */
    void add(GovernmentOnline governmentOnline) throws Exception;

    /**
     * 政府在线上下线修改
     */
    void updateStatus(String governmentOnlineId, String governmentOnlineStatus) throws Exception;
}
