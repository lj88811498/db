package com.youedata.nncloud.modular.nanning.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 常见问题表
 * </p>
 *
 * @author Monkey
 * @since 2018-11-09
 */
@ApiModel
public class QuestionCommon extends Model<QuestionCommon> {

    private static final long serialVersionUID = 1L;

    /**
     * 常见问题id
     */
    @TableId(value = "question_common_id", type = IdType.AUTO)
    private Integer questionCommonId;
    /**
     * 常见问题标题
     */
    private String questionCommonTitle;
    /**
     * 问题状态(0.未发布；1.已发布)
     */
    private String questionCommonStatus;
    /**
     * 问题类型
     */
    private String questionCommonType;
    /**
     * 问题内容
     */
    private String questionCommonContent;
    /**
     * 问题创建时间
     */
    private Date questionCommonCreateTime;
    /**
     * 问题更新时间
     */
    private Date questionCommonUpdateTime;
    /**
     * 创建人
     */
    private Integer questionCommonCreateBy;


    public Integer getQuestionCommonId() {
        return questionCommonId;
    }

    public void setQuestionCommonId(Integer questionCommonId) {
        this.questionCommonId = questionCommonId;
    }

    public String getQuestionCommonTitle() {
        return questionCommonTitle;
    }

    public void setQuestionCommonTitle(String questionCommonTitle) {
        this.questionCommonTitle = questionCommonTitle;
    }

    public String getQuestionCommonStatus() {
        return questionCommonStatus;
    }

    public void setQuestionCommonStatus(String questionCommonStatus) {
        this.questionCommonStatus = questionCommonStatus;
    }

    public String getQuestionCommonType() {
        return questionCommonType;
    }

    public void setQuestionCommonType(String questionCommonType) {
        this.questionCommonType = questionCommonType;
    }

    public String getQuestionCommonContent() {
        return questionCommonContent;
    }

    public void setQuestionCommonContent(String questionCommonContent) {
        this.questionCommonContent = questionCommonContent;
    }

    public Date getQuestionCommonCreateTime() {
        return questionCommonCreateTime;
    }

    public void setQuestionCommonCreateTime(Date questionCommonCreateTime) {
        this.questionCommonCreateTime = questionCommonCreateTime;
    }

    public Date getQuestionCommonUpdateTime() {
        return questionCommonUpdateTime;
    }

    public void setQuestionCommonUpdateTime(Date questionCommonUpdateTime) {
        this.questionCommonUpdateTime = questionCommonUpdateTime;
    }

    public Integer getQuestionCommonCreateBy() {
        return questionCommonCreateBy;
    }

    public void setQuestionCommonCreateBy(Integer questionCommonCreateBy) {
        this.questionCommonCreateBy = questionCommonCreateBy;
    }

    @Override
    protected Serializable pkVal() {
        return this.questionCommonId;
    }

    @Override
    public String toString() {
        return "QuestionCommon{" +
        "questionCommonId=" + questionCommonId +
        ", questionCommonTitle=" + questionCommonTitle +
        ", questionCommonStatus=" + questionCommonStatus +
        ", questionCommonType=" + questionCommonType +
        ", questionCommonContent=" + questionCommonContent +
        ", questionCommonCreateTime=" + questionCommonCreateTime +
        ", questionCommonUpdateTime=" + questionCommonUpdateTime +
        ", questionCommonCreateBy=" + questionCommonCreateBy +
        "}";
    }
}
