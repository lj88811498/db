package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.ResumeMapper;
import com.youedata.nncloud.modular.nanning.model.Resume;
import com.youedata.nncloud.modular.nanning.model.vo.ResumeListVo;
import com.youedata.nncloud.modular.nanning.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 个人求职Service
 *
 * @author Monkey
 * @Date 2018-11-23 17:04:49
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class ResumeServiceImpl extends ServiceImpl<BaseMapper<Resume>, Resume> implements IResumeService {

    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public Resume selectByResumeUserId(Integer resumeUserId) {
        Resume entity = new Resume();
        entity.setResumeUserId(resumeUserId);
        return resumeMapper.selectOne(entity);
    }

    @Override
    public Page getAllPageList(int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<ResumeListVo> result = resumeMapper.getAllPageList(page);
        page.setRecords(result);
        return page;
    }

    @Override
    public Page getListByParam(int size, int curPage, String name, Integer sex, Integer marriage, Integer age, Integer edu, Integer nature, Integer experience, Integer industry, Integer job) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        String kk="\"\"";
        if(kk.equals(name))
        {
            name=null;
        }
        List<ResumeListVo> result = resumeMapper.getListBySearchParam(page, name, sex, marriage, age, edu, nature, experience, industry, job);
        page.setRecords(result);
        return page;
    }
}
