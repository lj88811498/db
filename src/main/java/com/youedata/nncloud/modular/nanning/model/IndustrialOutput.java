package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 工业主要产品产量表
 * </p>
 *
 * @author Monkey
 * @since 2018-12-12
 */
@ApiModel
public class IndustrialOutput extends Model<IndustrialOutput> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "industrial_output_id", type = IdType.AUTO)
    private Integer industrialOutputId;

    /**
     * 产品名称
     */
    private String industrialOutputName;
    /**
     * 计量单位
     */
    private String industrialOutputUnit;
    /**
     * 当前月份产值
     */
    private Double industrialOutputCurrent;
    /**
     * 月份止，累计产值
     */
    private Double industrialOutputGrandTotal;
    /**
     * 同比
     */
    private Double industrialOutputComparison;
    /**
     * 月份（201809）
     */
    private Integer industrialOutputTime;


    public String getIndustrialOutputName() {
        return industrialOutputName;
    }

    public void setIndustrialOutputName(String industrialOutputName) {
        this.industrialOutputName = industrialOutputName;
    }

    public String getIndustrialOutputUnit() {
        return industrialOutputUnit;
    }

    public void setIndustrialOutputUnit(String industrialOutputUnit) {
        this.industrialOutputUnit = industrialOutputUnit;
    }

    public Double getIndustrialOutputCurrent() {
        return industrialOutputCurrent;
    }

    public void setIndustrialOutputCurrent(Double industrialOutputCurrent) {
        this.industrialOutputCurrent = industrialOutputCurrent;
    }

    public Double getIndustrialOutputGrandTotal() {
        return industrialOutputGrandTotal;
    }

    public void setIndustrialOutputGrandTotal(Double industrialOutputGrandTotal) {
        this.industrialOutputGrandTotal = industrialOutputGrandTotal;
    }

    public Double getIndustrialOutputComparison() {
        return industrialOutputComparison;
    }

    public void setIndustrialOutputComparison(Double industrialOutputComparison) {
        this.industrialOutputComparison = industrialOutputComparison;
    }

    public Integer getIndustrialOutputTime() {
        return industrialOutputTime;
    }

    public void setIndustrialOutputTime(Integer industrialOutputTime) {
        this.industrialOutputTime = industrialOutputTime;
    }

    public Integer getIndustrialOutputId() {
        return industrialOutputId;
    }

    public void setIndustrialOutputId(Integer industrialOutputId) {
        this.industrialOutputId = industrialOutputId;
    }

    @Override
    protected Serializable pkVal() {
        return this.industrialOutputId;
    }

    @Override
    public String toString() {
        return "IndustrialOutput{" +
                "industrialOutputId=" + industrialOutputId +
                ", industrialOutputName='" + industrialOutputName + '\'' +
                ", industrialOutputUnit='" + industrialOutputUnit + '\'' +
                ", industrialOutputCurrent=" + industrialOutputCurrent +
                ", industrialOutputGrandTotal=" + industrialOutputGrandTotal +
                ", industrialOutputComparison=" + industrialOutputComparison +
                ", industrialOutputTime=" + industrialOutputTime +
                '}';
    }
}
