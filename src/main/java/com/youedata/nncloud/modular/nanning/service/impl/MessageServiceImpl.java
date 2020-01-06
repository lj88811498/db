package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.MessageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Message;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IMessageService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 消息通知Service
 *
 * @author monkey
 * @Date 2018-09-13 14:06:25
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class MessageServiceImpl extends ServiceImpl<BaseMapper<Message>,Message> implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询用户所有消息通知
     *
     * @param messageUserId
     * @return
     */
    @Override
    public Page<List<Message>> selectMessages(int messageUserId, int size, int curPage) {
        Page page = new PageFactory<>().defaultPage2(size, curPage);
        List<Message> results = messageMapper.selectMessages(page, messageUserId);
        page.setRecords(results);
        return page;
    }


    /**
     * @Description: 消息通知主页面查询（显示4种细分类的最新一条消息）
     * @return: 
     * @Author: fxh
     * @Date: 2018/12/4
     **/
    @Override
    public List<Map<String,String>> listHome(int messageUserId) {

        List<Map<String,String>> retList = new ArrayList<>();
        List<Map> mapList;
        Map<String,String> map;
        Map<String,String> messageMap;

        //消息类型:1.问题反馈，2.催报通知，3.系统通知，4.认证通知
        for(int i = 1; i < 5; i++){
            mapList = new ArrayList<>();
            map = new HashMap<String,String>();
            mapList = messageMapper.listHome(messageUserId, String.valueOf(i));
            if(ObjectUtils.isEmpty(mapList)){
                map.put("messageUserId",String.valueOf(messageUserId));
                map.put("messageType",String.valueOf(i));
                map.put("messageReadFlag","");
                map.put("messageQuestionId","");
                map.put("messageQuestionCode","");
                map.put("messageId","");
                map.put("messageCreateTime","");
                map.put("messageContent","");
            }else{
                messageMap = mapList.get(0);
                map.put("messageUserId",String.valueOf(messageMap.get("messageUserId")));
                map.put("messageType",String.valueOf(i));
                map.put("messageReadFlag",messageMap.get("messageReadFlag"));
                map.put("messageQuestionId",String.valueOf(messageMap.get("messageQuestionId")));
                map.put("messageQuestionCode",String.valueOf(messageMap.get("messageQuestionCode")));
                map.put("messageId",String.valueOf(messageMap.get("messageId")));
                //map.put("messageCreateTime",String.valueOf(messageMap.get("messageCreateTime")));
                map.put("messageContent",messageMap.get("messageContent"));


                String res;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = simpleDateFormat.parse(String.valueOf(messageMap.get("messageCreateTime")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long ts = date.getTime();
                res = String.valueOf(ts);


                map.put("messageCreateTime",res);

            }
            //分类未读消息数
            int count = unReadCount(messageUserId,String.valueOf(i));
            map.put("unReadCount",String.valueOf(count));
            retList.add(map);
        }
        return retList;
    }


    @Override
    public int unReadCount(int messageUserId, String messageType) {
        Map map = new HashMap();
        map.put("message_user_id",messageUserId);
        map.put("message_read_flag","0");
        if(!StringUtils.isEmpty(messageType)){
            map.put("message_type",messageType);
        }
        List<Message> list = selectByMap(map);
        if (ObjectUtils.isEmpty(list)){
            return 0;
        }else{
            return list.size();
        }
    }

    /**
     * @Description: 获取用户消息通知分类列表(催报、系统、认证)
     * @return: com.baomidou.mybatisplus.plugins.Page<java.util.List < com.youedata.nncloud.modular.nanning.model.Message>>
     * @Author: fxh
     * @Date: 2018/11/27
     **/
    @Override
    public Page<List<Message>> listByUserType(int messageUserId, String messageType, int size, int curPage) {
        Page page = new PageFactory<>().defaultPage2(size, curPage);
        List<Message> results = messageMapper.listByUserType(page, messageUserId, messageType);
        page.setRecords(results);
        return page;
    }

    @Override
    public void updateReadFlag(Message message) {
        messageMapper.updateReadFlag(message);
    }
}
