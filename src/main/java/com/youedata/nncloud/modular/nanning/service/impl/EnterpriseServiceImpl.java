package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.config.properties.GunsProperties;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.DeclarationAttachmentMapper;
import com.youedata.nncloud.modular.nanning.dao.EnterpriseMapper;
import com.youedata.nncloud.modular.nanning.model.DeclarationAttachment;
import com.youedata.nncloud.modular.nanning.model.Enterprise;
import com.youedata.nncloud.modular.nanning.model.vo.EnterpriseSearchVo;
import com.youedata.nncloud.modular.nanning.model.vo.NatureVo;
import com.youedata.nncloud.modular.nanning.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 企业信息表Service
 *
 * @author sunjian
 * @Date 2018-11-27 15:49:37
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class EnterpriseServiceImpl extends ServiceImpl<BaseMapper<Enterprise>,Enterprise> implements IEnterpriseService {

    @Autowired
    EnterpriseMapper enterpriseMapper;
    
    @Autowired
    private GunsProperties gunsProperties;
    
    @Autowired
    DeclarationAttachmentMapper declarationAttachmentMapper;

    /**
     * 获取工业企业汇总列表
     * @param enterpriseName
     * @param enterpriseIndustry
     * @param enterpriseRegion
     * @param enterpriseBusinessType
     * @param enterpriseType
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getList(String enterpriseName, String enterpriseIndustry, String enterpriseRegion, String enterpriseBusinessType, String enterpriseType, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Enterprise> result = enterpriseMapper.getList(enterpriseName,enterpriseIndustry,enterpriseRegion,enterpriseBusinessType,enterpriseType,page);
        page.setRecords(result);
        return page;
    }

    @Override
    public List<Enterprise> getAllList() {
        return enterpriseMapper.getAllList();
    }

    /**
     * 获取企业信息详情
     * @param enterpriseId
     * @return
     */
    @Override
    public Enterprise getById(Integer enterpriseId) {
        Enterprise enterprise = enterpriseMapper.getById(enterpriseId);
        String path = gunsProperties.getFileServerPath();
        if(enterprise==null){
            return null;
        }
        enterprise.setAttachmentUrl(path + enterprise.getAttachmentUrl());
        return enterprise;
    }

    /**
     * 我的企业
     * @param enterpriseUserId
     * @return
     */
    @Override
    public Enterprise getByUserId(Integer enterpriseUserId) {
    	Enterprise enterprise = enterpriseMapper.getByUserId(enterpriseUserId);
    	String path = gunsProperties.getFileServerPath();
    	if(enterprise==null){
    	    return null;
        }
        enterprise.setAttachmentUrl(path + enterprise.getAttachmentUrl());
        return enterprise;
    }

    /**
     * 获取所有企业的行业
     * @return
     */
    @Override
    public List<String> getAllIndustry() {
        return enterpriseMapper.getAllIndustry();
    }

    /**
     * 模糊搜索
     * @return
     */
    @Override
    public List<EnterpriseSearchVo> searchByName(String name){
        return enterpriseMapper.searchByName(name);
    }

	@Override
	public Enterprise findUserId(Integer enterpriseUserId) {
		Enterprise enterprise = enterpriseMapper.findUserId(enterpriseUserId);
		if(enterprise !=null){
			DeclarationAttachment attachment = declarationAttachmentMapper.getAttachment(enterprise.getEnterpriseId());
			if(attachment !=null){
				 String path = gunsProperties.getFileServerPath();
				 enterprise.setAttachmentUrl(path + attachment.getDeclarationAttachmentUrl());
			}
		}
		return enterprise;
	}

	@Override
	public Enterprise findById(Integer enterpriseId) {
		Enterprise enterprise =  enterpriseMapper.findById(enterpriseId);
		if(enterprise !=null){
			DeclarationAttachment attachment = declarationAttachmentMapper.getAttachment(enterprise.getEnterpriseId());
			if(attachment !=null){
				 String path = gunsProperties.getFileServerPath();
				 enterprise.setAttachmentUrl(path + attachment.getDeclarationAttachmentUrl());
			}
		}
		return enterprise;
	}

    @Override
    public Enterprise selectOne(Integer companyId) {
        return enterpriseMapper.findById(companyId);
    }

	@Override
	public List<NatureVo> listRegister(Integer natureId) {
		return enterpriseMapper.listRegister(natureId);
	}

	@Override
	public List<NatureVo> getNature() {
		return enterpriseMapper.getNature();
	}
}
