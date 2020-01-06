package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.IndustrialOutput;
/**
 * 工业主要产品产量表Service
 *
 * @author HuangKai
 * @Date 2018-12-12 16:49:41
 */
public interface IIndustrialOutputService extends IService<IndustrialOutput>{

    /**
     * 获取工业产量总值列表
     * @param date
     * @return
     */
    Page getList(String date,int size,int curPage) throws Exception;
}
