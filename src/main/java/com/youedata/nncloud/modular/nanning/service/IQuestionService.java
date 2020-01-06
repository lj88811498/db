package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionPojo;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionVo;
import com.youedata.nncloud.modular.nanning.model.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import java.util.Date;
import java.util.List;

/**
 * 问题反馈Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 添加留言
     *
     * @Author: Monkey
     * @Param: [questionId, questionUserId, questionUserName, questionContent,type]
     * @Date: Created in  2018/9/12 14:23.
     * @Returns void
     */
    void addQuestionBoard(@Param("file") MultipartFile[] file,
                          @Param("questionId") int questionId,
                          @Param("questionUserId") int questionUserId,
                          @Param("questionUserName") String questionUserName,
                          @Param("questionContent") String questionContent,
                          @Param("type") boolean type,
                          @Param("questionFlag") String questionFlag) throws Exception;

//    /**
//     * 添加回复问题
//     * @param msg
//     * @param questionId
//     * @param questionOfficeId
//     * @param officeName
//     * @param answerQuestionUserId
//     * @param pro
//     * @throws Exception
//     */
//    int addAnswerQuestion(String msg, int questionId, int questionOfficeId,
//                          String officeName, int answerQuestionUserId,
//                          String questionUserName, String pro) throws Exception;

    /**
     * 反馈问题列表-企业端
     *
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getListByUserId(int userId, String title, String type, String beginTime, String endTime, String progress, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 反馈问题列表-政府端
     *
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getListByProgress(String status, String orderByField, boolean isAsc, int size, int curPage, int questionUserId, String title, String type, String beginTime, String endTime, String progress) throws Exception;

    /**
     * 问题详情
     *
     * @param questionId
     * @return
     */
    QuestionPojo getById(Integer questionId, Integer userId) throws Exception;

    /**
     * 审核、受理、转交、自行答复等通用接口
     *
     * @param questionId
     * @param questionProgress
     * @param questionErrorMsg
     * @return
     */
    boolean update(int questionId, int answerQuestionUserId, int questionOfficeId, String questionProgress, String questionErrorMsg) throws Exception;

    /**
     * 当月问题件数
     *
     * @return
     */
    Integer getMonthCount(String date);

    /**
     * 当月问题解决件数
     *
     * @return
     */
    Integer getMonthSolveCount(String date, Integer serviceId);

    /**
     * 问题解决平均天数
     *
     * @return
     */
    Double getSolveDayAvg(String date, Integer serviceId);

    /**
     * 委办局解决问题排序
     *
     * @return
     */
    List<QuestionVo> getOfficeSort(String date);

    /**
     * 当月新增问题统计
     *
     * @param date
     * @return
     */
    String getMonthNewCountList(String date);

    /**
     * 当月解决问题统计
     *
     * @param date
     * @return
     */
    String getMonthSolveCountList(String date);

    /**
     * 政府端查询处理的反馈
     *
     * @param userId
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getMyQuestinoByUserId(int userId, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 查询公开问题
     *
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getListByPublic(String questionTitle,String privilege, String orderByField, boolean isAsc, int size, int curPage, String questionType, String questionProgress, String questionCreateTimeBegin, String questionCreateTimeEnd);

    /**
     * 查询热门问题
     *
     * @return
     */
    List<Object> totalHotQuestion();

    String[] addFiles(MultipartFile[] file, int questionId) throws Exception;

    /**
     * 公开公示置顶
     * @param question
     */
    void setTop(Question question);

    /**
     * 查询最后一个回复人
     * @param questionUserId
     * @param questionId
     * @return
     */
    Question selectQuestionAnswer(int questionUserId, int questionId);
}
