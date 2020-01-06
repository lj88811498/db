package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.DeclarationAttachment;

import java.util.List;

/**
 * 申报附件Service
 *
 * @author huangkai
 * @Date 2018-11-28 21:53:10
 */
public interface IDeclarationAttachmentService extends IService<DeclarationAttachment>{
    /**
     * 获取申报附件列表
     * @param id
     * @return
     */
    List getList(Integer id) throws Exception;
}
