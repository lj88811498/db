package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.config.properties.GunsProperties;
import com.youedata.nncloud.modular.nanning.dao.DeclarationAttachmentMapper;
import com.youedata.nncloud.modular.nanning.model.AttachmentRule;
import com.youedata.nncloud.modular.nanning.model.DeclarationAttachment;
import com.youedata.nncloud.modular.nanning.model.vo.AttachmentRuleVo;
import com.youedata.nncloud.modular.nanning.service.IAttachmentRuleService;
import com.youedata.nncloud.modular.nanning.service.IDeclarationAttachmentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 申报附件Service
 *
 * @author huangkai
 * @Date 2018-11-28 21:53:10
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class DeclarationAttachmentServiceImpl extends ServiceImpl<BaseMapper<DeclarationAttachment>,DeclarationAttachment> implements IDeclarationAttachmentService {
    @Autowired
    private DeclarationAttachmentMapper declarationAttachmentMapper;

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private IAttachmentRuleService iAttachmentRuleService;
    @Override
    public List getList(Integer id)throws Exception {

       // Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<DeclarationAttachment> list = declarationAttachmentMapper.getList(id);
        List<AttachmentRule> ruleList = iAttachmentRuleService.getByDeclarationId(id);
        List<AttachmentRuleVo> ruleVoList=new ArrayList<>();
        if(ruleList.size()==0){
           // page.setRecords(ruleList);
            return ruleVoList;
        }
        for(AttachmentRule attachmentRule : ruleList){
            Integer attachmentRuleId = attachmentRule.getAttachmentRuleId();
            List listContext = new ArrayList();
            List<AttachmentRuleVo> rules=new ArrayList<>();
            for(DeclarationAttachment declarationAttachment:list){
                if(declarationAttachment.getDeclarationAttachmentRuleId()==attachmentRuleId){
                    Map map = new HashedMap();
                    AttachmentRuleVo vo=new AttachmentRuleVo();
                    map.put("fileName",declarationAttachment.getDeclarationAttachmentName());
                    vo.setFileName(declarationAttachment.getDeclarationAttachmentName());
                    map.put("url",gunsProperties.getFileServerPath()+declarationAttachment.getDeclarationAttachmentUrl());
                    vo.setUrl(gunsProperties.getFileServerPath()+declarationAttachment.getDeclarationAttachmentUrl());
                    listContext.add(map);
                    rules.add(vo);
                }
            }
            attachmentRule.setFileList(listContext);
            ruleVoList.addAll(rules);
        }
       //page.setRecords(ruleList);
        return ruleVoList;
    }
}
