package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.WebMessage;
import com.youedata.nncloud.modular.nanning.model.vo.WebMessageListVo;

import java.util.List;
import java.util.Map;

/**
 * 系统通知Service
 *
 * @author Tancgheng
 * @Date 2018-11-28 09:20:59
 */
public interface IWebMessageService extends IService<WebMessage> {

    /**
     * 获取当前时间的整点，返回该整点时间的系统通知细信息
     *
     * @return
     */
    List<WebMessage> getCurrentInOneHour();

    /**
     * 查询分页接口
     * @param size 每页条数
     * @param curPage 页数
     * @param context 内容
     * @param state 状态(非必填)(0:草稿,1:未发送,2:已发送)注：如果没选不要传
     * @return
     */
    Page<List<Map<String, Object>>> selectMessageListPage(int size, int curPage, String context, Integer state);
}
