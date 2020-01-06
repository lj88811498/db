package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Date;

public class QuestionListVo {
    /**
     * 问题id
     */
    private Integer questionId;
    /**
     * 问题标题
     */
    private String questionTitle;
    /**
     * 问题时间
     */
    private Date questionCreateTime;
    /**
     * 问题类型
     */
    private String questionType;
    /**
     * 问题进度
     */
    private String questionProgress;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Date getQuestionCreateTime() {
        return questionCreateTime;
    }

    public void setQuestionCreateTime(Date questionCreateTime) {
        this.questionCreateTime = questionCreateTime;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionProgress() {
        return questionProgress;
    }

    public void setQuestionProgress(String questionProgress) {
        this.questionProgress = questionProgress;
    }
}
