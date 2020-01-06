package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.Flag;
import com.youedata.nncloud.modular.nanning.model.Log;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  标识 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface LogMapper extends BaseMapper<Log> {

//    List<Attachment> getByQuestionId(@Param("questionId") Integer questionId);
//    List<Flag> selectAll();
//
//    int updateAll();
}
