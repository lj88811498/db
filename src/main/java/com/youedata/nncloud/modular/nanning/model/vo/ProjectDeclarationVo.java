package com.youedata.nncloud.modular.nanning.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectDeclarationVo {
	//申报名称
	private String declare;
	//新增销售收入
	private BigDecimal newSales;
	//申请资金
	private BigDecimal decAmount;
	//建设截止年限
	private Date endDate;
	//新增税金
	private BigDecimal newTax;
	//总投资
	private BigDecimal investCount;
	//自有资金
	private BigDecimal investSelf;
	//申报时间
	private Date yeardate;
	//建设地点
	private String address;
	//新增利润
	private BigDecimal newProfit;
	//建设起始年限
	private Date startDate;
	//负责人
	private String corporateDirector;
	//项目名称
	private String name;
	//项目申报编号
	private String id;
	//联系电话
	private String connectPhone;
	public String getDeclare() {
		return declare;
	}
	public void setDeclare(String declare) {
		this.declare = declare;
	}
	public BigDecimal getNewSales() {
		return newSales;
	}
	public void setNewSales(BigDecimal newSales) {
		this.newSales = newSales;
	}
	public BigDecimal getDecAmount() {
		return decAmount;
	}
	public void setDecAmount(BigDecimal decAmount) {
		this.decAmount = decAmount;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getNewTax() {
		return newTax;
	}
	public void setNewTax(BigDecimal newTax) {
		this.newTax = newTax;
	}
	public BigDecimal getInvestCount() {
		return investCount;
	}
	public void setInvestCount(BigDecimal investCount) {
		this.investCount = investCount;
	}
	public BigDecimal getInvestSelf() {
		return investSelf;
	}
	public void setInvestSelf(BigDecimal investSelf) {
		this.investSelf = investSelf;
	}
	public Date getYeardate() {
		return yeardate;
	}
	public void setYeardate(Date yeardate) {
		this.yeardate = yeardate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getNewProfit() {
		return newProfit;
	}
	public void setNewProfit(BigDecimal newProfit) {
		this.newProfit = newProfit;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCorporateDirector() {
		return corporateDirector;
	}
	public void setCorporateDirector(String corporateDirector) {
		this.corporateDirector = corporateDirector;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getConnectPhone() {
		return connectPhone;
	}
	public void setConnectPhone(String connectPhone) {
		this.connectPhone = connectPhone;
	}
	
}
