package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 工业运行走势分析
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@ApiModel
public class IndustrialStatistics extends Model<IndustrialStatistics> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "industrial_statistics_id", type = IdType.AUTO)
    private Integer industrialStatisticsId;

    /**
     * 企业id
     */
    private Integer industrialStatisticsEnterpriseId;

    /**
     * 企业名称
     */
    private String industrialStatisticsCompanyName;
    /**
     * 所属区域
     */
    private String industrialStatisticsRegion;
    /**
     * 所属行业
     */
    private String industrialStatisticsIndustry;
    /**
     * 工商注册类型
     */
    private String industrialStatisticsRegistration;
    /**
     * 单位性质
     */
    private String industrialStatisticsProperty;
    /**
     * 工业总投资
     */
    private String industrialStatisticsInvestment;
    /**
     * 主营业收入
     */
    private String industrialStatisticsIncome;
    /**
     * 税金
     */
    private String industrialStatisticsTax;
    /**
     * 利润
     */
    private String industrialStatisticsProfit;
    /**
     * 总产值
     */
    private String industrialStatisticsOutputValue;
    /**
     * 总产量
     */
    private String industrialStatisticsOutputQuantity;
    /**
     * 年
     */
    private Integer industrialStatisticsYear;
    /**
     * 月
     */
    private Integer industrialStatisticsMonth;

    /**
     * 年月
     */
    private Integer industrialStatisticsYearMonth;


    public Integer getIndustrialStatisticsId() {
        return industrialStatisticsId;
    }

    public void setIndustrialStatisticsId(Integer industrialStatisticsId) {
        this.industrialStatisticsId = industrialStatisticsId;
    }

    public String getIndustrialStatisticsCompanyName() {
        return industrialStatisticsCompanyName;
    }

    public void setIndustrialStatisticsCompanyName(String industrialStatisticsCompanyName) {
        this.industrialStatisticsCompanyName = industrialStatisticsCompanyName;
    }

    public String getIndustrialStatisticsRegion() {
        return industrialStatisticsRegion;
    }

    public void setIndustrialStatisticsRegion(String industrialStatisticsRegion) {
        this.industrialStatisticsRegion = industrialStatisticsRegion;
    }

    public String getIndustrialStatisticsIndustry() {
        return industrialStatisticsIndustry;
    }

    public void setIndustrialStatisticsIndustry(String industrialStatisticsIndustry) {
        this.industrialStatisticsIndustry = industrialStatisticsIndustry;
    }

    public String getIndustrialStatisticsRegistration() {
        return industrialStatisticsRegistration;
    }

    public void setIndustrialStatisticsRegistration(String industrialStatisticsRegistration) {
        this.industrialStatisticsRegistration = industrialStatisticsRegistration;
    }

    public String getIndustrialStatisticsProperty() {
        return industrialStatisticsProperty;
    }

    public void setIndustrialStatisticsProperty(String industrialStatisticsProperty) {
        this.industrialStatisticsProperty = industrialStatisticsProperty;
    }

    public String getIndustrialStatisticsInvestment() {
        return industrialStatisticsInvestment;
    }

    public void setIndustrialStatisticsInvestment(String industrialStatisticsInvestment) {
        this.industrialStatisticsInvestment = industrialStatisticsInvestment;
    }

    public String getIndustrialStatisticsIncome() {
        return industrialStatisticsIncome;
    }

    public void setIndustrialStatisticsIncome(String industrialStatisticsIncome) {
        this.industrialStatisticsIncome = industrialStatisticsIncome;
    }

    public String getIndustrialStatisticsTax() {
        return industrialStatisticsTax;
    }

    public void setIndustrialStatisticsTax(String industrialStatisticsTax) {
        this.industrialStatisticsTax = industrialStatisticsTax;
    }

    public String getIndustrialStatisticsProfit() {
        return industrialStatisticsProfit;
    }

    public void setIndustrialStatisticsProfit(String industrialStatisticsProfit) {
        this.industrialStatisticsProfit = industrialStatisticsProfit;
    }

    public String getIndustrialStatisticsOutputValue() {
        return industrialStatisticsOutputValue;
    }

    public void setIndustrialStatisticsOutputValue(String industrialStatisticsOutputValue) {
        this.industrialStatisticsOutputValue = industrialStatisticsOutputValue;
    }

    public String getIndustrialStatisticsOutputQuantity() {
        return industrialStatisticsOutputQuantity;
    }

    public void setIndustrialStatisticsOutputQuantity(String industrialStatisticsOutputQuantity) {
        this.industrialStatisticsOutputQuantity = industrialStatisticsOutputQuantity;
    }

    public Integer getIndustrialStatisticsYear() {
        return industrialStatisticsYear;
    }

    public void setIndustrialStatisticsYear(Integer industrialStatisticsYear) {
        this.industrialStatisticsYear = industrialStatisticsYear;
    }

    public Integer getIndustrialStatisticsMonth() {
        return industrialStatisticsMonth;
    }

    public void setIndustrialStatisticsMonth(Integer industrialStatisticsMonth) {
        this.industrialStatisticsMonth = industrialStatisticsMonth;
    }

    public Integer getIndustrialStatisticsEnterpriseId() {
        return industrialStatisticsEnterpriseId;
    }

    public void setIndustrialStatisticsEnterpriseId(Integer industrialStatisticsEnterpriseId) {
        this.industrialStatisticsEnterpriseId = industrialStatisticsEnterpriseId;
    }

    @Override
    protected Serializable pkVal() {
        return this.industrialStatisticsId;
    }

    public Integer getIndustrialStatisticsYearMonth() {
        return industrialStatisticsYearMonth;
    }

    public void setIndustrialStatisticsYearMonth(Integer industrialStatisticsYearMonth) {
        this.industrialStatisticsYearMonth = industrialStatisticsYearMonth;
    }

    @Override
    public String toString() {
        return "IndustrialStatistics{" +
                "industrialStatisticsId=" + industrialStatisticsId +
                ", industrialStatisticsEnterpriseId=" + industrialStatisticsEnterpriseId +
                ", industrialStatisticsCompanyName='" + industrialStatisticsCompanyName + '\'' +
                ", industrialStatisticsRegion='" + industrialStatisticsRegion + '\'' +
                ", industrialStatisticsIndustry='" + industrialStatisticsIndustry + '\'' +
                ", industrialStatisticsRegistration='" + industrialStatisticsRegistration + '\'' +
                ", industrialStatisticsProperty='" + industrialStatisticsProperty + '\'' +
                ", industrialStatisticsInvestment='" + industrialStatisticsInvestment + '\'' +
                ", industrialStatisticsIncome='" + industrialStatisticsIncome + '\'' +
                ", industrialStatisticsTax='" + industrialStatisticsTax + '\'' +
                ", industrialStatisticsProfit='" + industrialStatisticsProfit + '\'' +
                ", industrialStatisticsOutputValue='" + industrialStatisticsOutputValue + '\'' +
                ", industrialStatisticsOutputQuantity='" + industrialStatisticsOutputQuantity + '\'' +
                ", industrialStatisticsYear=" + industrialStatisticsYear +
                ", industrialStatisticsMonth=" + industrialStatisticsMonth +
                ", industrialStatisticsYearMonth=" + industrialStatisticsYearMonth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndustrialStatistics)) return false;
        IndustrialStatistics that = (IndustrialStatistics) o;
        return Objects.equals(industrialStatisticsId, that.industrialStatisticsId) &&
                Objects.equals(industrialStatisticsEnterpriseId, that.industrialStatisticsEnterpriseId) &&
                Objects.equals(industrialStatisticsCompanyName, that.industrialStatisticsCompanyName) &&
                Objects.equals(industrialStatisticsRegion, that.industrialStatisticsRegion) &&
                Objects.equals(industrialStatisticsIndustry, that.industrialStatisticsIndustry) &&
                Objects.equals(industrialStatisticsRegistration, that.industrialStatisticsRegistration) &&
                Objects.equals(industrialStatisticsProperty, that.industrialStatisticsProperty) &&
                Objects.equals(industrialStatisticsInvestment, that.industrialStatisticsInvestment) &&
                Objects.equals(industrialStatisticsIncome, that.industrialStatisticsIncome) &&
                Objects.equals(industrialStatisticsTax, that.industrialStatisticsTax) &&
                Objects.equals(industrialStatisticsProfit, that.industrialStatisticsProfit) &&
                Objects.equals(industrialStatisticsOutputValue, that.industrialStatisticsOutputValue) &&
                Objects.equals(industrialStatisticsOutputQuantity, that.industrialStatisticsOutputQuantity) &&
                Objects.equals(industrialStatisticsYear, that.industrialStatisticsYear) &&
                Objects.equals(industrialStatisticsMonth, that.industrialStatisticsMonth) &&
                Objects.equals(industrialStatisticsYearMonth, that.industrialStatisticsYearMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(industrialStatisticsId, industrialStatisticsEnterpriseId, industrialStatisticsCompanyName, industrialStatisticsRegion, industrialStatisticsIndustry, industrialStatisticsRegistration, industrialStatisticsProperty, industrialStatisticsInvestment, industrialStatisticsIncome, industrialStatisticsTax, industrialStatisticsProfit, industrialStatisticsOutputValue, industrialStatisticsOutputQuantity, industrialStatisticsYear, industrialStatisticsMonth, industrialStatisticsYearMonth);
    }
}
