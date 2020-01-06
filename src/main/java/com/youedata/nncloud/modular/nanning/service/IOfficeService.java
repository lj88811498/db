package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Office;

/**
 * 科室Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IOfficeService extends IService<Office> {
    /**
     * 根据科室名查询科室Id
     *
     * @param officeName
     * @return
     */
    Integer selectOfficeByName(String officeName);

    /**
     * 委办局列表
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getList(String orderByField, boolean isAsc, int size, int curPage);
}
