package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 招聘信息表
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@ApiModel
public class EmpInfo extends Model<EmpInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "emp_info_id", type = IdType.AUTO)
    private Integer empInfoId;
    /**
     * 标题
     */
    private String empInfoTitle;
    /**
     * 待遇水平
     */
    private String empinfoPrice;
    /**
     * 行业
     */
    private String empInfoIndustry;
    /**
     * 职位
     */
    private String empInfoPosition;
    /**
     * 职位类型
     */
    private String empInfoPositionType;
    /**
     * 招聘部门
     */
    private String empInfoDept;
    /**
     * 招聘人数
     */
    private String empInfoNum;
    /**
     * 公司
     */
    private String empInfoCompany;
    /**
     * 工作地区
     */
    private String empInfoArea;
    /**
     * 工作性质
     */
    private String empInfoProperty;
    /**
     * 性别要求
     */
    private String empInfoSex;
    /**
     * 婚姻要求
     */
    private String empInfoMarriage;
    /**
     * 学历要求
     */
    private String empInfoEducation;
    /**
     * 工作经验
     */
    private String empInfoExperience;
    /**
     * 年龄要求
     */
    private String empInfoAge;
    /**
     * 更新日期
     */
    private Date empInfoUpdateTime;
    /**
     * 有效期至
     */
    private Date empInfoIndateTime;
    /**
     * 职位描述
     */
    private String empInfoDescribe;
    /**
     * 公司介绍
     */
    private String empInfoIntro;
    /**
     * 创建时间
     */
    private Date empInfoCreateTime;


    public Integer getEmpInfoId() {
        return empInfoId;
    }

    public void setEmpInfoId(Integer empInfoId) {
        this.empInfoId = empInfoId;
    }

    public String getEmpInfoTitle() {
        return empInfoTitle;
    }

    public void setEmpInfoTitle(String empInfoTitle) {
        this.empInfoTitle = empInfoTitle;
    }

    public String getEmpinfoPrice() {
        return empinfoPrice;
    }

    public void setEmpinfoPrice(String empinfoPrice) {
        this.empinfoPrice = empinfoPrice;
    }

    public String getEmpInfoIndustry() {
        return empInfoIndustry;
    }

    public void setEmpInfoIndustry(String empInfoIndustry) {
        this.empInfoIndustry = empInfoIndustry;
    }

    public String getEmpInfoPosition() {
        return empInfoPosition;
    }

    public void setEmpInfoPosition(String empInfoPosition) {
        this.empInfoPosition = empInfoPosition;
    }

    public String getEmpInfoPositionType() {
        return empInfoPositionType;
    }

    public void setEmpInfoPositionType(String empInfoPositionType) {
        this.empInfoPositionType = empInfoPositionType;
    }

    public String getEmpInfoDept() {
        return empInfoDept;
    }

    public void setEmpInfoDept(String empInfoDept) {
        this.empInfoDept = empInfoDept;
    }

    public String getEmpInfoNum() {
        return empInfoNum;
    }

    public void setEmpInfoNum(String empInfoNum) {
        this.empInfoNum = empInfoNum;
    }

    public String getEmpInfoCompany() {
        return empInfoCompany;
    }

    public void setEmpInfoCompany(String empInfoCompany) {
        this.empInfoCompany = empInfoCompany;
    }

    public String getEmpInfoArea() {
        return empInfoArea;
    }

    public void setEmpInfoArea(String empInfoArea) {
        this.empInfoArea = empInfoArea;
    }

    public String getEmpInfoProperty() {
        return empInfoProperty;
    }

    public void setEmpInfoProperty(String empInfoProperty) {
        this.empInfoProperty = empInfoProperty;
    }

    public String getEmpInfoSex() {
        return empInfoSex;
    }

    public void setEmpInfoSex(String empInfoSex) {
        this.empInfoSex = empInfoSex;
    }

    public String getEmpInfoMarriage() {
        return empInfoMarriage;
    }

    public void setEmpInfoMarriage(String empInfoMarriage) {
        this.empInfoMarriage = empInfoMarriage;
    }

    public String getEmpInfoEducation() {
        return empInfoEducation;
    }

    public void setEmpInfoEducation(String empInfoEducation) {
        this.empInfoEducation = empInfoEducation;
    }

    public String getEmpInfoExperience() {
        return empInfoExperience;
    }

    public void setEmpInfoExperience(String empInfoExperience) {
        this.empInfoExperience = empInfoExperience;
    }

    public String getEmpInfoAge() {
        return empInfoAge;
    }

    public void setEmpInfoAge(String empInfoAge) {
        this.empInfoAge = empInfoAge;
    }

    public Date getEmpInfoUpdateTime() {
        return empInfoUpdateTime;
    }

    public void setEmpInfoUpdateTime(Date empInfoUpdateTime) {
        this.empInfoUpdateTime = empInfoUpdateTime;
    }

    public Date getEmpInfoIndateTime() {
        return empInfoIndateTime;
    }

    public void setEmpInfoIndateTime(Date empInfoIndateTime) {
        this.empInfoIndateTime = empInfoIndateTime;
    }

    public String getEmpInfoDescribe() {
        return empInfoDescribe;
    }

    public void setEmpInfoDescribe(String empInfoDescribe) {
        this.empInfoDescribe = empInfoDescribe;
    }

    public String getEmpInfoIntro() {
        return empInfoIntro;
    }

    public void setEmpInfoIntro(String empInfoIntro) {
        this.empInfoIntro = empInfoIntro;
    }

    public Date getEmpInfoCreateTime() {
        return empInfoCreateTime;
    }

    public void setEmpInfoCreateTime(Date empInfoCreateTime) {
        this.empInfoCreateTime = empInfoCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.empInfoId;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
        "empInfoId=" + empInfoId +
        ", empInfoTitle=" + empInfoTitle +
        ", empinfoPrice=" + empinfoPrice +
        ", empInfoIndustry=" + empInfoIndustry +
        ", empInfoPosition=" + empInfoPosition +
        ", empInfoPositionType=" + empInfoPositionType +
        ", empInfoDept=" + empInfoDept +
        ", empInfoNum=" + empInfoNum +
        ", empInfoCompany=" + empInfoCompany +
        ", empInfoArea=" + empInfoArea +
        ", empInfoProperty=" + empInfoProperty +
        ", empInfoSex=" + empInfoSex +
        ", empInfoMarriage=" + empInfoMarriage +
        ", empInfoEducation=" + empInfoEducation +
        ", empInfoExperience=" + empInfoExperience +
        ", empInfoAge=" + empInfoAge +
        ", empInfoUpdateTime=" + empInfoUpdateTime +
        ", empInfoIndateTime=" + empInfoIndateTime +
        ", empInfoDescribe=" + empInfoDescribe +
        ", empInfoIntro=" + empInfoIntro +
        ", empInfoCreateTime=" + empInfoCreateTime +
        "}";
    }
}
