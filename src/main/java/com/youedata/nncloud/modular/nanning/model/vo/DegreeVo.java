package com.youedata.nncloud.modular.nanning.model.vo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class DegreeVo {
    /**
     * 当月问题件数
     */
    private int monthCount;
    /**
     * 当月问题解决数
     */
    private int monthSolveCount;
    /**
     * 整体满意度
     */
    private int mainAvg;
    /**
     * 答复满意度
     */
    private int answerAvg;
    /**
     * 工作态度满意度
     */
    private int workAvg;
    /**
     * 委办局满意度
     */
    private int officeAvg;
    /**
     * 问题解决平局时间
     */
    private double solveDayAvg;
    /**
     * 问题解决排名
     */
    private List<QuestionVo> sortList;
    /**
     * 统计数据
     */
    private JSONObject statisList;

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    public int getMonthSolveCount() {
        return monthSolveCount;
    }

    public void setMonthSolveCount(int monthSolveCount) {
        this.monthSolveCount = monthSolveCount;
    }

    public int getMainAvg() {
        return mainAvg;
    }

    public void setMainAvg(int mainAvg) {
        this.mainAvg = mainAvg;
    }

    public int getAnswerAvg() {
        return answerAvg;
    }

    public void setAnswerAvg(int answerAvg) {
        this.answerAvg = answerAvg;
    }

    public int getWorkAvg() {
        return workAvg;
    }

    public void setWorkAvg(int workAvg) {
        this.workAvg = workAvg;
    }

    public int getOfficeAvg() {
        return officeAvg;
    }

    public void setOfficeAvg(int officeAvg) {
        this.officeAvg = officeAvg;
    }

    public double getSolveDayAvg() {
        return solveDayAvg;
    }

    public void setSolveDayAvg(double solveDayAvg) {
        this.solveDayAvg = solveDayAvg;
    }

    public List<QuestionVo> getSortList() {
        return sortList;
    }

    public void setSortList(List<QuestionVo> sortList) {
        this.sortList = sortList;
    }

    public JSONObject getStatisList() {
        return statisList;
    }

    public void setStatisList(JSONObject statisList) {
        this.statisList = statisList;
    }
}
