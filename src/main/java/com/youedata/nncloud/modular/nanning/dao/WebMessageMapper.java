package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.youedata.nncloud.modular.nanning.model.WebMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.WebMessageListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统通知 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@Transactional
@Component
public interface WebMessageMapper extends BaseMapper<WebMessage> {
    /**
     * 查询分页接口
     * @param page
     * @param context 内容
     * @param state 状态(非必填)(0:草稿,1:未发送,2:已发送)注：如果没选不要传
     * @return
     */
    List<Map<String, Object>> selectMessageListPage(@Param("page")Page page, @Param("context")String context, @Param("state") Integer state);

    List<WebMessage> getWebMessageInOneHour();
}
