package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.DeclarationMapper;
import com.youedata.nncloud.modular.nanning.dao.ProjectDeclarationMapper;
import com.youedata.nncloud.modular.nanning.service.IDeclarationAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Declaration;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IDeclarationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 我的申报表Service
 *
 * @author chenhui
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class DeclarationServiceImpl extends ServiceImpl<BaseMapper<Declaration>,Declaration> implements IDeclarationService {
    @Autowired
    private DeclarationMapper declarationMapper;
    @Autowired
    private IDeclarationAttachmentService iDeclarationAttachmentService;

    @Override
    public Page getList(int size, int curPage, Integer userId) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Map> list = declarationMapper.getList(userId);
        page.setRecords(list);
        return page;
    }

    @Override
    public Map getById(Integer id) throws Exception {
        Declaration declaration =declarationMapper.getById(id);
        Map map = new HashMap();
        map.put("detail",declaration);
        List list  = iDeclarationAttachmentService.getList(id);
        map.put("attachmentsTable",list);
        return map;
    }
}
