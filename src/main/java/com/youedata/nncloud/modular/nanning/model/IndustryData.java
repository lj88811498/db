package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 工业填报数据查询
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@ApiModel
public class IndustryData extends Model<IndustryData> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "industry_id", type = IdType.AUTO)
    private Integer industryId;
    /**
     * 关联公司id
     */
    private Integer industryCompanyId;
    /**
     * 工业总产值
     */
    private String industryOutput;
    /**
     * 销售产值
     */
    private String industrySell;
    /**
     * 出口交货值
     */
    private String industryExport;
    /**
     * 小分类总产值
     */
    private String industrySubclass;
    /**
     * 产量
     */
    private String industryYield;
    /**
     * 日期
     */
    private Date industryDate;


    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getIndustryCompanyId() {
        return industryCompanyId;
    }

    public void setIndustryCompanyId(Integer industryCompanyId) {
        this.industryCompanyId = industryCompanyId;
    }

    public String getIndustryOutput() {
        return industryOutput;
    }

    public void setIndustryOutput(String industryOutput) {
        this.industryOutput = industryOutput;
    }

    public String getIndustrySell() {
        return industrySell;
    }

    public void setIndustrySell(String industrySell) {
        this.industrySell = industrySell;
    }

    public String getIndustryExport() {
        return industryExport;
    }

    public void setIndustryExport(String industryExport) {
        this.industryExport = industryExport;
    }

    public String getIndustrySubclass() {
        return industrySubclass;
    }

    public void setIndustrySubclass(String industrySubclass) {
        this.industrySubclass = industrySubclass;
    }

    public String getIndustryYield() {
        return industryYield;
    }

    public void setIndustryYield(String industryYield) {
        this.industryYield = industryYield;
    }

    public Date getIndustryDate() {
        return industryDate;
    }

    public void setIndustryDate(Date industryDate) {
        this.industryDate = industryDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.industryId;
    }

    @Override
    public String toString() {
        return "IndustryData{" +
        "industryId=" + industryId +
        ", industryCompanyId=" + industryCompanyId +
        ", industryOutput=" + industryOutput +
        ", industrySell=" + industrySell +
        ", industryExport=" + industryExport +
        ", industrySubclass=" + industrySubclass +
        ", industryYield=" + industryYield +
        ", industryDate=" + industryDate +
        "}";
    }
}
