package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Business;
/**
 * 流转情况(业务流程表)Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IBusinessService extends IService<Business>{
    /**
     * 获取流程列表
     * @param id
     * @return
     */
    Page getList(int size,int curPage,Integer id);
}
