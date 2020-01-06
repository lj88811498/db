package com.youedata.nncloud.modular.nanning.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 问题浏览
 * </p>
 *
 * @author Monkey
 * @since 2018-10-12
 */
@ApiModel
public class QuestionView extends Model<QuestionView> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "question_view_id", type = IdType.AUTO)
    private Integer questionViewId;
    /**
     * 问题id
     */
    private Integer questionViewQuestionId;
    /**
     * 用户id
     */
    private Integer questionViewUserId;
    /**
     * 创建时间
     */
    private Date questionViewCreateTime;


    public Integer getQuestionViewId() {
        return questionViewId;
    }

    public void setQuestionViewId(Integer questionViewId) {
        this.questionViewId = questionViewId;
    }

    public Integer getQuestionViewQuestionId() {
        return questionViewQuestionId;
    }

    public void setQuestionViewQuestionId(Integer questionViewQuestionId) {
        this.questionViewQuestionId = questionViewQuestionId;
    }

    public Integer getQuestionViewUserId() {
        return questionViewUserId;
    }

    public void setQuestionViewUserId(Integer questionViewUserId) {
        this.questionViewUserId = questionViewUserId;
    }

    public Date getQuestionViewCreateTime() {
        return questionViewCreateTime;
    }

    public void setQuestionViewCreateTime(Date questionViewCreateTime) {
        this.questionViewCreateTime = questionViewCreateTime;
    }

    public QuestionView(){

    }
    public QuestionView(int questionViewQuestionId, int questionViewUserId){
        this.questionViewUserId = questionViewUserId;
        this.questionViewQuestionId = questionViewQuestionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.questionViewId;
    }

    @Override
    public String toString() {
        return "QuestionView{" +
        "questionViewId=" + questionViewId +
        ", questionViewQuestionId=" + questionViewQuestionId +
        ", questionViewUserId=" + questionViewUserId +
        ", questionViewCreateTime=" + questionViewCreateTime +
        "}";
    }
}
