package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.EmpInfo;
/**
 * 招聘信息Service
 *
 * @author lee
 * @Date 2018-11-28 15:10:06
 */
public interface IEmpInfoService extends IService<EmpInfo>{
    /**
     * 获取列表
     * @param title
     * @param industry
     * @param positionType
     * @param area
     * @param property
     * @param education
     * @param experience
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getList(String title, String industry, String positionType, String area, String property, String education, String experience, String orderByField, boolean isAsc, int size, int curPage);

}
