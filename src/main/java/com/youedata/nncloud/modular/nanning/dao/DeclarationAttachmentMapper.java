package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.DeclarationAttachment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申报附件 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@Transactional
@Component
public interface DeclarationAttachmentMapper extends BaseMapper<DeclarationAttachment> {

    /**
     * 获取附件列表
     * @param id
     * @return
     */
    List<DeclarationAttachment> getList(@Param("id") Integer id);
    /**
     * 获取企业图片
     */
    DeclarationAttachment getAttachment(@Param("id") Integer id);
}
