package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.OutputValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author sunjian
 * @Date 2018/12/14
 */
@Transactional
@Component
public interface OutputValueMapper extends BaseMapper<OutputValue> {

    /**
     * 获取重点企业信息
     * @param date 日期（格式yyyyMM）
     * @param minValue 最小产值
     * @param maxValue 最大产值
     * @param page
     * @return
     */
    List<Map> getList(@Param("date") Integer date, @Param("minValue") Integer minValue, @Param("maxValue") Integer maxValue, @Param("page") Page page);

    /**
     * 获取区县分布
     * @return
     */
    List<Map> getRegionList(@Param("date") Integer date, @Param("minValue") Integer minValue, @Param("maxValue") Integer maxValue);

    /**
     * 获取企业性质
     * @return
     */
    List<Map> getTypeList(@Param("date") Integer date, @Param("minValue") Integer minValue, @Param("maxValue") Integer maxValue);


    /**
     * @Description:获取重点企业信息列表及排名
     * @return:
     * @Author: fxh
     * @Date: 2018/12/17
     **/
    Map getListByRank(@Param("userId") int userId , @Param("yearMonth") String yearMonth);


    List<Map> getAllList();
}
