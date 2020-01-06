package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 财务填报数据查询
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@ApiModel
public class FinanceData extends Model<FinanceData> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "industry_id", type = IdType.AUTO)
    private Integer financeId;
    /**
     * 关联公司id
     */
    private Integer financeCompanyId;
    /**
     * 营收入
     */
    private String financeIncome;
    /**
     * 主营业收入
     */
    private String financeMainIncome;
    /**
     * 成本
     */
    private String financeCost;
    /**
     * 主营成本
     */
    private String financeMainCost;
    /**
     * 营业税及附加
     */
    private String financeTaxAll;
    /**
     * 主营业税及附加
     */
    private String financeMainTax;
    /**
     * 销售费用
     */
    private String financeSell;
    /**
     * 管理费用
     */
    private String financeManage;
    /**
     * 税收
     */
    private String financeTax;
    /**
     * 财务费用
     */
    private String financeFinanceCost;
    /**
     * 利息收入
     */
    private String financeInterest;
    /**
     * 利息支出
     */
    private String financeInterestCost;
    /**
     * 资产减值损失
     */
    private String financeDevalue;
    /**
     * 公允价值变动收益
     */
    private String financeChange;
    /**
     * 投资收益
     */
    private String financeInvest;
    /**
     * 营业利润
     */
    private String financeProfit;
    /**
     * 营业外收入
     */
    private String financeOther;
    /**
     * 政府补助
     */
    private String financeGov;
    /**
     * 营业外支出
     */
    private String financeOtherCost;
    /**
     * 利润总额
     */
    private String financeInterestAll;
    /**
     * 日期
     */
    private Date financeDate;


    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Integer getFinanceCompanyId() {
        return financeCompanyId;
    }

    public void setFinanceCompanyId(Integer financeCompanyId) {
        this.financeCompanyId = financeCompanyId;
    }

    public String getFinanceIncome() {
        return financeIncome;
    }

    public void setFinanceIncome(String financeIncome) {
        this.financeIncome = financeIncome;
    }

    public String getFinanceMainIncome() {
        return financeMainIncome;
    }

    public void setFinanceMainIncome(String financeMainIncome) {
        this.financeMainIncome = financeMainIncome;
    }

    public String getFinanceCost() {
        return financeCost;
    }

    public void setFinanceCost(String financeCost) {
        this.financeCost = financeCost;
    }

    public String getFinanceMainCost() {
        return financeMainCost;
    }

    public void setFinanceMainCost(String financeMainCost) {
        this.financeMainCost = financeMainCost;
    }

    public String getFinanceTaxAll() {
        return financeTaxAll;
    }

    public void setFinanceTaxAll(String financeTaxAll) {
        this.financeTaxAll = financeTaxAll;
    }

    public String getFinanceMainTax() {
        return financeMainTax;
    }

    public void setFinanceMainTax(String financeMainTax) {
        this.financeMainTax = financeMainTax;
    }

    public String getFinanceSell() {
        return financeSell;
    }

    public void setFinanceSell(String financeSell) {
        this.financeSell = financeSell;
    }

    public String getFinanceManage() {
        return financeManage;
    }

    public void setFinanceManage(String financeManage) {
        this.financeManage = financeManage;
    }

    public String getFinanceTax() {
        return financeTax;
    }

    public void setFinanceTax(String financeTax) {
        this.financeTax = financeTax;
    }

    public String getFinanceFinanceCost() {
        return financeFinanceCost;
    }

    public void setFinanceFinanceCost(String financeFinanceCost) {
        this.financeFinanceCost = financeFinanceCost;
    }

    public String getFinanceInterest() {
        return financeInterest;
    }

    public void setFinanceInterest(String financeInterest) {
        this.financeInterest = financeInterest;
    }

    public String getFinanceInterestCost() {
        return financeInterestCost;
    }

    public void setFinanceInterestCost(String financeInterestCost) {
        this.financeInterestCost = financeInterestCost;
    }

    public String getFinanceDevalue() {
        return financeDevalue;
    }

    public void setFinanceDevalue(String financeDevalue) {
        this.financeDevalue = financeDevalue;
    }

    public String getFinanceChange() {
        return financeChange;
    }

    public void setFinanceChange(String financeChange) {
        this.financeChange = financeChange;
    }

    public String getFinanceInvest() {
        return financeInvest;
    }

    public void setFinanceInvest(String financeInvest) {
        this.financeInvest = financeInvest;
    }

    public String getFinanceProfit() {
        return financeProfit;
    }

    public void setFinanceProfit(String financeProfit) {
        this.financeProfit = financeProfit;
    }

    public String getFinanceOther() {
        return financeOther;
    }

    public void setFinanceOther(String financeOther) {
        this.financeOther = financeOther;
    }

    public String getFinanceGov() {
        return financeGov;
    }

    public void setFinanceGov(String financeGov) {
        this.financeGov = financeGov;
    }

    public String getFinanceOtherCost() {
        return financeOtherCost;
    }

    public void setFinanceOtherCost(String financeOtherCost) {
        this.financeOtherCost = financeOtherCost;
    }

    public String getFinanceInterestAll() {
        return financeInterestAll;
    }

    public void setFinanceInterestAll(String financeInterestAll) {
        this.financeInterestAll = financeInterestAll;
    }

    public Date getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(Date financeDate) {
        this.financeDate = financeDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.financeId;
    }

    @Override
    public String toString() {
        return "FinanceData{" +
        "financeId=" + financeId +
        ", financeCompanyId=" + financeCompanyId +
        ", financeIncome=" + financeIncome +
        ", financeMainIncome=" + financeMainIncome +
        ", financeCost=" + financeCost +
        ", financeMainCost=" + financeMainCost +
        ", financeTaxAll=" + financeTaxAll +
        ", financeMainTax=" + financeMainTax +
        ", financeSell=" + financeSell +
        ", financeManage=" + financeManage +
        ", financeTax=" + financeTax +
        ", financeFinanceCost=" + financeFinanceCost +
        ", financeInterest=" + financeInterest +
        ", financeInterestCost=" + financeInterestCost +
        ", financeDevalue=" + financeDevalue +
        ", financeChange=" + financeChange +
        ", financeInvest=" + financeInvest +
        ", financeProfit=" + financeProfit +
        ", financeOther=" + financeOther +
        ", financeGov=" + financeGov +
        ", financeOtherCost=" + financeOtherCost +
        ", financeInterestAll=" + financeInterestAll +
        ", financeDate=" + financeDate +
        "}";
    }
}
