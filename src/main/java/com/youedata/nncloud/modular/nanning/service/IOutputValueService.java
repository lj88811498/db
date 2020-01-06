package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.OutputValue;

import java.util.Date;
import java.util.Map;

/**
 * @author sunjian
 * @Date 2018/12/12
 */
public interface IOutputValueService extends IService<OutputValue> {

    /**
     * 获取重点企业信息
     * @param date 日期
     * @param minValue 最小产值
     * @param maxValue 最大产值
     * @param size
     * @param curPage
     * @return
     */
    Map getData(Date date, Integer minValue, Integer maxValue, int size, int curPage);

    /**
     * 获取年产值根据企业id和年月时间
     * @param industryEnterpriseId
     * @param industryYear
     * @return
     */
    Double getAnnualOutputValue(String industryEnterpriseId, Integer industryYear);
}
