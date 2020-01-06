package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * pro投融资项目余额表
 * </p>
 *
 * @author Monkey
 * @since 2018-12-25
 */
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invest extends Model<Invest> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "invest_id", type = IdType.AUTO)
    private Integer investId;
    /**
     * 企业名称
     */
    private String investConpanyName;
    /**
     * 所属区域
     */
    private String investArea;
    /**
     * 联系地址
     */
    private String investAddress;
    /**
     * 法人代表
     */
    private String investLegalRepresentative;
    /**
     * 项目名称
     */
    private String investProjectName;
    /**
     * 授信金额
     */
    private BigDecimal investCreditAmount;
    /**
     * 余额合计
     */
    private BigDecimal investTotalBalance;
    /**
     * 合同编号-平台银行自营
     */
    private String investSelfContract;
    /**
     * 放款额-平台银行自营
     */
    private BigDecimal investSelfLoanAmount;
    /**
     * 放款日-平台银行自营
     */
    private String investSelfLoanDay;
    /**
     * 到期日-平台银行自营
     */
    private String investSelfExpiryDate;
    /**
     * 利率-平台银行自营
     */
    private String investSelfInterestRate;
    /**
     * 余额-平台银行自营
     */
    private BigDecimal investSelfBalance;
    /**
     * 合同编号-平台配套
     */
    private String investMatchContract;
    /**
     * 放款额-平台配套
     */
    private BigDecimal investMatchLoanAmount;
    /**
     * 放款日-平台配套
     */
    private String investMatchLoanDay;
    /**
     * 到期日-平台配套
     */
    private String investMatchExpiryDate;
    /**
     * 利率-平台配套
     */
    private String investMatchInterestRate;
    /**
     * 余额-平台配套
     */
    private BigDecimal investMatchBalance;
    /**
     * 结息方式
     */
    private String investSettleWay;
    /**
     * 付息日
     */
    private String investHolidayDate;
    /**
     * 助保金缴纳时间
     */
    private String investInsuranceDate;
    /**
     * 助保金缴纳金额
     */
    private BigDecimal investInsuranceBalance;
    /**
     * 性质
     */
    private String investNature;
    /**
     * 业务品种
     */
    private String investBusinessTypes;
    /**
     * 担保方式
     */
    private String investGuaranteeMethod;
    /**
     * 抵押价值
     */
    private BigDecimal investMortgageValue;
    /**
     * 五级分类
     */
    private String investFiveClass;
    /**
     * 信用等级
     */
    private String investCreditRating;
    /**
     * 企业实际控制人
     */
    private String investActualPeople;
    /**
     * 企业实际控制人联系方式
     */
    private String investActualPhone;
    /**
     * 经办银行
     */
    private String investManagementBank;
    /**
     * 经办银行客户经理
     */
    private String investAccountManager;
    /**
     * 经办银行客户经理联系方式
     */
    private String investAccountPhone;
    /**
     * 经办担保公司
     */
    private String investGuaranteeCompany;
    /**
     * 经办担保公司项目经理
     */
    private String investCompanyManager;
    /**
     * 经办担保公司项目经理联系方式
     */
    private String investCompanyPhone;
    /**
     * 经办授权机构
     */
    private String investOperationAuthority;
    /**
     * 经办授权机构项目经理
     */
    private String investOperationManeger;
    /**
     * 经办授权机构项目经理联系方式
     */
    private String investOperationPhone;

    //开始时间
    private String startTime;
    //截止时间
    private String endTime;
    
    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getInvestId() {
        return investId;
    }

    public void setInvestId(Integer investId) {
        this.investId = investId;
    }

    public String getInvestConpanyName() {
        return investConpanyName;
    }

    public void setInvestConpanyName(String investConpanyName) {
        this.investConpanyName = investConpanyName;
    }

    public String getInvestArea() {
        return investArea;
    }

    public void setInvestArea(String investArea) {
        this.investArea = investArea;
    }

    public String getInvestAddress() {
        return investAddress;
    }

    public void setInvestAddress(String investAddress) {
        this.investAddress = investAddress;
    }

    public String getInvestLegalRepresentative() {
        return investLegalRepresentative;
    }

    public void setInvestLegalRepresentative(String investLegalRepresentative) {
        this.investLegalRepresentative = investLegalRepresentative;
    }

    public String getInvestProjectName() {
        return investProjectName;
    }

    public void setInvestProjectName(String investProjectName) {
        this.investProjectName = investProjectName;
    }

    public BigDecimal getInvestCreditAmount() {
        return investCreditAmount;
    }

    public void setInvestCreditAmount(BigDecimal investCreditAmount) {
        this.investCreditAmount = investCreditAmount;
    }

    public BigDecimal getInvestTotalBalance() {
        return investTotalBalance;
    }

    public void setInvestTotalBalance(BigDecimal investTotalBalance) {
        this.investTotalBalance = investTotalBalance;
    }

    public String getInvestSelfContract() {
        return investSelfContract;
    }

    public void setInvestSelfContract(String investSelfContract) {
        this.investSelfContract = investSelfContract;
    }

    public BigDecimal getInvestSelfLoanAmount() {
        return investSelfLoanAmount;
    }

    public void setInvestSelfLoanAmount(BigDecimal investSelfLoanAmount) {
        this.investSelfLoanAmount = investSelfLoanAmount;
    }

    public String getInvestSelfLoanDay() {
        return investSelfLoanDay;
    }

    public void setInvestSelfLoanDay(String investSelfLoanDay) {
        this.investSelfLoanDay = investSelfLoanDay;
    }

    public String getInvestSelfExpiryDate() {
        return investSelfExpiryDate;
    }

    public void setInvestSelfExpiryDate(String investSelfExpiryDate) {
        this.investSelfExpiryDate = investSelfExpiryDate;
    }

    public String getInvestSelfInterestRate() {
        return investSelfInterestRate;
    }

    public void setInvestSelfInterestRate(String investSelfInterestRate) {
        this.investSelfInterestRate = investSelfInterestRate;
    }

    public BigDecimal getInvestSelfBalance() {
        return investSelfBalance;
    }

    public void setInvestSelfBalance(BigDecimal investSelfBalance) {
        this.investSelfBalance = investSelfBalance;
    }

    public String getInvestMatchContract() {
        return investMatchContract;
    }

    public void setInvestMatchContract(String investMatchContract) {
        this.investMatchContract = investMatchContract;
    }

    public BigDecimal getInvestMatchLoanAmount() {
        return investMatchLoanAmount;
    }

    public void setInvestMatchLoanAmount(BigDecimal investMatchLoanAmount) {
        this.investMatchLoanAmount = investMatchLoanAmount;
    }

    public String getInvestMatchLoanDay() {
        return investMatchLoanDay;
    }

    public void setInvestMatchLoanDay(String investMatchLoanDay) {
        this.investMatchLoanDay = investMatchLoanDay;
    }

    public String getInvestMatchExpiryDate() {
        return investMatchExpiryDate;
    }

    public void setInvestMatchExpiryDate(String investMatchExpiryDate) {
        this.investMatchExpiryDate = investMatchExpiryDate;
    }

    public String getInvestMatchInterestRate() {
        return investMatchInterestRate;
    }

    public void setInvestMatchInterestRate(String investMatchInterestRate) {
        this.investMatchInterestRate = investMatchInterestRate;
    }

    public BigDecimal getInvestMatchBalance() {
        return investMatchBalance;
    }

    public void setInvestMatchBalance(BigDecimal investMatchBalance) {
        this.investMatchBalance = investMatchBalance;
    }

    public String getInvestSettleWay() {
        return investSettleWay;
    }

    public void setInvestSettleWay(String investSettleWay) {
        this.investSettleWay = investSettleWay;
    }

    public String getInvestHolidayDate() {
        return investHolidayDate;
    }

    public void setInvestHolidayDate(String investHolidayDate) {
        this.investHolidayDate = investHolidayDate;
    }

    public String getInvestInsuranceDate() {
        return investInsuranceDate;
    }

    public void setInvestInsuranceDate(String investInsuranceDate) {
        this.investInsuranceDate = investInsuranceDate;
    }

    public BigDecimal getInvestInsuranceBalance() {
        return investInsuranceBalance;
    }

    public void setInvestInsuranceBalance(BigDecimal investInsuranceBalance) {
        this.investInsuranceBalance = investInsuranceBalance;
    }

    public String getInvestNature() {
        return investNature;
    }

    public void setInvestNature(String investNature) {
        this.investNature = investNature;
    }

    public String getInvestBusinessTypes() {
        return investBusinessTypes;
    }

    public void setInvestBusinessTypes(String investBusinessTypes) {
        this.investBusinessTypes = investBusinessTypes;
    }

    public String getInvestGuaranteeMethod() {
        return investGuaranteeMethod;
    }

    public void setInvestGuaranteeMethod(String investGuaranteeMethod) {
        this.investGuaranteeMethod = investGuaranteeMethod;
    }

    public BigDecimal getInvestMortgageValue() {
        return investMortgageValue;
    }

    public void setInvestMortgageValue(BigDecimal investMortgageValue) {
        this.investMortgageValue = investMortgageValue;
    }

    public String getInvestFiveClass() {
        return investFiveClass;
    }

    public void setInvestFiveClass(String investFiveClass) {
        this.investFiveClass = investFiveClass;
    }

    public String getInvestCreditRating() {
        return investCreditRating;
    }

    public void setInvestCreditRating(String investCreditRating) {
        this.investCreditRating = investCreditRating;
    }

    public String getInvestActualPeople() {
        return investActualPeople;
    }

    public void setInvestActualPeople(String investActualPeople) {
        this.investActualPeople = investActualPeople;
    }

    public String getInvestActualPhone() {
        return investActualPhone;
    }

    public void setInvestActualPhone(String investActualPhone) {
        this.investActualPhone = investActualPhone;
    }

    public String getInvestManagementBank() {
        return investManagementBank;
    }

    public void setInvestManagementBank(String investManagementBank) {
        this.investManagementBank = investManagementBank;
    }

    public String getInvestAccountManager() {
        return investAccountManager;
    }

    public void setInvestAccountManager(String investAccountManager) {
        this.investAccountManager = investAccountManager;
    }

    public String getInvestAccountPhone() {
        return investAccountPhone;
    }

    public void setInvestAccountPhone(String investAccountPhone) {
        this.investAccountPhone = investAccountPhone;
    }

    public String getInvestGuaranteeCompany() {
        return investGuaranteeCompany;
    }

    public void setInvestGuaranteeCompany(String investGuaranteeCompany) {
        this.investGuaranteeCompany = investGuaranteeCompany;
    }

    public String getInvestCompanyManager() {
        return investCompanyManager;
    }

    public void setInvestCompanyManager(String investCompanyManager) {
        this.investCompanyManager = investCompanyManager;
    }

    public String getInvestCompanyPhone() {
        return investCompanyPhone;
    }

    public void setInvestCompanyPhone(String investCompanyPhone) {
        this.investCompanyPhone = investCompanyPhone;
    }

    public String getInvestOperationAuthority() {
        return investOperationAuthority;
    }

    public void setInvestOperationAuthority(String investOperationAuthority) {
        this.investOperationAuthority = investOperationAuthority;
    }

    public String getInvestOperationManeger() {
        return investOperationManeger;
    }

    public void setInvestOperationManeger(String investOperationManeger) {
        this.investOperationManeger = investOperationManeger;
    }

    public String getInvestOperationPhone() {
        return investOperationPhone;
    }

    public void setInvestOperationPhone(String investOperationPhone) {
        this.investOperationPhone = investOperationPhone;
    }

    @Override
    protected Serializable pkVal() {
        return this.investId;
    }

    @Override
    public String toString() {
        return "Invest{" +
        "investId=" + investId +
        ", investConpanyName=" + investConpanyName +
        ", investArea=" + investArea +
        ", investAddress=" + investAddress +
        ", investLegalRepresentative=" + investLegalRepresentative +
        ", investProjectName=" + investProjectName +
        ", investCreditAmount=" + investCreditAmount +
        ", investTotalBalance=" + investTotalBalance +
        ", investSelfContract=" + investSelfContract +
        ", investSelfLoanAmount=" + investSelfLoanAmount +
        ", investSelfLoanDay=" + investSelfLoanDay +
        ", investSelfExpiryDate=" + investSelfExpiryDate +
        ", investSelfInterestRate=" + investSelfInterestRate +
        ", investSelfBalance=" + investSelfBalance +
        ", investMatchContract=" + investMatchContract +
        ", investMatchLoanAmount=" + investMatchLoanAmount +
        ", investMatchLoanDay=" + investMatchLoanDay +
        ", investMatchExpiryDate=" + investMatchExpiryDate +
        ", investMatchInterestRate=" + investMatchInterestRate +
        ", investMatchBalance=" + investMatchBalance +
        ", investSettleWay=" + investSettleWay +
        ", investHolidayDate=" + investHolidayDate +
        ", investInsuranceDate=" + investInsuranceDate +
        ", investInsuranceBalance=" + investInsuranceBalance +
        ", investNature=" + investNature +
        ", investBusinessTypes=" + investBusinessTypes +
        ", investGuaranteeMethod=" + investGuaranteeMethod +
        ", investMortgageValue=" + investMortgageValue +
        ", investFiveClass=" + investFiveClass +
        ", investCreditRating=" + investCreditRating +
        ", investActualPeople=" + investActualPeople +
        ", investActualPhone=" + investActualPhone +
        ", investManagementBank=" + investManagementBank +
        ", investAccountManager=" + investAccountManager +
        ", investAccountPhone=" + investAccountPhone +
        ", investGuaranteeCompany=" + investGuaranteeCompany +
        ", investCompanyManager=" + investCompanyManager +
        ", investCompanyPhone=" + investCompanyPhone +
        ", investOperationAuthority=" + investOperationAuthority +
        ", investOperationManeger=" + investOperationManeger +
        ", investOperationPhone=" + investOperationPhone +
        "}";
    }
}
