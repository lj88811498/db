package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Declaration;
import io.swagger.models.auth.In;

import java.util.Map;

/**
 * 我的申报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IDeclarationService extends IService<Declaration>{
    /**
     * 获取申报列表
     * @param size
     * @param curPage
     * @param userId
     * @return
     */
    Page getList(int size,int curPage, Integer userId);

    /**
     * 通过id获取
     * @param id
     * @return
     */
    Map getById(Integer id) throws Exception;

}
