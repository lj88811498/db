package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Map;

/**
 * @Author:huangkai
 * @Date: 2018/12/18 15:05
 */
public class IndustrialOutputVo {
    /**
     * 产品名称
     */
    private String industrialOutputName;
    /**
     * 计量单位
     */
    private String industrialOutputUnit;

    private Map keyMap;
  /*  *//**
     * 当前月份产值
     *//*
    private Map industrialOutputCurrent;
    *//**
     * 月份止，累计产值
     *//*
    private Map industrialOutputGrandTotal;
    *//**
     * 同比
     *//*
    private Map industrialOutputComparison;*/

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

    public Map getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map keyMap) {
        this.keyMap = keyMap;
    }
}

