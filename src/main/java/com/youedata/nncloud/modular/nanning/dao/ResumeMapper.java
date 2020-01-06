package com.youedata.nncloud.modular.nanning.dao;


import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Resume;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.ResumeListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 个人求职 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-23
 */
@Transactional
@Component
public interface ResumeMapper extends BaseMapper<Resume> {
    /**
     * 获取个人求职信息的列表
     * @return
     */
    List<ResumeListVo> getAllPageList(Page page);

    List<ResumeListVo> getListBySearchParam(Page page, @Param("name") String name, @Param("sex")Integer sex, @Param("marriage")Integer marriage, @Param("age")Integer age, @Param("edu")Integer edu, @Param("nature")Integer nature, @Param("experience")Integer experience, @Param("industry")Integer industry, @Param("job")Integer job);
}
