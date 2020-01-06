package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 项目申报表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class ProjectDeclaration extends Model<ProjectDeclaration> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_declaration_id", type = IdType.AUTO)
    private Integer projectDeclarationId;
    /**
     * 申报标题
     */
    private String projectDeclarationTitle;
    /**
     * 级别(如:国家级,省级)
     */
    private String projectDeclarationLevel;
    /**
     * 起始时间
     */
    private Date projectDeclarationStartTime;
    /**
     * 终止时间
     */
    private Date projectDeclarationEndTime;
    /**
     * 科室
     */
    private String projectDeclarationDept;
    /**
     * 流程类型
     */
    private String projectDeclarationProcessType;
    /**
     * 申报模块
     */
    private String projectDeclarationModule;
    /**
     * 所属行业
     */
    private String projectDeclarationIndustry;
    /**
     * 备注
     */
    private String projectDeclarationBz;
    /**
     * 创建时间
     */
    private Date projectDeclarationTime;


    public Integer getProjectDeclarationId() {
        return projectDeclarationId;
    }

    public void setProjectDeclarationId(Integer projectDeclarationId) {
        this.projectDeclarationId = projectDeclarationId;
    }

    public String getProjectDeclarationTitle() {
        return projectDeclarationTitle;
    }

    public void setProjectDeclarationTitle(String projectDeclarationTitle) {
        this.projectDeclarationTitle = projectDeclarationTitle;
    }

    public String getProjectDeclarationLevel() {
        return projectDeclarationLevel;
    }

    public void setProjectDeclarationLevel(String projectDeclarationLevel) {
        this.projectDeclarationLevel = projectDeclarationLevel;
    }

    public Date getProjectDeclarationStartTime() {
        return projectDeclarationStartTime;
    }

    public void setProjectDeclarationStartTime(Date projectDeclarationStartTime) {
        this.projectDeclarationStartTime = projectDeclarationStartTime;
    }

    public Date getProjectDeclarationEndTime() {
        return projectDeclarationEndTime;
    }

    public void setProjectDeclarationEndTime(Date projectDeclarationEndTime) {
        this.projectDeclarationEndTime = projectDeclarationEndTime;
    }

    public String getProjectDeclarationDept() {
        return projectDeclarationDept;
    }

    public void setProjectDeclarationDept(String projectDeclarationDept) {
        this.projectDeclarationDept = projectDeclarationDept;
    }

    public String getProjectDeclarationProcessType() {
        return projectDeclarationProcessType;
    }

    public void setProjectDeclarationProcessType(String projectDeclarationProcessType) {
        this.projectDeclarationProcessType = projectDeclarationProcessType;
    }

    public String getProjectDeclarationModule() {
        return projectDeclarationModule;
    }

    public void setProjectDeclarationModule(String projectDeclarationModule) {
        this.projectDeclarationModule = projectDeclarationModule;
    }

    public String getProjectDeclarationIndustry() {
        return projectDeclarationIndustry;
    }

    public void setProjectDeclarationIndustry(String projectDeclarationIndustry) {
        this.projectDeclarationIndustry = projectDeclarationIndustry;
    }

    public String getProjectDeclarationBz() {
        return projectDeclarationBz;
    }

    public void setProjectDeclarationBz(String projectDeclarationBz) {
        this.projectDeclarationBz = projectDeclarationBz;
    }

    public Date getProjectDeclarationTime() {
        return projectDeclarationTime;
    }

    public void setProjectDeclarationTime(Date projectDeclarationTime) {
        this.projectDeclarationTime = projectDeclarationTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.projectDeclarationId;
    }

    @Override
    public String toString() {
        return "ProjectDeclaration{" +
        "projectDeclarationId=" + projectDeclarationId +
        ", projectDeclarationTitle=" + projectDeclarationTitle +
        ", projectDeclarationLevel=" + projectDeclarationLevel +
        ", projectDeclarationStartTime=" + projectDeclarationStartTime +
        ", projectDeclarationEndTime=" + projectDeclarationEndTime +
        ", projectDeclarationDept=" + projectDeclarationDept +
        ", projectDeclarationProcessType=" + projectDeclarationProcessType +
        ", projectDeclarationModule=" + projectDeclarationModule +
        ", projectDeclarationIndustry=" + projectDeclarationIndustry +
        ", projectDeclarationBz=" + projectDeclarationBz +
        ", projectDeclarationTime=" + projectDeclarationTime +
        "}";
    }
}
