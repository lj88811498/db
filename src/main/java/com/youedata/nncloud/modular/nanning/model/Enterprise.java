package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.youedata.nncloud.modular.nanning.anno.Too;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 企业信息表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Enterprise extends Model<Enterprise> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "enterprise_id", type = IdType.AUTO)
    private Integer enterpriseId;
    /**
     * 用户id
     */
    private Integer enterpriseUserId;
    /**
     * 企业名称
     */
    @Too(value="name")
    private String enterpriseName;
    /**
     * 企业地区
     */
    @Too(value="area")
    private String enterpriseRegion;
    /**
     * 单位性质
     */
    @Too(value="nature")
    private String enterpriseType;
    /**
     * 企业所属行业
     */
    @Too(value="industry")
    private String enterpriseIndustry;

    /**
     * 企业父ids
     */
    private String enterprisePids;

    /**
     * 企业审核状态
     */
    @Too(value="status")
    private String enterpriseStatus;
    /**
     * 企业简介
     */
    private String enterpriseSummary;
    /**
     * 工商注册类型
     */
    @Too(value="registrationtype")
    private String enterpriseBusinessType;
    /**
     * 信用代码
     */
    private String enterpriseCreditCode;
    /**
     * 组织代码
     */
    @Too(value="organizationCode")
    private String enterpriseOrganizationCode;
    /**
     * 法人代表
     */
    @Too(value="corporation")
    private String enterpriseLegalRepresentative;
    /**
     * 注册时间
     */
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Too(value="registeredDate")
    private Date enterpriseRegisteredTime;
    /**
     * 注册资金
     */
    @Too(value="registeredCapital")
    private String enterpriseRegisteredMoney;
    /**
     * 开户银行
     */
    @Too(value="bank")
    private String enterpriseBankAccount;
    /**
     * 开户账号
     */
    @Too(value="bankCode")
    private String enterpriseAccountNumber;
    /**
     * 单位电话
     */
    @Too(value="phone")
    private String enterprisePhone;
    /**
     * 单位传真
     */
    @Too(value="fax")
    private String enterpriseFax;
    /**
     * 企业邮箱
     */
    @Too(value="email")
    private String enterpriseEmail;
    /**
     * 网址
     */
    @Too(value="url")
    private String enterpriseWebsite;
    /**
     * 邮编
     */
    @Too(value="zipCode")
    private String enterprisePostCode;
    /**
     * 地址
     */
    @Too(value="address")
    private String enterpriseAddress;
    /**
     * 主要产品
     */
    private String enterpriseProduct;
    /**
     * 经营范围
     */
    @Too(value="businessScope")
    private String enterpriseBusinessScope;
    /**
     * 主营业务
     */
    @Too(value="mainBusiness")
    private String enterpriseMainBusiness;
    /**
     * 备注
     */
    private String enterpriseRemarks;

    /**
     * 企业营业执照图片
     */
    private String attachmentUrl;

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getEnterpriseUserId() {
        return enterpriseUserId;
    }

    public void setEnterpriseUserId(Integer enterpriseUserId) {
        this.enterpriseUserId = enterpriseUserId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseRegion() {
        return enterpriseRegion;
    }

    public void setEnterpriseRegion(String enterpriseRegion) {
        this.enterpriseRegion = enterpriseRegion;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseIndustry() {
        return enterpriseIndustry;
    }

    public void setEnterpriseIndustry(String enterpriseIndustry) {
        this.enterpriseIndustry = enterpriseIndustry;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEnterpriseSummary() {
        return enterpriseSummary;
    }

    public void setEnterpriseSummary(String enterpriseSummary) {
        this.enterpriseSummary = enterpriseSummary;
    }

    public String getEnterpriseBusinessType() {
        return enterpriseBusinessType;
    }

    public void setEnterpriseBusinessType(String enterpriseBusinessType) {
        this.enterpriseBusinessType = enterpriseBusinessType;
    }

    public String getEnterpriseCreditCode() {
        return enterpriseCreditCode;
    }

    public void setEnterpriseCreditCode(String enterpriseCreditCode) {
        this.enterpriseCreditCode = enterpriseCreditCode;
    }

    public String getEnterpriseOrganizationCode() {
        return enterpriseOrganizationCode;
    }

    public void setEnterpriseOrganizationCode(String enterpriseOrganizationCode) {
        this.enterpriseOrganizationCode = enterpriseOrganizationCode;
    }

    public String getEnterpriseLegalRepresentative() {
        return enterpriseLegalRepresentative;
    }

    public void setEnterpriseLegalRepresentative(String enterpriseLegalRepresentative) {
        this.enterpriseLegalRepresentative = enterpriseLegalRepresentative;
    }

    public Date getEnterpriseRegisteredTime() {
        return enterpriseRegisteredTime;
    }

    public void setEnterpriseRegisteredTime(Date enterpriseRegisteredTime) {
        this.enterpriseRegisteredTime = enterpriseRegisteredTime;
    }

    public String getEnterpriseRegisteredMoney() {
        return enterpriseRegisteredMoney;
    }

    public void setEnterpriseRegisteredMoney(String enterpriseRegisteredMoney) {
        this.enterpriseRegisteredMoney = enterpriseRegisteredMoney;
    }

    public String getEnterpriseBankAccount() {
        return enterpriseBankAccount;
    }

    public void setEnterpriseBankAccount(String enterpriseBankAccount) {
        this.enterpriseBankAccount = enterpriseBankAccount;
    }

    public String getEnterpriseAccountNumber() {
        return enterpriseAccountNumber;
    }

    public void setEnterpriseAccountNumber(String enterpriseAccountNumber) {
        this.enterpriseAccountNumber = enterpriseAccountNumber;
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    public String getEnterpriseFax() {
        return enterpriseFax;
    }

    public void setEnterpriseFax(String enterpriseFax) {
        this.enterpriseFax = enterpriseFax;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public String getEnterpriseWebsite() {
        return enterpriseWebsite;
    }

    public void setEnterpriseWebsite(String enterpriseWebsite) {
        this.enterpriseWebsite = enterpriseWebsite;
    }

    public String getEnterprisePostCode() {
        return enterprisePostCode;
    }

    public void setEnterprisePostCode(String enterprisePostCode) {
        this.enterprisePostCode = enterprisePostCode;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getEnterpriseProduct() {
        return enterpriseProduct;
    }

    public void setEnterpriseProduct(String enterpriseProduct) {
        this.enterpriseProduct = enterpriseProduct;
    }

    public String getEnterpriseBusinessScope() {
        return enterpriseBusinessScope;
    }

    public void setEnterpriseBusinessScope(String enterpriseBusinessScope) {
        this.enterpriseBusinessScope = enterpriseBusinessScope;
    }

    public String getEnterpriseMainBusiness() {
        return enterpriseMainBusiness;
    }

    public void setEnterpriseMainBusiness(String enterpriseMainBusiness) {
        this.enterpriseMainBusiness = enterpriseMainBusiness;
    }

    public String getEnterpriseRemarks() {
        return enterpriseRemarks;
    }

    public void setEnterpriseRemarks(String enterpriseRemarks) {
        this.enterpriseRemarks = enterpriseRemarks;
    }

    public String getEnterprisePids() {
        return enterprisePids;
    }

    public void setEnterprisePids(String enterprisePids) {
        this.enterprisePids = enterprisePids;
    }

    @Override
    protected Serializable pkVal() {
        return this.enterpriseId;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "enterpriseId=" + enterpriseId +
                ", enterpriseUserId=" + enterpriseUserId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseRegion='" + enterpriseRegion + '\'' +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", enterpriseIndustry='" + enterpriseIndustry + '\'' +
                ", enterprisePids='" + enterprisePids + '\'' +
                ", enterpriseStatus='" + enterpriseStatus + '\'' +
                ", enterpriseSummary='" + enterpriseSummary + '\'' +
                ", enterpriseBusinessType='" + enterpriseBusinessType + '\'' +
                ", enterpriseCreditCode='" + enterpriseCreditCode + '\'' +
                ", enterpriseOrganizationCode='" + enterpriseOrganizationCode + '\'' +
                ", enterpriseLegalRepresentative='" + enterpriseLegalRepresentative + '\'' +
                ", enterpriseRegisteredTime=" + enterpriseRegisteredTime +
                ", enterpriseRegisteredMoney='" + enterpriseRegisteredMoney + '\'' +
                ", enterpriseBankAccount='" + enterpriseBankAccount + '\'' +
                ", enterpriseAccountNumber='" + enterpriseAccountNumber + '\'' +
                ", enterprisePhone='" + enterprisePhone + '\'' +
                ", enterpriseFax='" + enterpriseFax + '\'' +
                ", enterpriseEmail='" + enterpriseEmail + '\'' +
                ", enterpriseWebsite='" + enterpriseWebsite + '\'' +
                ", enterprisePostCode='" + enterprisePostCode + '\'' +
                ", enterpriseAddress='" + enterpriseAddress + '\'' +
                ", enterpriseProduct='" + enterpriseProduct + '\'' +
                ", enterpriseBusinessScope='" + enterpriseBusinessScope + '\'' +
                ", enterpriseMainBusiness='" + enterpriseMainBusiness + '\'' +
                ", enterpriseRemarks='" + enterpriseRemarks + '\'' +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enterprise)) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(enterpriseId, that.enterpriseId) &&
                Objects.equals(enterpriseUserId, that.enterpriseUserId) &&
                Objects.equals(enterpriseName, that.enterpriseName) &&
                Objects.equals(enterpriseRegion, that.enterpriseRegion) &&
                Objects.equals(enterpriseType, that.enterpriseType) &&
                Objects.equals(enterpriseIndustry, that.enterpriseIndustry) &&
                Objects.equals(enterprisePids, that.enterprisePids) &&
                Objects.equals(enterpriseStatus, that.enterpriseStatus) &&
                Objects.equals(enterpriseSummary, that.enterpriseSummary) &&
                Objects.equals(enterpriseBusinessType, that.enterpriseBusinessType) &&
                Objects.equals(enterpriseCreditCode, that.enterpriseCreditCode) &&
                Objects.equals(enterpriseOrganizationCode, that.enterpriseOrganizationCode) &&
                Objects.equals(enterpriseLegalRepresentative, that.enterpriseLegalRepresentative) &&
                Objects.equals(enterpriseRegisteredTime, that.enterpriseRegisteredTime) &&
                Objects.equals(enterpriseRegisteredMoney, that.enterpriseRegisteredMoney) &&
                Objects.equals(enterpriseBankAccount, that.enterpriseBankAccount) &&
                Objects.equals(enterpriseAccountNumber, that.enterpriseAccountNumber) &&
                Objects.equals(enterprisePhone, that.enterprisePhone) &&
                Objects.equals(enterpriseFax, that.enterpriseFax) &&
                Objects.equals(enterpriseEmail, that.enterpriseEmail) &&
                Objects.equals(enterpriseWebsite, that.enterpriseWebsite) &&
                Objects.equals(enterprisePostCode, that.enterprisePostCode) &&
                Objects.equals(enterpriseAddress, that.enterpriseAddress) &&
                Objects.equals(enterpriseProduct, that.enterpriseProduct) &&
                Objects.equals(enterpriseBusinessScope, that.enterpriseBusinessScope) &&
                Objects.equals(enterpriseMainBusiness, that.enterpriseMainBusiness) &&
                Objects.equals(enterpriseRemarks, that.enterpriseRemarks) &&
                Objects.equals(attachmentUrl, that.attachmentUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterpriseId, enterpriseUserId, enterpriseName, enterpriseRegion, enterpriseType, enterpriseIndustry, enterprisePids, enterpriseStatus, enterpriseSummary, enterpriseBusinessType, enterpriseCreditCode, enterpriseOrganizationCode, enterpriseLegalRepresentative, enterpriseRegisteredTime, enterpriseRegisteredMoney, enterpriseBankAccount, enterpriseAccountNumber, enterprisePhone, enterpriseFax, enterpriseEmail, enterpriseWebsite, enterprisePostCode, enterpriseAddress, enterpriseProduct, enterpriseBusinessScope, enterpriseMainBusiness, enterpriseRemarks, attachmentUrl);
    }

}
