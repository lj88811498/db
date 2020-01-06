package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 行业信息表
 * </p>
 *
 * @author Monkey
 * @since 2018-12-17
 */
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndustryInfo extends Model<IndustryInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "industry_info_id", type = IdType.AUTO)
    private Integer industryInfoId;
    /**
     * 行业名称
     */
    private String industryInfoName;

    /**
     * 父id
     */
    private Integer industryInfoPid;

    /**
     * 父ids
     */
    private String industryInfoPids;

    /**
     * 创建人
     */
    private Integer industryInfoCreateBy;
    /**
     * 修改人
     */
    private Integer industryInfoUpdateBy;
    /**
     * 修改时间
     */
    private Date industryInfoUpdateTime;
    /**
     * 创建时间
     */
    private Date industryInfoCreateTime;


    public Integer getIndustryInfoId() {
        return industryInfoId;
    }

    public void setIndustryInfoId(Integer industryInfoId) {
        this.industryInfoId = industryInfoId;
    }

    public String getIndustryInfoName() {
        return industryInfoName;
    }

    public void setIndustryInfoName(String industryInfoName) {
        this.industryInfoName = industryInfoName;
    }

    public Integer getIndustryInfoCreateBy() {
        return industryInfoCreateBy;
    }

    public void setIndustryInfoCreateBy(Integer industryInfoCreateBy) {
        this.industryInfoCreateBy = industryInfoCreateBy;
    }

    public Integer getIndustryInfoUpdateBy() {
        return industryInfoUpdateBy;
    }

    public void setIndustryInfoUpdateBy(Integer industryInfoUpdateBy) {
        this.industryInfoUpdateBy = industryInfoUpdateBy;
    }

    public Date getIndustryInfoUpdateTime() {
        return industryInfoUpdateTime;
    }

    public void setIndustryInfoUpdateTime(Date industryInfoUpdateTime) {
        this.industryInfoUpdateTime = industryInfoUpdateTime;
    }

    public Date getIndustryInfoCreateTime() {
        return industryInfoCreateTime;
    }

    public void setIndustryInfoCreateTime(Date industryInfoCreateTime) {
        this.industryInfoCreateTime = industryInfoCreateTime;
    }

    public Integer getIndustryInfoPid() {
        return industryInfoPid;
    }

    public void setIndustryInfoPid(Integer industryInfoPid) {
        this.industryInfoPid = industryInfoPid;
    }

    public String getIndustryInfoPids() {
        return industryInfoPids;
    }

    public void setIndustryInfoPids(String industryInfoPids) {
        this.industryInfoPids = industryInfoPids;
    }

    @Override
    protected Serializable pkVal() {
        return this.industryInfoId;
    }

    @Override
    public String toString() {
        return "IndustryInfo{" +
                "industryInfoId=" + industryInfoId +
                ", industryInfoName='" + industryInfoName + '\'' +
                ", industryInfoPid=" + industryInfoPid +
                ", industryInfoPids='" + industryInfoPids + '\'' +
                ", industryInfoCreateBy=" + industryInfoCreateBy +
                ", industryInfoUpdateBy=" + industryInfoUpdateBy +
                ", industryInfoUpdateTime=" + industryInfoUpdateTime +
                ", industryInfoCreateTime=" + industryInfoCreateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndustryInfo)) return false;
        IndustryInfo that = (IndustryInfo) o;
        return Objects.equals(industryInfoId, that.industryInfoId) &&
                Objects.equals(industryInfoName, that.industryInfoName) &&
                Objects.equals(industryInfoPid, that.industryInfoPid) &&
                Objects.equals(industryInfoPids, that.industryInfoPids) &&
                Objects.equals(industryInfoCreateBy, that.industryInfoCreateBy) &&
                Objects.equals(industryInfoUpdateBy, that.industryInfoUpdateBy) &&
                Objects.equals(industryInfoUpdateTime, that.industryInfoUpdateTime) &&
                Objects.equals(industryInfoCreateTime, that.industryInfoCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(industryInfoId, industryInfoName, industryInfoPid, industryInfoPids, industryInfoCreateBy, industryInfoUpdateBy, industryInfoUpdateTime, industryInfoCreateTime);
    }
}
