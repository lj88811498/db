package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.ProjectDeclaration;
/**
 * 项目申报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
public interface IProjectDeclarationService extends IService<ProjectDeclaration>{

    /**
     * 获取项目申报类型列表
     * @param size
     * @param curPage
     * @return
     */
    Page getList(int size ,int curPage);

}
