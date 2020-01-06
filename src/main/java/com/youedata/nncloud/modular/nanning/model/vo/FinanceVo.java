package com.youedata.nncloud.modular.nanning.model.vo;/**
 * @ Author     ：fxh
 * @ Date       ：2019/1/18
 * @ Description：
 */

/**
 * * @program: nncloud
 * * @description:
 * * @author: FXH
 * * @create: 2019-01-18
 **/
public class FinanceVo {

    //排序
    private String sorts;
    //类型名称
    private String index_name;
    //报表月份
    private String report_month;
    //金钱单位
    private String unit;
    //企业名称
    private String ent_name;
    //报表类型名称
    private String title;
    //当月数目
    private String cur_month_count;
    //去年同月数目
    private String last_year_same_month;
    //今年数量
    private String cur_year_to_now_count;
    //去年数目
    private String last_year_to_same_month;
    //当月增长速率
    private String cur_month_growth_rate;
    //当年增长速率
    private String cur_year_growth_rate;
    //单位负责人
    private String report_corporation;
    //统计负责人
    private String report_totalname;
    //填报人
    private String report_createname;
    //手机号码
    private String report_mobile;
    //填报情况描述
    private String remarks;
    //状态工 信接口状态：
    //0 待提交
    //1 提交审核
    //2 驳回
    //3 反审进入待提交
    //99 审核通过
    private String status;
    //企业id
    private String enterprise_id;
    //年月时间预计(如:2018年1-5月预计)
    private String details_estimate;

    //2018年1-4月累计
    private String finance_details_accumulate1;


    //2017年1-4月累计
    private String finance_details_accumulate2;




    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getReport_month() {
        return report_month;
    }

    public void setReport_month(String report_month) {
        this.report_month = report_month;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEnt_name() {
        return ent_name;
    }

    public void setEnt_name(String ent_name) {
        this.ent_name = ent_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCur_month_count() {
        return cur_month_count;
    }

    public void setCur_month_count(String cur_month_count) {
        this.cur_month_count = cur_month_count;
    }

    public String getLast_year_same_month() {
        return last_year_same_month;
    }

    public void setLast_year_same_month(String last_year_same_month) {
        this.last_year_same_month = last_year_same_month;
    }

    public String getCur_year_to_now_count() {
        return cur_year_to_now_count;
    }

    public void setCur_year_to_now_count(String cur_year_to_now_count) {
        this.cur_year_to_now_count = cur_year_to_now_count;
    }

    public String getLast_year_to_same_month() {
        return last_year_to_same_month;
    }

    public void setLast_year_to_same_month(String last_year_to_same_month) {
        this.last_year_to_same_month = last_year_to_same_month;
    }

    public String getCur_month_growth_rate() {
        return cur_month_growth_rate;
    }

    public void setCur_month_growth_rate(String cur_month_growth_rate) {
        this.cur_month_growth_rate = cur_month_growth_rate;
    }

    public String getCur_year_growth_rate() {
        return cur_year_growth_rate;
    }

    public void setCur_year_growth_rate(String cur_year_growth_rate) {
        this.cur_year_growth_rate = cur_year_growth_rate;
    }

    public String getReport_corporation() {
        return report_corporation;
    }

    public void setReport_corporation(String report_corporation) {
        this.report_corporation = report_corporation;
    }

    public String getReport_totalname() {
        return report_totalname;
    }

    public void setReport_totalname(String report_totalname) {
        this.report_totalname = report_totalname;
    }

    public String getReport_createname() {
        return report_createname;
    }

    public void setReport_createname(String report_createname) {
        this.report_createname = report_createname;
    }

    public String getReport_mobile() {
        return report_mobile;
    }

    public void setReport_mobile(String report_mobile) {
        this.report_mobile = report_mobile;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getDetails_estimate() {
        return details_estimate;
    }

    public void setDetails_estimate(String details_estimate) {
        this.details_estimate = details_estimate;
    }

    public String getFinance_details_accumulate1() {
        return finance_details_accumulate1;
    }

    public void setFinance_details_accumulate1(String finance_details_accumulate1) {
        this.finance_details_accumulate1 = finance_details_accumulate1;
    }

    public String getFinance_details_accumulate2() {
        return finance_details_accumulate2;
    }

    public void setFinance_details_accumulate2(String finance_details_accumulate2) {
        this.finance_details_accumulate2 = finance_details_accumulate2;
    }
}
