package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Resume;
/**
 * 个人求职Service
 *
 * @author Monkey
 * @Date 2018-11-23 17:04:49
 */
public interface IResumeService extends IService<Resume>{
    /**
     * 根据用户id获取个人求职详情
     * @param resumeUserId 用户id
     * @return Resume
     */
    Resume selectByResumeUserId(Integer resumeUserId);

    /**
     * 获取用户个人求职列表
     * @param size 每页的条数
     * @param curPage 当前页数
     * @return Page
     */
    Page getAllPageList(int size, int curPage);

    /**
     * 搜索个人求职信息
     * @param size 每页的条数
     * @param curPage 当前页数
     * @param name 姓名
     * @param sex 性别
     * @param marriage 婚姻状况
     * @param age 年龄
     * @param edu 学历
     * @param nature 工作性质
     * @param experience 工作经验
     * @param industry 行业意向
     * @param job 职位意向
     * @return Page
     */
    Page getListByParam(int size, int curPage,String name,Integer sex,Integer marriage,Integer age,Integer edu,Integer nature,Integer experience,Integer industry,Integer job);
}
