package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 重点企业预警
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@ApiModel
public class CompanyWarn extends Model<CompanyWarn> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int companyWarnId;
    /**
     * 企业
     */
    private int companyWarnUserId;

    /**
     * 企业名称
     */
    private String companyWarnUserName;
    /**
     * 年月份
     */
    private String companyWarnYearMonth;
    /**
     * 年产值(单位:亿元)
     */
    private String companyWarnOutput;
    /**
     * 年产值排名
     */
    private String companyWarnRank;
    /**
     * 年产值排名变化(较上月)
     */
    private String companyWarnRankChange;
    /**
     * 产值变化(单位:亿元)
     */
    private String companyWarnOutputChange;
    /**
     * 最高产值占比
     */
    private String companyWarnOutputProportion;
    /**
     * 产值同比增率
     */
    private String companyWarnYearRate;
    /**
     * 产值环比增率
     */
    private String companyWarnLastRate;


    public int getCompanyWarnId() {
        return companyWarnId;
    }

    public void setCompanyWarnId(int companyWarnId) {
        this.companyWarnId = companyWarnId;
    }

    public String getCompanyWarnUserName() {
        return companyWarnUserName;
    }

    public void setCompanyWarnUserName(String companyWarnUserName) {
        this.companyWarnUserName = companyWarnUserName;
    }

    public int getCompanyWarnUserId() {
        return companyWarnUserId;
    }

    public void setCompanyWarnUserId(int companyWarnUserId) {
        this.companyWarnUserId = companyWarnUserId;
    }

    public String getCompanyWarnYearMonth() {
        return companyWarnYearMonth;
    }

    public void setCompanyWarnYearMonth(String companyWarnYearMonth) {
        this.companyWarnYearMonth = companyWarnYearMonth;
    }

    public String getCompanyWarnOutput() {
        return companyWarnOutput;
    }

    public void setCompanyWarnOutput(String companyWarnOutput) {
        this.companyWarnOutput = companyWarnOutput;
    }

    public String getCompanyWarnRank() {
        return companyWarnRank;
    }

    public void setCompanyWarnRank(String companyWarnRank) {
        this.companyWarnRank = companyWarnRank;
    }

    public String getCompanyWarnRankChange() {
        return companyWarnRankChange;
    }

    public void setCompanyWarnRankChange(String companyWarnRankChange) {
        this.companyWarnRankChange = companyWarnRankChange;
    }

    public String getCompanyWarnOutputChange() {
        return companyWarnOutputChange;
    }

    public void setCompanyWarnOutputChange(String companyWarnOutputChange) {
        this.companyWarnOutputChange = companyWarnOutputChange;
    }

    public String getCompanyWarnOutputProportion() {
        return companyWarnOutputProportion;
    }

    public void setCompanyWarnOutputProportion(String companyWarnOutputProportion) {
        this.companyWarnOutputProportion = companyWarnOutputProportion;
    }

    public String getCompanyWarnYearRate() {
        return companyWarnYearRate;
    }

    public void setCompanyWarnYearRate(String companyWarnYearRate) {
        this.companyWarnYearRate = companyWarnYearRate;
    }

    public String getCompanyWarnLastRate() {
        return companyWarnLastRate;
    }

    public void setCompanyWarnLastRate(String companyWarnLastRate) {
        this.companyWarnLastRate = companyWarnLastRate;
    }

    @Override
    protected Serializable pkVal() {
        return this.companyWarnId;
    }

    @Override
    public String toString() {
        return "CompanyWarn{" +
                "companyWarnId='" + companyWarnId + '\'' +
                ", companyWarnUserId=" + companyWarnUserId +
                ", companyWarnUserName=" + companyWarnUserName +
                ", companyWarnYearMonth='" + companyWarnYearMonth + '\'' +
                ", companyWarnOutput='" + companyWarnOutput + '\'' +
                ", companyWarnRank='" + companyWarnRank + '\'' +
                ", companyWarnRankChange='" + companyWarnRankChange + '\'' +
                ", companyWarnOutputChange='" + companyWarnOutputChange + '\'' +
                ", companyWarnOutputProportion='" + companyWarnOutputProportion + '\'' +
                ", companyWarnYearRate='" + companyWarnYearRate + '\'' +
                ", companyWarnLastRate='" + companyWarnLastRate + '\'' +
                '}';
    }
}
