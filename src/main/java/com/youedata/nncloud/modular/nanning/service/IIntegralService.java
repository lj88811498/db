package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Integral;
/**
 * 积分排名表Service
 *
 * @author sunjian
 * @Date 2018-11-27 15:49:37
 */
public interface IIntegralService extends IService<Integral>{

    /**
     * 获取积分排名列表
     * @param size
     * @param curPage
     * @return
     */
    Page getList(int size, int curPage);
}
