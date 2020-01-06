package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.ProjectDeclarationMapper;
import com.youedata.nncloud.modular.nanning.model.ProjectDeclaration;
import com.youedata.nncloud.modular.nanning.service.IProjectDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 项目申报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class ProjectDeclarationServiceImpl extends ServiceImpl<BaseMapper<ProjectDeclaration>,ProjectDeclaration> implements IProjectDeclarationService {
    @Autowired
    private ProjectDeclarationMapper projectDeclarationMapper;

    @Override
    public Page getList(int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Map> list = projectDeclarationMapper.getList();
        page.setRecords(list);
        return page;
    }
}
