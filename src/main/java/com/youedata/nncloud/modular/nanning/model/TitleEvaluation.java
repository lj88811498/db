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
 * 职称评审
 * </p>
 *
 * @author Monkey
 * @since 2018-11-15
 */
@ApiModel
public class TitleEvaluation extends Model<TitleEvaluation> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "title_evaluation_id", type = IdType.AUTO)
    private Integer titleEvaluationId;
    /**
     * 标题
     */
    private String titleEvaluationTitle;
    /**
     * 内容
     */
    private String titleEvaluationContent;
    /**
     * 是否被删除：0、否；1、是；
     */
    private String titleEvaluationIsDelete;
    /**
     * 状态：0、未发布；1、已发布;
     */
    private String titleEvaluationStatus;
    /**
     * 创建人
     */
    private Integer titleEvaluationCreateBy;
    /**
     * 创建时间
     */
    private Date titleEvaluationCreateTime;
    /**
     * 修改人
     */
    private Integer titleEvaluationUpdateBy;
    /**
     * 修改时间
     */
    private Date titleEvaluationUpdateTime;

    public String getTitleEvaluationIsDelete() {
        return titleEvaluationIsDelete;
    }

    public void setTitleEvaluationIsDelete(String titleEvaluationIsDelete) {
        this.titleEvaluationIsDelete = titleEvaluationIsDelete;
    }

    public Integer getTitleEvaluationId() {
        return titleEvaluationId;
    }

    public void setTitleEvaluationId(Integer titleEvaluationId) {
        this.titleEvaluationId = titleEvaluationId;
    }

    public String getTitleEvaluationTitle() {
        return titleEvaluationTitle;
    }

    public void setTitleEvaluationTitle(String titleEvaluationTitle) {
        this.titleEvaluationTitle = titleEvaluationTitle;
    }

    public String getTitleEvaluationContent() {
        return titleEvaluationContent;
    }

    public void setTitleEvaluationContent(String titleEvaluationContent) {
        this.titleEvaluationContent = titleEvaluationContent;
    }

    public String getTitleEvaluationStatus() {
        return titleEvaluationStatus;
    }

    public void setTitleEvaluationStatus(String titleEvaluationStatus) {
        this.titleEvaluationStatus = titleEvaluationStatus;
    }

    public Integer getTitleEvaluationCreateBy() {
        return titleEvaluationCreateBy;
    }

    public void setTitleEvaluationCreateBy(Integer titleEvaluationCreateBy) {
        this.titleEvaluationCreateBy = titleEvaluationCreateBy;
    }

    public Date getTitleEvaluationCreateTime() {
        return titleEvaluationCreateTime;
    }

    public void setTitleEvaluationCreateTime(Date titleEvaluationCreateTime) {
        this.titleEvaluationCreateTime = titleEvaluationCreateTime;
    }

    public Integer getTitleEvaluationUpdateBy() {
        return titleEvaluationUpdateBy;
    }

    public void setTitleEvaluationUpdateBy(Integer titleEvaluationUpdateBy) {
        this.titleEvaluationUpdateBy = titleEvaluationUpdateBy;
    }

    public Date getTitleEvaluationUpdateTime() {
        return titleEvaluationUpdateTime;
    }

    public void setTitleEvaluationUpdateTime(Date titleEvaluationUpdateTime) {
        this.titleEvaluationUpdateTime = titleEvaluationUpdateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.titleEvaluationId;
    }

    @Override
    public String toString() {
        return "TitleEvaluation{" +
                "titleEvaluationId=" + titleEvaluationId +
                ", titleEvaluationTitle='" + titleEvaluationTitle + '\'' +
                ", titleEvaluationContent='" + titleEvaluationContent + '\'' +
                ", titleEvaluationIsDelete='" + titleEvaluationIsDelete + '\'' +
                ", titleEvaluationStatus='" + titleEvaluationStatus + '\'' +
                ", titleEvaluationCreateBy=" + titleEvaluationCreateBy +
                ", titleEvaluationCreateTime=" + titleEvaluationCreateTime +
                ", titleEvaluationUpdateBy=" + titleEvaluationUpdateBy +
                ", titleEvaluationUpdateTime=" + titleEvaluationUpdateTime +
                '}';
    }
}
