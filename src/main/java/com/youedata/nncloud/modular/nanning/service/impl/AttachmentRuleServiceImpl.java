package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.AttachmentRuleMapper;
import com.youedata.nncloud.modular.nanning.model.AttachmentRule;
import com.youedata.nncloud.modular.nanning.service.IAttachmentRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 项目类型附件规则Service
 *
 * @author HuangKai
 * @Date 2018-12-07 13:32:42
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class AttachmentRuleServiceImpl extends ServiceImpl<BaseMapper<AttachmentRule>,AttachmentRule> implements IAttachmentRuleService {
    @Autowired
    private AttachmentRuleMapper attachmentRuleMapper;

    @Override
    public Page gitList(Integer id,int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<AttachmentRule> list = attachmentRuleMapper.getList(id);
        page.setRecords(list);
        return page;
    }

    @Override
    public AttachmentRule getById(Integer id) {
        AttachmentRule attachmentRule = attachmentRuleMapper.getById(id);
        return attachmentRule;
    }

    @Override
    public  List<AttachmentRule> getByDeclarationId(Integer id) {
        List<AttachmentRule> list = attachmentRuleMapper.getByDeclarationId(id);
        return list;
    }
}
