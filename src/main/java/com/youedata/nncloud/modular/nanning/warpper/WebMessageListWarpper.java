package com.youedata.nncloud.modular.nanning.warpper;

import com.youedata.nncloud.core.base.warpper.BaseControllerWarpper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 系统通知列表的包装
 *
 * @author Tangcheng
 * @date 2018年11月30日10:53:37
 */
public class WebMessageListWarpper extends BaseControllerWarpper {

    private final static String WEB_MESSAGE_STATES="webMessageStates";
    private final static String WEB_MESSAGE_SENDTIME="webMessageSendTime";
    public WebMessageListWarpper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        if (map.containsKey(WEB_MESSAGE_STATES) && map.containsKey(WEB_MESSAGE_SENDTIME)) {
            Integer state = (Integer) map.get(WEB_MESSAGE_STATES);
            Date date = (Date) map.get(WEB_MESSAGE_SENDTIME);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            if (state != 0) {
                Date now = new Date();
                if (now.before(date)) {
                    map.put(WEB_MESSAGE_STATES, 1);
                } else {
                    map.put(WEB_MESSAGE_STATES, 2);
                }
            }
        }
    }
}
