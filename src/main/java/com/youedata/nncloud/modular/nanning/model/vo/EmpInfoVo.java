package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Date;

public class EmpInfoVo {
    /**
     * 主键id
     */
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
     * 工作地区
     */
    private String empInfoArea;
    /**
     * 公司
     */
    private String empInfoCompany;
    /**
     * 更新日期
     */
    private Date empInfoUpdateTime;

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

    public String getEmpInfoArea() {
        return empInfoArea;
    }

    public void setEmpInfoArea(String empInfoArea) {
        this.empInfoArea = empInfoArea;
    }

    public String getEmpInfoCompany() {
        return empInfoCompany;
    }

    public void setEmpInfoCompany(String empInfoCompany) {
        this.empInfoCompany = empInfoCompany;
    }

    public Date getEmpInfoUpdateTime() {
        return empInfoUpdateTime;
    }

    public void setEmpInfoUpdateTime(Date empInfoUpdateTime) {
        this.empInfoUpdateTime = empInfoUpdateTime;
    }
}
