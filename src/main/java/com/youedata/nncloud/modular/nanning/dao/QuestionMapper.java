package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionListVo;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionPojo;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionVo;
import com.youedata.nncloud.modular.nanning.model.Question;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 问题反馈 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 添加留言
     *
     * @Author: Monkey
     * @Param: [question]
     * @Date: Created in  2018/9/12 14:23.
     * @Returns void
     */
    void addQuestionBoard(Question question);

    /**
     * 返回问题列表-企业端
     *
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<QuestionListVo> getListByUserId(@Param("userId") int userId,
                                         @Param("title") String title,
                                         @Param("type") String type,
                                         @Param("beginTime") String beginTime,
                                         @Param("endTime") String endTime,
                                         @Param("progress") String progress,
                                         @Param("page") Page page,
                                         @Param("orderByField") String orderByField,
                                         @Param("isAsc") boolean isAsc);

    /**
     * 返回问题列表-政府端
     *
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<QuestionListVo> getListByProgress(@Param("page") Page page,
                                           @Param("orderByField") String orderByField,
                                           @Param("isAsc") boolean isAsc,
                                           @Param("progressList") List progressList,
                                           @Param("flag") boolean flag,
                                           @Param("questionUserId") int questionUserId,
                                           @Param("title") String title,
                                           @Param("type") String type,
                                           @Param("beginTime") String beginTime,
                                           @Param("endTime") String endTime,
                                           @Param("progress") String progress);

    /**
     * 问题详情
     *
     * @param questionPid
     * @return
     */
    List<Question> getChildByPid(@Param("questionPid") Integer questionPid);

    /**
     * 问题详情
     *
     * @param questionPid
     * @return
     */
    List<QuestionPojo> getPojoChildByPid(@Param("questionPid") Integer questionPid);

    /**
     * 问题详情
     *
     * @param questionId
     * @return
     */
    Question getById(@Param("questionId") Integer questionId, @Param("userId") Integer userId);

    /**
     * 查询问题的进度
     *
     * @param questionId
     * @return
     */
    String selectQuestionProgress(@Param("questionId") int questionId);

    /**
     * 当月问题件数
     *
     * @return
     */
    Integer getMonthCount(@Param("date") String date);

    /**
     * 当月问题解决件数
     *
     * @return
     */
    Integer getMonthSolveCount(@Param("date") String date, @Param("serviceId") Integer serviceId);

    /**
     * 问题解决平均天数
     *
     * @return
     */
    Double getSolveDayAvg(@Param("date") String date, @Param("serviceId") Integer serviceId);

    /**
     * 委办局解决问题排名
     *
     * @return
     */
    List<QuestionVo> getOfficeSort(@Param("date") String date);

    /**
     * 当月新增问题统计
     *
     * @param date
     * @return
     */
    String getMonthNewCountList(@Param("date") String date);

    /**
     * 当月解决问题统计
     *
     * @param date
     * @return
     */
    String getMonthSolveCountList(@Param("date") String date);

    /**
     * 根据收藏userId查询
     *
     * @param userId
     * @return
     */
    List<QuestionListVo> getByCollentUserId(@Param("page") Page page,
                                            @Param("orderByField") String orderByField,
                                            @Param("isAsc") boolean isAsc,
                                            @Param("userId") Integer userId,
                                            @Param("title") String title,
                                            @Param("type") String type,
                                            @Param("beginTime") String beginTime,
                                            @Param("endTime") String endTime,
                                            @Param("progress") String progress);

    /**
     * .政府端查询处理的反馈
     *
     * @param page
     * @param orderByField
     * @param isAsc
     * @param userId
     * @return
     */
    List<QuestionListVo> getMyQuestinoByUserId(@Param("page") Page page,
                                               @Param("orderByField") String orderByField,
                                               @Param("isAsc") boolean isAsc,
                                               @Param("userId") Integer userId);

    /**
     * 查询公开问题
     *
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<QuestionListVo> getListByPublic(
                                         @Param("questionTitle")String questionTitle,
                                         @Param("privilege") String privilege,
                                         @Param("page") Page page,
                                         @Param("orderByField") String orderByField,
                                         @Param("isAsc") boolean isAsc,
                                         @Param("type")String questionType,
                                         @Param("progress")String questionProgress,
                                         @Param("beginTime")String questionCreateTimeBegin,
                                         @Param("endTime")String questionCreateTimeEnd);

    /**
     * 查询单个问题
     *
     * @param questionId
     * @return
     */
    Question selectOneById(@Param("questionId") int questionId);


    /**
     * 判断用户是否有对应问题
     *
     * @param userId
     * @return
     */
    Integer getUserQuestion(@Param("userId") int userId);

    /**
     * 查询热门问题
     *
     * @param page
     * @return
     */
    List<Object> totalHotQuestion(@Param("page") Page page);

    /**
     * 查询用户权限
     *
     * @param questionUserId
     * @param questionId
     * @return
     */
    String selectAuth(@Param("questionUserId") int questionUserId,
                      @Param("questionId") int questionId);

    /**
     * 查询最后一个回复人
     * @param questionUserId
     * @param questionId
     * @return
     */
    Question selectQuestionAnswer(@Param("questionUserId") int questionUserId,
                                  @Param("questionId") int questionId);
}
