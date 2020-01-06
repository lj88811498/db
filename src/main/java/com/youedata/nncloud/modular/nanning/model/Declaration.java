package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.youedata.nncloud.modular.nanning.anno.Too;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 我的申报表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Declaration extends Model<Declaration> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "declaration_id", type = IdType.AUTO)
    private Integer declarationId;
    /**
     * 项目名称
     */
    @Too(value="name")
    private String declarationName;
    /**
     * 用户id(与用户id关联)
     */
    private Integer declarationUserId;
    /**
     * 项目起始时间
     */
    @Too(value="startDate")
    private Date declarationStartTime;
    /**
     * 项目终止时间
     */
    @Too(value="endDate")
    private Date declarationEndTime;
    /**
     * 项目总投资
     */
    @Too(value="investCount")
    private String declarationInvestment;
    /**
     * 项目建设地点
     */
    @Too(value="address")
    private String declarationAddress;
    /**
     * 申报类型
     */
    private String declarationType;
    /**
     * 申报日期
     */
    @Too(value="yeardate")
    private Date declarationTime;
    /**
     * 所属行业
     */
    private String declarationIndustry;
    /**
     * 所属科室
     */
    private String declarationDept;
    /**
     * 状态 (如 1: 提交项目申报 2: 项目审批 3: 上报立项材料 4:审批立项材料)
     */
    private String declarationStatus;
    /**
     * 申请扶助资金（万元）
     */
    private String declarationSupportFund;
    /**
     * 自有资金（万元）
     */
    @Too(value="investSelf")
    private String declarationOwnFund;
    /**
     * 新增税金（万元）
     */
    @Too(value="newTax")
    private String declarationNewTaxes;
    /**
     * 新增销售收入（万元）
     */
    @Too(value="newSales")
    private String declarationSalesRevenue;
    /**
     * 新增利润（万元）
     */
    @Too(value="newProfit")
    private String declarationProfit;
    /**
     * 企业名称
     */
    private String declarationEnterprise;
    /**
     * 负责人
     */
    @Too(value="corporateDirector")
    private String declarationPerson;
    /**
     * 联系电话
     */
    @Too(value="connectPhone")
    private String declarationPhone;


    public Integer getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Integer declarationId) {
        this.declarationId = declarationId;
    }

    public String getDeclarationName() {
        return declarationName;
    }

    public void setDeclarationName(String declarationName) {
        this.declarationName = declarationName;
    }

    public Integer getDeclarationUserId() {
        return declarationUserId;
    }

    public void setDeclarationUserId(Integer declarationUserId) {
        this.declarationUserId = declarationUserId;
    }

    public Date getDeclarationStartTime() {
        return declarationStartTime;
    }

    public void setDeclarationStartTime(Date declarationStartTime) {
        this.declarationStartTime = declarationStartTime;
    }

    public Date getDeclarationEndTime() {
        return declarationEndTime;
    }

    public void setDeclarationEndTime(Date declarationEndTime) {
        this.declarationEndTime = declarationEndTime;
    }

    public String getDeclarationInvestment() {
        return declarationInvestment;
    }

    public void setDeclarationInvestment(String declarationInvestment) {
        this.declarationInvestment = declarationInvestment;
    }

    public String getDeclarationAddress() {
        return declarationAddress;
    }

    public void setDeclarationAddress(String declarationAddress) {
        this.declarationAddress = declarationAddress;
    }

    public Date getDeclarationTime() {
        return declarationTime;
    }

    public void setDeclarationTime(Date declarationTime) {
        this.declarationTime = declarationTime;
    }

    public String getDeclarationIndustry() {
        return declarationIndustry;
    }

    public void setDeclarationIndustry(String declarationIndustry) {
        this.declarationIndustry = declarationIndustry;
    }

    public String getDeclarationDept() {
        return declarationDept;
    }

    public void setDeclarationDept(String declarationDept) {
        this.declarationDept = declarationDept;
    }

    public String getDeclarationStatus() {
        return declarationStatus;
    }

    public void setDeclarationStatus(String declarationStatus) {
        this.declarationStatus = declarationStatus;
    }

    public String getDeclarationSupportFund() {
        return declarationSupportFund;
    }

    public void setDeclarationSupportFund(String declarationSupportFund) {
        this.declarationSupportFund = declarationSupportFund;
    }

    public String getDeclarationOwnFund() {
        return declarationOwnFund;
    }

    public void setDeclarationOwnFund(String declarationOwnFund) {
        this.declarationOwnFund = declarationOwnFund;
    }

    public String getDeclarationNewTaxes() {
        return declarationNewTaxes;
    }

    public void setDeclarationNewTaxes(String declarationNewTaxes) {
        this.declarationNewTaxes = declarationNewTaxes;
    }

    public String getDeclarationSalesRevenue() {
        return declarationSalesRevenue;
    }

    public void setDeclarationSalesRevenue(String declarationSalesRevenue) {
        this.declarationSalesRevenue = declarationSalesRevenue;
    }

    public String getDeclarationProfit() {
        return declarationProfit;
    }

    public void setDeclarationProfit(String declarationProfit) {
        this.declarationProfit = declarationProfit;
    }

    public String getDeclarationEnterprise() {
        return declarationEnterprise;
    }

    public void setDeclarationEnterprise(String declarationEnterprise) {
        this.declarationEnterprise = declarationEnterprise;
    }

    public String getDeclarationPerson() {
        return declarationPerson;
    }

    public void setDeclarationPerson(String declarationPerson) {
        this.declarationPerson = declarationPerson;
    }

    public String getDeclarationPhone() {
        return declarationPhone;
    }

    public void setDeclarationPhone(String declarationPhone) {
        this.declarationPhone = declarationPhone;
    }

    public String getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(String declarationType) {
        this.declarationType = declarationType;
    }

    @Override
    protected Serializable pkVal() {
        return this.declarationId;
    }


    @Override
    public String toString() {
        return "Declaration{" +
                "declarationId=" + declarationId +
                ", declarationName='" + declarationName + '\'' +
                ", declarationUserId=" + declarationUserId +
                ", declarationStartTime=" + declarationStartTime +
                ", declarationEndTime=" + declarationEndTime +
                ", declarationInvestment='" + declarationInvestment + '\'' +
                ", declarationAddress='" + declarationAddress + '\'' +
                ", declarationTime=" + declarationTime +
                ", declarationType=" + declarationType +
                ", declarationIndustry='" + declarationIndustry + '\'' +
                ", declarationDept='" + declarationDept + '\'' +
                ", declarationStatus='" + declarationStatus + '\'' +
                ", declarationSupportFund='" + declarationSupportFund + '\'' +
                ", declarationOwnFund='" + declarationOwnFund + '\'' +
                ", declarationNewTaxes='" + declarationNewTaxes + '\'' +
                ", declarationSalesRevenue='" + declarationSalesRevenue + '\'' +
                ", declarationProfit='" + declarationProfit + '\'' +
                ", declarationEnterprise='" + declarationEnterprise + '\'' +
                ", declarationPerson='" + declarationPerson + '\'' +
                ", declarationPhone='" + declarationPhone + '\'' +
                '}';
    }
}
