package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.ProjectDeclaration;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目申报表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface ProjectDeclarationMapper extends BaseMapper<ProjectDeclaration> {

    /**
     * 获取项目类型列表
     * @return
     */
    List<Map> getList();
}
