package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.modular.nanning.dao.DegreeMapper;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Degree;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IDegreeService;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * 满意度Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class DegreeServiceImpl extends ServiceImpl<BaseMapper<Degree>,Degree> implements IDegreeService {
    @Resource
    private DegreeMapper degreeMapper;

    /**
     * 整体满意度
     * @return
     */
    @Override
    public int getMainAvg(String date, Integer serviceId) {
        Double doubleData = degreeMapper.getMainAvg(date, serviceId);
        return dataMath(doubleData);
    }

    /**
     * 客服回复满意度
     * @return
     */
    @Override
    public int getAnswerAvg(String date, Integer serviceId) {
        Double doubleData = degreeMapper.getAnswerAvg(date, serviceId);
        return dataMath(doubleData);
    }

    /**
     * 客服工作态度满意度
     * @return
     */
    @Override
    public int getWorkAvg(String date, Integer serviceId) {
        Double doubleData = degreeMapper.getWorkAvg(date, serviceId);
        return dataMath(doubleData);
    }

    /**
     * 委办局满意度
     * @param date
     * @param serviceId
     * @return
     */
    @Override
    public int getOfficeAvg(String date, Integer serviceId) {
        Double doubleData = degreeMapper.getOfficeAvg(date, serviceId);
        return dataMath(doubleData);
    }


    private int dataMath(Double doubleData){
        if(doubleData != null){
            BigDecimal a1 = new BigDecimal(Double.toString(doubleData));
            BigDecimal b1 = new BigDecimal(Double.toString(100));
            BigDecimal result = a1.multiply(b1);
            return result.intValue();
        } else {
            return 0;
        }
    }

    /**
     * 根据问题id和用户id查询
     * @param questionId
     * @param userId
     * @return
     */
    @Override
    public Degree getByUserIdAndQuestionId(Integer questionId, Integer userId) {
        return degreeMapper.getByUserIdAndQuestionId(questionId,userId);
    }
}
