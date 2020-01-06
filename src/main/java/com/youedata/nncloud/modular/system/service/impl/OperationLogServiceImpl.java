package com.youedata.nncloud.modular.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.util.ToolUtil;
import com.youedata.nncloud.modular.nanning.dao.UserInfoMapper;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.youedata.nncloud.modular.system.dao.OperationLogMapper;
import com.youedata.nncloud.modular.system.model.OperationLog;
import com.youedata.nncloud.modular.system.service.IOperationLogService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-02-22
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

    @Autowired
    OperationLogMapper operationLogMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<Map<String, Object>> getOperationLogs(Page<OperationLog> page, String beginTime, String endTime, String logName, String s, String orderByField, boolean asc) {
        return this.baseMapper.getOperationLogs(page, beginTime, endTime, logName, s, orderByField, asc);
    }

    /**
     * 获取操作日志
     *
     * @param userInfoName
     * @param beginTime
     * @param endTime
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getLogList(String userInfoName, String beginTime, String endTime, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        Map map1 = new HashedMap();
        if (!ToolUtil.isEmpty(userInfoName)) {
            map1.put("user_info_name", userInfoName);
            map1.put("user_info_type", "2");
            List list = userInfoMapper.selectByMap(map1);
            if (list.size() != 0) {

                UserInfo userInfo = (UserInfo) list.get(0);
                List<Map<String, Object>> result = operationLogMapper.getLogList(userInfo.getUserInfoId(), beginTime, endTime, page, orderByField, isAsc);
                for (Map map : result) {
                    userInfoName = userInfoMapper.selectNameById(Integer.parseInt(map.get("userid").toString()));
                    map.put("userInfoName", userInfoName);
                }
                page.setRecords(result);
                return page;
            } else {
                List<Map<String, Object>> result = null;
                page.setRecords(result);
                return page;
            }
        } else {
            List<Map<String, Object>> result = operationLogMapper.getLogList(null, beginTime, endTime, page, orderByField, isAsc);
            for (Map map : result) {
                userInfoName = userInfoMapper.selectNameById(Integer.parseInt(map.get("userid").toString()));
                map.put("userInfoName", userInfoName);
            }
            page.setRecords(result);
            return page;
        }


    }
}
