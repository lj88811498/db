package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 流转情况(业务流程表); InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Business extends Model<Business> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;
    /**
     * 我的申报表关联id
     */
    private Integer businessDeclareId;
    /**
     * 状态 (如 1: 提交项目申报 2: 项目审批 3: 上报立项材料 4:审批立项材料)
     */
    private String businessStatus;
    /**
     * 开始时间
     */
    private Date businessStartTime;
    /**
     * 结束时间
     */
    private Date businessEndTime;
    /**
     * 提交意见
     */
    private String businessOpinion;
    /**
     * 执行人
     */
    private String businessPeople;
    /**
     * 任务历时
     */
    private String businessDuration;
    /**
     * 创建时间
     */
    private Date businessTime;


    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getBusinessDeclareId() {
        return businessDeclareId;
    }

    public void setBusinessDeclareId(Integer businessDeclareId) {
        this.businessDeclareId = businessDeclareId;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public Date getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(Date businessEndTime) {
        this.businessEndTime = businessEndTime;
    }

    public String getBusinessOpinion() {
        return businessOpinion;
    }

    public void setBusinessOpinion(String businessOpinion) {
        this.businessOpinion = businessOpinion;
    }

    public String getBusinessPeople() {
        return businessPeople;
    }

    public void setBusinessPeople(String businessPeople) {
        this.businessPeople = businessPeople;
    }

    public String getBusinessDuration() {
        return businessDuration;
    }

    public void setBusinessDuration(String businessDuration) {
        this.businessDuration = businessDuration;
    }

    public Date getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Date businessTime) {
        this.businessTime = businessTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.businessId;
    }

    @Override
    public String toString() {
        return "Business{" +
        "businessId=" + businessId +
        ", businessDeclareId=" + businessDeclareId +
        ", businessStatus=" + businessStatus +
        ", businessStartTime=" + businessStartTime +
        ", businessEndTime=" + businessEndTime +
        ", businessOpinion=" + businessOpinion +
        ", businessPeople=" + businessPeople +
        ", businessDuration=" + businessDuration +
        ", businessTime=" + businessTime +
        "}";
    }
}
