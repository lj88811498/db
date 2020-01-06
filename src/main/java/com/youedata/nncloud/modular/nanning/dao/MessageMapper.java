package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Message;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 消息通知 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-13
 */
@Transactional
@Component
public interface MessageMapper extends BaseMapper<Message> {

    /**
     * 查询用户所有消息通知
     * @param messageUserId
     * @return
     */
    List<Message> selectMessages(@Param("page") Page page, @Param("messageUserId") int messageUserId);


    List<Message> selectMessages(@Param("messageUserId") int messageUserId);


    /**
     * @Description: 分页 获取用户消息通知分类列表(催报、系统、认证)
     * @return: java.util.List<com.youedata.nncloud.modular.nanning.model.Message>
     * @Author: fxh
     * @Date: 2018/11/27
     **/
    List<Message> listByUserType(@Param("page") Page page, @Param("messageUserId") int messageUserId, @Param("messageType") String messageType);

    List<Map> listHome(@Param("messageUserId") int messageUserId, @Param("messageType") String messageType);




    void updateReadFlag(@Param("message")  Message message);

}
