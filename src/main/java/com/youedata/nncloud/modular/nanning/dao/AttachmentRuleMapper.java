package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.AttachmentRule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.internal.util.privilegedactions.GetConstraintValidatorList;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 附件规则 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-12-07
 */
@Transactional
@Component
public interface AttachmentRuleMapper extends BaseMapper<AttachmentRule> {

    /**
     * 规则列表
     * @param id
     * @return
     */
    List<AttachmentRule> getList(@Param("id") Integer id);

    /**
     * 通过主键id获取信息
     * @param id
     * @return
     */
    AttachmentRule getById(@Param("id") Integer id);

    /**
     * 通过关联项目id查询数据
     * @param id
     * @return
     */
    List<AttachmentRule> getByDeclarationId(@Param("id") Integer id);
}
