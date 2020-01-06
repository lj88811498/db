package com.youedata.nncloud.modular.nanning.model.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvestVo {
	//未评定数量
	private Integer countRating;
	//已评定数量
	private Integer countAssessed;
	//百分比
	private String proportion;
	//级别
	private String level;
	//项目总数
	private Integer projectToltal;
	//项目金额
	private Double amount;
	//累积
	private Double accumulate;
	//余额-银行平台
	private Double bankBalance;
	//累积-平台配套
	private Double matchBalance;
	//银行百分比
	private String bankproportion;
	//正常
	private Double normal;
	//初级
	private Double secondary;
	//关注
	private Double follow;
	//可疑
	private String suspicious;
	//损失
	private String loss;
	//利率
	private String interestRate;
	//id
	private String interestRateId;
	//季度
	private String investLoanQuarter;
	//年份
	private String investLoanYear;
	//放款额-平台银行自营
	private BigDecimal investSelfLoanAmount;
	//放款额-平台配套
	private BigDecimal investMatchLoanAmount;
	//授信金额
	private BigDecimal investCreditAmount;
	//项目名称
	private String projectName;
	public Integer getCountRating() {
		return countRating;
	}
	public void setCountRating(Integer countRating) {
		this.countRating = countRating;
	}
	public Integer getCountAssessed() {
		return countAssessed;
	}
	public void setCountAssessed(Integer countAssessed) {
		this.countAssessed = countAssessed;
	}
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getProjectToltal() {
		return projectToltal;
	}
	public void setProjectToltal(Integer projectToltal) {
		this.projectToltal = projectToltal;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAccumulate() {
		return accumulate;
	}
	public void setAccumulate(Double accumulate) {
		this.accumulate = accumulate;
	}
	public Double getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(Double bankBalance) {
		this.bankBalance = bankBalance;
	}
	public Double getMatchBalance() {
		return matchBalance;
	}
	public void setMatchBalance(Double matchBalance) {
		this.matchBalance = matchBalance;
	}
	public String getBankproportion() {
		return bankproportion;
	}
	public void setBankproportion(String bankproportion) {
		this.bankproportion = bankproportion;
	}
	public Double getNormal() {
		return normal;
	}
	public void setNormal(Double normal) {
		this.normal = normal;
	}
	public Double getSecondary() {
		return secondary;
	}
	public void setSecondary(Double secondary) {
		this.secondary = secondary;
	}
	public Double getFollow() {
		return follow;
	}
	public void setFollow(Double follow) {
		this.follow = follow;
	}
	public String getSuspicious() {
		return suspicious;
	}
	public void setSuspicious(String suspicious) {
		this.suspicious = suspicious;
	}
	public String getLoss() {
		return loss;
	}
	public void setLoss(String loss) {
		this.loss = loss;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getInterestRateId() {
		return interestRateId;
	}
	public void setInterestRateId(String interestRateId) {
		this.interestRateId = interestRateId;
	}
	public String getInvestLoanQuarter() {
		return investLoanQuarter;
	}
	public void setInvestLoanQuarter(String investLoanQuarter) {
		this.investLoanQuarter = investLoanQuarter;
	}
	public String getInvestLoanYear() {
		return investLoanYear;
	}
	public void setInvestLoanYear(String investLoanYear) {
		this.investLoanYear = investLoanYear;
	}
	public BigDecimal getInvestSelfLoanAmount() {
		return investSelfLoanAmount;
	}
	public void setInvestSelfLoanAmount(BigDecimal investSelfLoanAmount) {
		this.investSelfLoanAmount = investSelfLoanAmount;
	}
	public BigDecimal getInvestMatchLoanAmount() {
		return investMatchLoanAmount;
	}
	public void setInvestMatchLoanAmount(BigDecimal investMatchLoanAmount) {
		this.investMatchLoanAmount = investMatchLoanAmount;
	}
	public BigDecimal getInvestCreditAmount() {
		return investCreditAmount;
	}
	public void setInvestCreditAmount(BigDecimal investCreditAmount) {
		this.investCreditAmount = investCreditAmount;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
	
	
	
}
