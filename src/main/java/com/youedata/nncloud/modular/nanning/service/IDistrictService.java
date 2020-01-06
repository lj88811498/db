package com.youedata.nncloud.modular.nanning.service;
import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.District;
/**
 * 区县得分排名Service
 *
 * @author Sunjian
 * @Date 2018-12-12 11:31:17
 */
public interface IDistrictService extends IService<District>{

    /**
     * 获取区县得分排名列表
     * @param size
     * @param curPage
     * @return
     */
    Page getList(int size, int curPage);
    /**
     * 查询所有区县
     */
    List<District> listDistrict();
}
