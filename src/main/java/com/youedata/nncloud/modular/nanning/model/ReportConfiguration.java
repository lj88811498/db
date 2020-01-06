package com.youedata.nncloud.modular.nanning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 填报配置
 * </p>
 *
 * @author Monkey
 * @since 2018-11-26
 */
@ApiModel
public class ReportConfiguration extends Model<ReportConfiguration> {

    private static final long serialVersionUID = 1L;

    /**
     * 配置填报id
     */
    private Integer reportConfigurationId;
    /**
     * 报表名称
     */
    private String reportConfigurationName;
    /**
     * 状态（0：禁用，1：启用）
     */
    private String reportConfigurationStatus;
    /**
     * 开始时间
     */
    private Date reportConfigurationStartTime;
    /**
     * 结束时间
     */
    private Date reportConfigurationEndTime;
    /**
     * 每月开始填报日期
     */
    private String reportConfigurationStartDay;
    /**
     * 例外月份
     */
    private String reportConfigurationExceptMonth;
    /**
     * 提醒方式:1.催报，2.短信
     */
    private String reportConfigurationRemindMode;
    /**
     * 填报类型（1：工业填报配置 2：财务填报配置）
     */
    private String reportConfigurationType;
    /**
     * 创建时间
     */
    private Date reportConfigurationCreateTime;
    /**
     * 更新时间
     */
    private Date reportConfigurationUpdateTime;
    /**
     * 创建人
     */
    private Integer reportConfigurationCreateBy;
    /**
     * 更新人
     */
    private Integer reportConfigurationUpdateBy;
    /**
     * 删除标识（0：未删除 ，1：已删除）
     */
    private String reportConfigurationDelFlag;

    /**
     * 列表填报解释
     */
    private  String explian;


    public Integer getReportConfigurationId() {
        return reportConfigurationId;
    }

    public void setReportConfigurationId(Integer reportConfigurationId) {
        this.reportConfigurationId = reportConfigurationId;
    }

    public String getReportConfigurationName() {
        return reportConfigurationName;
    }

    public void setReportConfigurationName(String reportConfigurationName) {
        this.reportConfigurationName = reportConfigurationName;
    }

    public String getReportConfigurationStatus() {
        return reportConfigurationStatus;
    }

    public void setReportConfigurationStatus(String reportConfigurationStatus) {
        this.reportConfigurationStatus = reportConfigurationStatus;
    }

    public Date getReportConfigurationStartTime() {
        return reportConfigurationStartTime;
    }

    public void setReportConfigurationStartTime(Date reportConfigurationStartTime) {
        this.reportConfigurationStartTime = reportConfigurationStartTime;
    }

    public Date getReportConfigurationEndTime() {
        return reportConfigurationEndTime;
    }

    public void setReportConfigurationEndTime(Date reportConfigurationEndTime) {
        this.reportConfigurationEndTime = reportConfigurationEndTime;
    }

    public String getReportConfigurationStartDay() {
        return reportConfigurationStartDay;
    }

    public void setReportConfigurationStartDay(String reportConfigurationStartDay) {
        this.reportConfigurationStartDay = reportConfigurationStartDay;
    }

    public String getReportConfigurationExceptMonth() {
        return reportConfigurationExceptMonth;
    }

    public void setReportConfigurationExceptMonth(String reportConfigurationExceptMonth) {
        this.reportConfigurationExceptMonth = reportConfigurationExceptMonth;
    }

    public String getReportConfigurationRemindMode() {
        return reportConfigurationRemindMode;
    }

    public void setReportConfigurationRemindMode(String reportConfigurationRemindMode) {
        this.reportConfigurationRemindMode = reportConfigurationRemindMode;
    }

    public String getReportConfigurationType() {
        return reportConfigurationType;
    }

    public void setReportConfigurationType(String reportConfigurationType) {
        this.reportConfigurationType = reportConfigurationType;
    }

    public Date getReportConfigurationCreateTime() {
        return reportConfigurationCreateTime;
    }

    public void setReportConfigurationCreateTime(Date reportConfigurationCreateTime) {
        this.reportConfigurationCreateTime = reportConfigurationCreateTime;
    }

    public Date getReportConfigurationUpdateTime() {
        return reportConfigurationUpdateTime;
    }

    public void setReportConfigurationUpdateTime(Date reportConfigurationUpdateTime) {
        this.reportConfigurationUpdateTime = reportConfigurationUpdateTime;
    }

    public Integer getReportConfigurationCreateBy() {
        return reportConfigurationCreateBy;
    }

    public void setReportConfigurationCreateBy(Integer reportConfigurationCreateBy) {
        this.reportConfigurationCreateBy = reportConfigurationCreateBy;
    }

    public Integer getReportConfigurationUpdateBy() {
        return reportConfigurationUpdateBy;
    }

    public void setReportConfigurationUpdateBy(Integer reportConfigurationUpdateBy) {
        this.reportConfigurationUpdateBy = reportConfigurationUpdateBy;
    }

    public String getReportConfigurationDelFlag() {
        return reportConfigurationDelFlag;
    }

    public void setReportConfigurationDelFlag(String reportConfigurationDelFlag) {
        this.reportConfigurationDelFlag = reportConfigurationDelFlag;
    }

    public String getExplian() {
        return explian;
    }

    public void setExplian(String explian) {
        this.explian = explian;
    }

    @Override
    protected Serializable pkVal() {
        return this.reportConfigurationId;
    }

    @Override
    public String toString() {
        return "ReportConfiguration{" +
        "reportConfigurationId=" + reportConfigurationId +
        ", reportConfigurationName=" + reportConfigurationName +
        ", reportConfigurationStatus=" + reportConfigurationStatus +
        ", reportConfigurationStartTime=" + reportConfigurationStartTime +
        ", reportConfigurationEndTime=" + reportConfigurationEndTime +
        ", reportConfigurationStartDay=" + reportConfigurationStartDay +
        //", reportConfigurationEndDay=" + reportConfigurationEndDay +
        ", reportConfigurationExceptMonth=" + reportConfigurationExceptMonth +
        ", reportConfigurationRemindMode=" + reportConfigurationRemindMode +
        ", reportConfigurationType=" + reportConfigurationType +
        ", reportConfigurationCreateTime=" + reportConfigurationCreateTime +
        ", reportConfigurationUpdateTime=" + reportConfigurationUpdateTime +
        ", reportConfigurationCreateBy=" + reportConfigurationCreateBy +
        ", reportConfigurationUpdateBy=" + reportConfigurationUpdateBy +
        ", reportConfigurationDelFlag=" + reportConfigurationDelFlag +
        "}";
    }


}
