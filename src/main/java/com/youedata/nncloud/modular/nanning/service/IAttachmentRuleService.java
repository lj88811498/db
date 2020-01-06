package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.AttachmentRule;

import java.util.List;

/**
 * 项目类型附件规则Service
 *
 * @author HuangKai
 * @Date 2018-12-07 13:32:42
 */
public interface IAttachmentRuleService extends IService<AttachmentRule>{

    /**
     * 附件规则列表
     * @param id
     * @return
     */
    Page gitList(Integer id,int size, int curPage);

    /**
     *通过id获取数据
     * @param id
     * @return
     */
    AttachmentRule getById(Integer id);

    /**
     * 通过关联项目id查询数据
     * @param id
     * @return
     */
    List<AttachmentRule> getByDeclarationId(Integer id);

}
