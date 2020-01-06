package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 消息通知Service
 *
 * @author monkey
 * @Date 2018-09-13 14:06:25
 */
public interface IMessageService extends IService<Message>{

    /**
     * 查询用户所有消息通知
     * @param messageUserId
     * @return
     */
    Page<List<Message>> selectMessages(@Param("messageUserId") int messageUserId, int size, int curPage);

    /**
     * @Description: 获取用户消息通知分类列表(催报、系统、认证)
     * @return: com.baomidou.mybatisplus.plugins.Page<java.util.List < com.youedata.nncloud.modular.nanning.model.Message>>
     * @Author: fxh
     * @Date: 2018/11/27
     **/
    Page<List<Message>> listByUserType(@Param("messageUserId") int messageUserId, @Param("messageType") String messageType, int size, int curPage);



    /**
     * @Description: 消息通知主页面查询（显示4种细分类的最新一条消息）
     * @return: 
     * @Author: fxh
     * @Date: 2018/12/4
     **/
    List<Map<String,String>> listHome(@Param("messageUserId") int messageUserId);

    void updateReadFlag(@Param("message")  Message message);


    int unReadCount(@Param("messageUserId") int messageUserId, @Param("messageType") String messageType);

}
