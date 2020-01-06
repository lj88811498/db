package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.youedata.nncloud.modular.nanning.anno.Too;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 培训信息
 * </p>
 *
 * @author Monkey
 * @since 2019-01-21
 */
@ApiModel
public class TrainInfo extends Model<TrainInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Too(value="id")
    private String trainInfoId;
    /**
     * 模型
     */
    @Too(value="module")
    private String trainInfoModule;
    /**
     * 课程名称
     */
    @Too(value="name")
    private String trainInfoName;
    /**
     * 学分
     */
    @Too(value="credit")
    private String trainInfoCredit;
    /**
     * 报名开始时间
     */
    @Too(value="start_date")
    private String trainInfoStatrtData;
    /**
     * 报名结束时间
     */
    @Too(value="end_date")
    private String trainInfoEndDate;
    /**
     * 内容
     */
    @Too(value="content")
    private String trainInfoContent;
    /**
     * 创建人
     */
    private Integer trainInfoCreateBy;
    /**
     * 修改人
     */
    private Integer trainInfoUpdateBy;
    /**
     * 修改时间
     */
    private Date trainInfoUpdateTime;
    /**
     * 创建时间
     */
    private Date trainInfoCreateTime;


    public String getTrainInfoId() {
        return trainInfoId;
    }

    public void setTrainInfoId(String trainInfoId) {
        this.trainInfoId = trainInfoId;
    }

    public String getTrainInfoModule() {
        return trainInfoModule;
    }

    public void setTrainInfoModule(String trainInfoModule) {
        this.trainInfoModule = trainInfoModule;
    }

    public String getTrainInfoName() {
        return trainInfoName;
    }

    public void setTrainInfoName(String trainInfoName) {
        this.trainInfoName = trainInfoName;
    }

    public String getTrainInfoCredit() {
        return trainInfoCredit;
    }

    public void setTrainInfoCredit(String trainInfoCredit) {
        this.trainInfoCredit = trainInfoCredit;
    }

    public String getTrainInfoStatrtData() {
        return trainInfoStatrtData;
    }

    public void setTrainInfoStatrtData(String trainInfoStatrtData) {
        this.trainInfoStatrtData = trainInfoStatrtData;
    }

    public String getTrainInfoEndDate() {
        return trainInfoEndDate;
    }

    public void setTrainInfoEndDate(String trainInfoEndDate) {
        this.trainInfoEndDate = trainInfoEndDate;
    }

    public String getTrainInfoContent() {
        return trainInfoContent;
    }

    public void setTrainInfoContent(String trainInfoContent) {
        this.trainInfoContent = trainInfoContent;
    }

    public Integer getTrainInfoCreateBy() {
        return trainInfoCreateBy;
    }

    public void setTrainInfoCreateBy(Integer trainInfoCreateBy) {
        this.trainInfoCreateBy = trainInfoCreateBy;
    }

    public Integer getTrainInfoUpdateBy() {
        return trainInfoUpdateBy;
    }

    public void setTrainInfoUpdateBy(Integer trainInfoUpdateBy) {
        this.trainInfoUpdateBy = trainInfoUpdateBy;
    }

    public Date getTrainInfoUpdateTime() {
        return trainInfoUpdateTime;
    }

    public void setTrainInfoUpdateTime(Date trainInfoUpdateTime) {
        this.trainInfoUpdateTime = trainInfoUpdateTime;
    }

    public Date getTrainInfoCreateTime() {
        return trainInfoCreateTime;
    }

    public void setTrainInfoCreateTime(Date trainInfoCreateTime) {
        this.trainInfoCreateTime = trainInfoCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.trainInfoId;
    }

    @Override
    public String toString() {
        return "TrainInfo{" +
        "trainInfoId=" + trainInfoId +
        ", trainInfoModule=" + trainInfoModule +
        ", trainInfoName=" + trainInfoName +
        ", trainInfoCredit=" + trainInfoCredit +
        ", trainInfoStatrtData=" + trainInfoStatrtData +
        ", trainInfoEndDate=" + trainInfoEndDate +
        ", trainInfoContent=" + trainInfoContent +
        ", trainInfoCreateBy=" + trainInfoCreateBy +
        ", trainInfoUpdateBy=" + trainInfoUpdateBy +
        ", trainInfoUpdateTime=" + trainInfoUpdateTime +
        ", trainInfoCreateTime=" + trainInfoCreateTime +
        "}";
    }
}
