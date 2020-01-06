package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.config.properties.GunsProperties;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.common.constant.state.QuestionAutoAnswer;
import com.youedata.nncloud.core.common.constant.state.QuestionProgress;
import com.youedata.nncloud.core.constant.Constant;
import com.youedata.nncloud.core.util.BeanUtil;
import com.youedata.nncloud.core.util.DateUtil;
import com.youedata.nncloud.core.util.RecordLogUtil;
import com.youedata.nncloud.core.util.UploadUtil;
import com.youedata.nncloud.modular.nanning.dao.*;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionListVo;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionPojo;
import com.youedata.nncloud.modular.nanning.model.vo.QuestionVo;
import com.youedata.nncloud.modular.nanning.model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IQuestionService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;


/**
 * 问题反馈Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class QuestionServiceImpl extends ServiceImpl<BaseMapper<Question>, Question> implements IQuestionService {

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private OfficeMapper officeMapper;

    /**
     * 添加留言
     *
     * @param file
     * @param questionId
     * @param questionUserId
     * @param questionUserName
     * @param questionContent
     * @Author: Monkey
     * @Param: [file, questionId, questionUserId, questionUserName, questionContent]
     * @Date: Created in  2018/9/12 14:23.
     * @Returns void
     */
    @Override
    public void addQuestionBoard(@Param("file") MultipartFile[] file,
                                 @Param("questionId") int questionId,
                                 @Param("questionUserId") int questionUserId,
                                 @Param("questionUserName") String questionUserName,
                                 @Param("questionContent") String questionContent,
                                 @Param("type") boolean type,
                                 @Param("questionFlag") String questionFlag) throws Exception {
        UserInfo userInfo = null;
        if (questionId == 0 || questionUserId == 0 || StringUtils.isBlank(questionUserName)) {
            if (file == null && questionId == 0) {
                throw new Exception("信息填写不完整！");
            }
        } else {
            UserInfo user = new UserInfo();
            user.setUserInfoId(questionUserId);
            userInfo = userInfoMapper.selectOne(user);
            if (userInfo == null) {
                throw new Exception("用户信息填写错误！");
            }
        }
        if (userInfo == null) {
            userInfo = userInfoMapper.selectById(questionUserId);
        }
        if (userInfo != null && !type) {
            questionUserName = userInfo.getUserInfoNickname();
        }
        Question question = new Question(questionId, questionUserId, questionUserName, questionContent);
        int t_questionId;
        if (type) {
            if (userInfo == null) {
                userInfo = userInfoMapper.selectById(questionUserId);
            }
            if (StringUtils.isBlank(questionUserName) && userInfo != null) {
                questionUserName = userInfo.getUserInfoNickname();
            } else if (userInfo == null) {
                throw new Exception("用户不存在！");
            }
            //自行答复，回复人是客服，否则回复人是委办局
            if ("0".equals(questionFlag)) {
                questionUserName = userInfo.getUserInfoNickname();
            }

            int officeId = officeMapper.selectOfficeByName(questionUserName);
            t_questionId = addAnswerQuestion(questionContent, questionId, officeId, null, questionUserId, questionUserName, Constant.PROGRESS_FIVE);
        } else {
            questionMapper.addQuestionBoard(question);
            t_questionId = question.getQuestionId();
        }

        if (t_questionId == 0) {
            throw new Exception("问题提交失败！");
        }

        //添加附件
        addFiles(file, t_questionId);

        RecordLogUtil.info("附件参数： file=" + file);
    }

    /**
     * 添加附件
     *
     * @param file
     * @param t_questionId
     * @throws Exception
     */
    @Override
    public String[] addFiles(MultipartFile[] file, int t_questionId) throws Exception {
        String[] url = new String[0];
        if (file != null) {
            url = new String[file.length];
            String serverPath = gunsProperties.getFileUploadPath();
            String folderPath = Constant.FILE_SEPARATOR + DateUtil.getDays() + Constant.FILE_SEPARATOR;
            for (int i = 0; i < file.length; i++) {
                MultipartFile temp = file[i];
                if (temp != null) {
                    String picName = temp.getOriginalFilename();
                    String suffix = picName.substring(picName.lastIndexOf("."));
                    String tempName = System.currentTimeMillis() + suffix;
                    UploadUtil.uploadFile(temp, serverPath + folderPath, tempName);

                    //设置地址, 用来返回数组1
                    url[i] = folderPath + tempName;
                    Attachment attachment = new Attachment();
                    attachment.setAttachmentName(picName);
                    attachment.setAttachmentUrl(folderPath + tempName);
                    attachment.setAttachmentQuestionId(t_questionId);
                    attachmentMapper.insert(attachment);
                }
            }
        }
        return url;
    }

    /**
     * 反馈问题列报表
     *
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getListByUserId(int userId, String title, String type, String beginTime, String endTime, String progress, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<QuestionListVo> result = questionMapper.getListByUserId(userId, title, type, beginTime, endTime, progress, page, orderByField, isAsc);
        page.setRecords(result);
        return page;
    }

    /**
     * 反馈问题列报表
     *
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getListByProgress(String Status, String orderByField, boolean isAsc, int size, int curPage, int questionUserId, String title, String type, String beginTime, String endTime, String progress) throws Exception {
        if (questionUserId == 0) {
            throw new Exception("用户不存在");
        }

        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List progressList = new ArrayList<>();
        boolean flag = false;
        //0待处理  1处理中  2已处理
        String[] pros = {"0,1", "2,3,4,5", "6,7,8,9"};
        String tempProgress = pros[Integer.parseInt(Status)];
        String p[] = tempProgress.split(",");
        progressList = Arrays.asList(p);
        if (Constant.QUESTION_AUTO_ANSWER.equals(Status)) {
            flag = true;
        }
        List<QuestionListVo> result = questionMapper.getListByProgress(page, orderByField, isAsc, progressList, flag, questionUserId, title, type, beginTime, endTime, progress);
        page.setRecords(result);
        return page;
    }

//    /**
//     * 问题详情
//     * @param questionId
//     * @return
//     */
//    @Override
//    public Question getById(Integer questionId, Integer userId) {
//        Page page =  new Page();
//        //留言
//        Question question = questionMapper.getById(questionId, userId);
//        List<Attachment> attachments = attachmentMapper.getByQuestionId(questionId);
//        setAttachmentUrl(attachments);
//        question.setAttachmentList(attachments);
//        //回复
//        List<Question> questionsChild = questionMapper.getChildByPid(question.getQuestionId());
//        for(int i = 0 ; i < questionsChild.size() ; i++){
//            List<Attachment> attachmentsChild = attachmentMapper.getByQuestionId(questionsChild.get(i).getQuestionId());
//            setAttachmentUrl(attachmentsChild);
//            questionsChild.get(i).setAttachmentList(attachmentsChild);
//        }
//        question.setChildList(questionsChild);
//
////        结果集封装为list
//        return question;
//
//    }

    /**
     * 获取用户头像
     *
     * @param userId
     * @return
     */
    private String getUserUrl(int userId) {
        UserInfo user = new UserInfo();
        user.setUserInfoId(userId);
        UserInfo userInfo = userInfoMapper.selectOne(user);
        String url = "";
        if (userInfo != null) {
            url = gunsProperties.getFileServerPath() + userInfo.getUserInfoUrl();
        }
        return url;
    }

    /**
     * 问题详情
     *
     * @param questionId
     * @return
     */
    @Override
    public QuestionPojo getById(Integer questionId, Integer userId) throws Exception {
        QuestionPojo qp = new QuestionPojo();
        //留言
        Question question = questionMapper.getById(questionId, userId);
        if (question == null) {
            throw new Exception("未找到该问题详情！");
        }
        BeanUtils.copyProperties(question, qp);
        qp.setQuestionUserUrl(getUserUrl(qp.getQuestionUserId()));
        List<Attachment> attachments = attachmentMapper.getByQuestionId(questionId);
        setAttachmentUrl(attachments);
        qp.setAttachmentList(attachments);
        //question.setAttachmentList(attachments);
        //回复
        List<QuestionPojo> questionsChild = questionMapper.getPojoChildByPid(question.getQuestionId());
        for (int i = 0; i < questionsChild.size(); i++) {
            QuestionPojo pojo = questionsChild.get(i);
            List<Attachment> attachmentsChild = attachmentMapper.getByQuestionId(pojo.getQuestionId());
            setAttachmentUrl(attachmentsChild);
            pojo.setAttachmentList(attachmentsChild);
            pojo.setQuestionUserUrl(getUserUrl(pojo.getQuestionUserId()));
        }
        qp.setChildList(questionsChild);

        if (userId != null) {
            String auth = questionMapper.selectAuth(userId, questionId);
            qp.setQuestionAuth(auth);
        } else {
            //没传用户id为0
            qp.setQuestionAuth(Constant.PROGRESS_ZORE);
        }
//        结果集封装为list
        return qp;

    }

    /**
     * 审核、受理、转交、自行答复等通用接口
     *
     * @param questionId
     * @param questionProgress
     * @param questionErrorMsg
     * @return
     */
    @Override
    public boolean update(int questionId, int answerQuestionUserId, int questionOfficeId, String questionProgress, String questionErrorMsg) throws Exception {

        Question tempQuestion = questionMapper.selectOneById(questionId);
        String temp = tempQuestion.getQuestionProgress();
        boolean flag = false;
        String pro = questionProgress;
        //此处有多种情况
        //审核
        if (questionProgress.equals(Constant.PROGRESS_ONE)) {
            if (!temp.equals(Constant.PROGRESS_ZORE)) {
                flag = true;
            }
        }
        //受理
        else if (questionProgress.equals(Constant.PROGRESS_TWO)) {
            if (!temp.equals(Constant.PROGRESS_ONE)) {
                flag = true;
            }
        }
        //已转交相关部门 和 自行答复
        else if (questionProgress.equals(Constant.PROGRESS_THREE) || temp.equals(Constant.PROGRESS_FOUR)) {
            if (!(temp.equals(Constant.PROGRESS_TWO) || temp.equals(Constant.PROGRESS_THREE)
                    || temp.equals(Constant.PROGRESS_FOUR) || temp.equals(Constant.PROGRESS_FIVE))) {
                flag = true;
            } else if (temp.equals(Constant.PROGRESS_FIVE)) {
                questionProgress = temp;
            }
        }
        //等待用户确认
        else if (questionProgress.equals(Constant.PROGRESS_FIVE)) {
            if (!(temp.equals(Constant.PROGRESS_TWO) || temp.equals(Constant.PROGRESS_THREE) || temp.equals(Constant.PROGRESS_FOUR))) {
                flag = true;
            }
        }
        //等待用户评价
        else if (questionProgress.equals(Constant.PROGRESS_SIX)) {
            if (!(temp.equals(Constant.PROGRESS_TWO) || temp.equals(Constant.PROGRESS_THREE)
                    || temp.equals(Constant.PROGRESS_FOUR) || temp.equals(Constant.PROGRESS_FIVE))) {
                flag = true;
            }
        }
        //已评价
        else if (questionProgress.equals(Constant.PROGRESS_SEVEN)) {
            if (!(temp.equals(Constant.PROGRESS_SIX))) {
                flag = true;
            }
        }
        //审核未通过
        else if (questionProgress.equals(Constant.PROGRESS_NIGHT)) {
            if (!(temp.equals(Constant.PROGRESS_ZORE))) {
                flag = true;
            }
        }
        //总结状态来作出响应
        if (flag) {
            throw new Exception(Constant.PROGRESS_ERROR_MSG);
        } else {
            //入库
            addToDB(questionId, questionErrorMsg, questionProgress, answerQuestionUserId, tempQuestion.getQuestionUserId(), questionOfficeId, pro);
        }

        return true;
    }

    /**
     * 添加入库
     *
     * @param questionId
     * @param questionErrorMsg
     * @param questionProgress     原来的进度
     * @param answerQuestionUserId
     * @param questionUserId
     * @param questionOfficeId
     * @param pro                  当前的进度
     * @throws Exception
     */
    private void addToDB(int questionId, String questionErrorMsg, String questionProgress, int answerQuestionUserId, int questionUserId, int questionOfficeId, String pro) throws Exception {
        Office office = officeMapper.selectById(questionOfficeId);
        String officeName = "";
        if (office != null) {
            officeName = office.getOfficeName();
        }

        //更新状态
        Question question = new Question();
        question.setQuestionId(questionId);
//        question.setQuestionOfficeId(questionOfficeId);
//        question.setQuestionOfficeName(officeName);
        question.setQuestionErrorMsg(questionErrorMsg);
        question.setQuestionProgress(questionProgress);
        question.setQuestionUpdateTime(new Date());
//        questionMapper.updateById(question);

        //新增回复
        String msg = QuestionAutoAnswer.getMsg(pro);
        if (StringUtils.isNotBlank(msg)) {
            msg = msg.replaceAll(Matcher.quoteReplacement(Constant.SIGN_ERROR_MSG), questionErrorMsg);
            msg = msg.replaceAll(Matcher.quoteReplacement(Constant.SIGN_OFFICE), officeName);
            //添加回复问题
            addAnswerQuestion(msg, questionId, questionOfficeId, officeName, answerQuestionUserId, null, pro);
        }

//        回复成功再修改状态
        questionMapper.updateById(question);
        Question tempq = questionMapper.selectOneById(questionId);
        //添加消息通知
        Message message = new Message();
        message.setMessageQuestionId(questionId);
        message.setMessageQuestionCode(tempq.getQuestionCode());
        message.setMessageUserId(questionUserId);
        String questionMsg = QuestionProgress.getMsg(questionProgress);
        if (StringUtils.isNotBlank(questionMsg)) {
            questionMsg = questionMsg.replaceAll(Matcher.quoteReplacement(Constant.SIGN_OFFICE), officeName);
        }
        message.setMessageContent(questionMsg);
        message.setMessageType("1");
        messageMapper.insert(message);
    }

    /**
     * 添加回复问题
     *
     * @param msg
     * @param questionId
     * @param questionOfficeId
     * @param officeName
     * @param answerQuestionUserId
     * @param questionUserName
     * @param pro
     * @throws Exception
     */
    public int addAnswerQuestion(String msg, int questionId, int questionOfficeId,
                                 String officeName, int answerQuestionUserId,
                                 String questionUserName, String pro) throws Exception {
        if (StringUtils.isNotBlank(msg)) {
            Question answerQuestion = new Question();
            answerQuestion.setQuestionPid(questionId);
            answerQuestion.setQuestionOfficeId(questionOfficeId);
            answerQuestion.setQuestionOfficeName(officeName);
            answerQuestion.setQuestionUserId(answerQuestionUserId);
            answerQuestion.setQuestionContent(msg);
            answerQuestion.setQuestionStatus(Constant.QUESTION_AUTO_ANSWER);
            answerQuestion.setQuestionProgress(pro);
            if (StringUtils.isNotBlank(questionUserName)) {
                answerQuestion.setQuestionUserName(questionUserName);
            } else {
                UserInfo userInfo = userInfoMapper.selectById(answerQuestionUserId);
                if (userInfo != null) {
                    answerQuestion.setQuestionUserName(userInfo.getUserInfoNickname());
                } else {
                    throw new Exception("用户不存在！");
                }
            }

            questionMapper.insert(answerQuestion);
            //对象返回
            return answerQuestion.getQuestionId();
        }
        return 0;
    }

    /**
     * 当月问题件数
     *
     * @return
     */
    @Override
    public Integer getMonthCount(String date) {
        return questionMapper.getMonthCount(date);
    }

    /**
     * 当月问题解决件数
     *
     * @return
     */
    @Override
    public Integer getMonthSolveCount(String date, Integer serviceId) {
        return questionMapper.getMonthSolveCount(date, serviceId);
    }

    /**
     * 平均解决问题件数
     *
     * @return
     */
    @Override
    public Double getSolveDayAvg(String date, Integer serviceId) {
        Double doubleDate = questionMapper.getSolveDayAvg(date, serviceId);
        if (doubleDate != null) {
            return doubleDate;
        }
        return 0.0;
    }

    /**
     * 解决问题委办局排名
     *
     * @return
     */
    @Override
    public List<QuestionVo> getOfficeSort(String date) {
        return questionMapper.getOfficeSort(date);
    }

    @Override
    public String getMonthNewCountList(String date) {
        return questionMapper.getMonthNewCountList(date);
    }

    @Override
    public String getMonthSolveCountList(String date) {
        return questionMapper.getMonthSolveCountList(date);
    }

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
    @Override
    public Page getMyQuestinoByUserId(int userId, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<QuestionListVo> result = questionMapper.getMyQuestinoByUserId(page, orderByField, isAsc, userId);
        page.setRecords(result);
        return page;
    }

    /**
     * 获取企业-公开问题列表
     * @param questionTitle
     * @param privilege
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @param questionType
     * @param questionProgress
     * @param questionCreateTimeBeing
     * @param questionCreateTimeEnd
     * @return
     */
    @Override
    public Page getListByPublic(String questionTitle, String privilege, String orderByField, boolean isAsc, int size, int curPage, String questionType, String questionProgress, String questionCreateTimeBeing, String questionCreateTimeEnd) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<QuestionListVo> result = questionMapper.getListByPublic(questionTitle,privilege, page, "question_create_time", false, questionType, questionProgress, questionCreateTimeBeing, questionCreateTimeEnd);
        page.setRecords(result);
        return page;
    }

    /**
     * 查询热门问题
     *
     * @return
     */
    @Override
    public List<Object> totalHotQuestion() {
        Page<Object> page = new PageFactory<Object>().defaultPage2(5, 0);
        List<Object> questions = questionMapper.totalHotQuestion(page);
        return questions;
    }

    /**
     * 设置附件地址
     *
     * @param attachmentList
     */
    private void setAttachmentUrl(List<Attachment> attachmentList) {
        for (int i = 0; i < attachmentList.size(); i++) {
            String url = attachmentList.get(i).getAttachmentUrl();
            String serverPath = gunsProperties.getFileServerPath();
            url = serverPath + url;
            attachmentList.get(i).setAttachmentUrl(url);
        }
    }

    /**
     * 公开公示置顶
     * @param question
     */
    @Override
    public void setTop(Question question) {
        questionMapper.updateById(question);
    }

    /**
     * 查询最后一个回复人
     *
     * @param questionUserId
     * @param questionId
     * @return
     */
    @Override
    public Question selectQuestionAnswer(int questionUserId, int questionId) {
        return questionMapper.selectQuestionAnswer(questionUserId, questionId);
    }
}
