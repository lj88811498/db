package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 企业融资信息
 * </p>
 *
 * @author Monkey
 * @since 2019-01-23
 */
@ApiModel
public class EnterpriseFinancing extends Model<EnterpriseFinancing> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String enterpriseFinancingId;
    /**
     * 项目名称
     */
    private String enterpriseFinancingProjectName;
    /**
     * 授权机构
     */
    private String enterpriseFinancingOffice;
    /**
     * 项目经理
     */
    private String enterpriseFinancingUser;
    /**
     * 项目协办
     */
    private String enterpriseFinancingManager;
    /**
     * 贷款企业
     */
    private String enterpriseFinancingBusiness;
    /**
     * 放款银行
     */
    private String enterpriseFinancingBank;
    /**
     * 银行项目经理
     */
    private String enterpriseFinancingBankXmjl;
    /**
     * 银行项目经理联系电话
     */
    private String enterpriseFinancingBankTel;
    /**
     * 担保公司
     */
    private String enterpriseFinancingGuaranteeGs;
    /**
     * 担保公司项目经理
     */
    private String enterpriseFinancingGuaranteeXmjl;
    /**
     * 担保公司项目经理联系方式
     */
    private String enterpriseFinancingGuaranteeTel;
    /**
     * 产品类型
     */
    private String enterpriseFinancingTypes;
    /**
     * 项目状态
     */
    private String enterpriseFinancingStatus;
    /**
     * 贷款性质
     */
    private String enterpriseFinancingLoanCharacter;
    /**
     * 担保方式
     */
    private String enterpriseFinancingGuarantee;
    /**
     * 主办意见
     */
    private String enterpriseFinancingComment;
    /**
     * 审核情况
     */
    private String enterpriseFinancingIsExamine;
    /**
     * 融资部审核
     */
    private String enterpriseFinancingExamine03;
    /**
     * 注信息
     */
    private String enterpriseFinancingRemarks;
    /**
     * 所属行业
     */
    private String enterpriseFinancingIndustry;
    /**
     * 组织结构代码
     */
    private String enterpriseFinancingOrganizationCode;
    /**
     * 办公地址
     */
    private String enterpriseFinancingOfficeAddress;
    /**
     * 生产地址
     */
    private String enterpriseFinancingProductionAddress;
    /**
     * 法人代表
     */
    private String enterpriseFinancingCorporation;
    /**
     * 法人身份证
     */
    private String enterpriseFinancingCorporationCode;
    /**
     * 注册资本
     */
    private String enterpriseFinancingRegisteredCapital;
    /**
     * 货币单位
     */
    private String enterpriseFinancingUnit;
    /**
     * 营业执照
     */
    private String enterpriseFinancingBusinessLicence;
    /**
     * 税务登记证
     */
    private String enterpriseFinancingTaxRegistration;
    /**
     * 资产总额
     */
    private String enterpriseFinancingTotalAssets;
    /**
     * 负债总额
     */
    private String enterpriseFinancingTotalLiability;
    /**
     * 主营业务收入
     */
    private String enterpriseFinancingBusinessIncome;
    /**
     * 主营业务范围
     */
    private String enterpriseFinancingBusinessScope;
    /**
     * 利润
     */
    private String enterpriseFinancingProfit;
    /**
     * 税收
     */
    private String enterpriseFinancingTax;
    /**
     * 贷款余额
     */
    private String enterpriseFinancingLoanBalance;
    /**
     * 保证金缴纳金额
     */
    private String enterpriseFinancingBail;
    /**
     * 保证金缴纳时间
     */
    private String enterpriseFinancingBailTime;
    /**
     * 企业实际控制人
     */
    private String enterpriseFinancingBusinessControler;
    /**
     * 控制人联系方式
     */
    private String enterpriseFinancingControlerTelephone;
    /**
     * 企业联系人
     */
    private String enterpriseFinancingBusinessLinkman;
    /**
     * 联系人职务
     */
    private String enterpriseFinancingLinkmanPost;
    /**
     * 联系方式
     */
    private String enterpriseFinancingLinkmanTelephone;
    /**
     * 传真
     */
    private String enterpriseFinancingFax;
    /**
     * 企业规模
     */
    private String enterpriseFinancingScale;
    /**
     * 信用等级
     */
    private String enterpriseFinancingCredit;
    /**
     * 员工人数
     */
    private String enterpriseFinancingEmployees;
    /**
     * 产能
     */
    private String enterpriseFinancingCapacity;
    /**
     * 库存
     */
    private String enterpriseFinancingInventory;
    /**
     * 企业注册地址
     */
    private String enterpriseFinancingRegisteredAddress;
    /**
     * 创建人
     */
    private Integer enterpriseFinancingCreateBy;
    /**
     * 修改人
     */
    private Integer enterpriseFinancingUpdateBy;
    /**
     * 修改时间
     */
    private Date enterpriseFinancingUpdateTime;
    /**
     * 创建时间
     */
    private Date enterpriseFinancingCreateTime;


    public String getEnterpriseFinancingId() {
        return enterpriseFinancingId;
    }

    public void setEnterpriseFinancingId(String enterpriseFinancingId) {
        this.enterpriseFinancingId = enterpriseFinancingId;
    }

    public String getEnterpriseFinancingProjectName() {
        return enterpriseFinancingProjectName;
    }

    public void setEnterpriseFinancingProjectName(String enterpriseFinancingProjectName) {
        this.enterpriseFinancingProjectName = enterpriseFinancingProjectName;
    }

    public String getEnterpriseFinancingOffice() {
        return enterpriseFinancingOffice;
    }

    public void setEnterpriseFinancingOffice(String enterpriseFinancingOffice) {
        this.enterpriseFinancingOffice = enterpriseFinancingOffice;
    }

    public String getEnterpriseFinancingUser() {
        return enterpriseFinancingUser;
    }

    public void setEnterpriseFinancingUser(String enterpriseFinancingUser) {
        this.enterpriseFinancingUser = enterpriseFinancingUser;
    }

    public String getEnterpriseFinancingManager() {
        return enterpriseFinancingManager;
    }

    public void setEnterpriseFinancingManager(String enterpriseFinancingManager) {
        this.enterpriseFinancingManager = enterpriseFinancingManager;
    }

    public String getEnterpriseFinancingBusiness() {
        return enterpriseFinancingBusiness;
    }

    public void setEnterpriseFinancingBusiness(String enterpriseFinancingBusiness) {
        this.enterpriseFinancingBusiness = enterpriseFinancingBusiness;
    }

    public String getEnterpriseFinancingBank() {
        return enterpriseFinancingBank;
    }

    public void setEnterpriseFinancingBank(String enterpriseFinancingBank) {
        this.enterpriseFinancingBank = enterpriseFinancingBank;
    }

    public String getEnterpriseFinancingBankXmjl() {
        return enterpriseFinancingBankXmjl;
    }

    public void setEnterpriseFinancingBankXmjl(String enterpriseFinancingBankXmjl) {
        this.enterpriseFinancingBankXmjl = enterpriseFinancingBankXmjl;
    }

    public String getEnterpriseFinancingBankTel() {
        return enterpriseFinancingBankTel;
    }

    public void setEnterpriseFinancingBankTel(String enterpriseFinancingBankTel) {
        this.enterpriseFinancingBankTel = enterpriseFinancingBankTel;
    }

    public String getEnterpriseFinancingGuaranteeGs() {
        return enterpriseFinancingGuaranteeGs;
    }

    public void setEnterpriseFinancingGuaranteeGs(String enterpriseFinancingGuaranteeGs) {
        this.enterpriseFinancingGuaranteeGs = enterpriseFinancingGuaranteeGs;
    }

    public String getEnterpriseFinancingGuaranteeXmjl() {
        return enterpriseFinancingGuaranteeXmjl;
    }

    public void setEnterpriseFinancingGuaranteeXmjl(String enterpriseFinancingGuaranteeXmjl) {
        this.enterpriseFinancingGuaranteeXmjl = enterpriseFinancingGuaranteeXmjl;
    }

    public String getEnterpriseFinancingGuaranteeTel() {
        return enterpriseFinancingGuaranteeTel;
    }

    public void setEnterpriseFinancingGuaranteeTel(String enterpriseFinancingGuaranteeTel) {
        this.enterpriseFinancingGuaranteeTel = enterpriseFinancingGuaranteeTel;
    }

    public String getEnterpriseFinancingTypes() {
        return enterpriseFinancingTypes;
    }

    public void setEnterpriseFinancingTypes(String enterpriseFinancingTypes) {
        this.enterpriseFinancingTypes = enterpriseFinancingTypes;
    }

    public String getEnterpriseFinancingStatus() {
        return enterpriseFinancingStatus;
    }

    public void setEnterpriseFinancingStatus(String enterpriseFinancingStatus) {
        this.enterpriseFinancingStatus = enterpriseFinancingStatus;
    }

    public String getEnterpriseFinancingLoanCharacter() {
        return enterpriseFinancingLoanCharacter;
    }

    public void setEnterpriseFinancingLoanCharacter(String enterpriseFinancingLoanCharacter) {
        this.enterpriseFinancingLoanCharacter = enterpriseFinancingLoanCharacter;
    }

    public String getEnterpriseFinancingGuarantee() {
        return enterpriseFinancingGuarantee;
    }

    public void setEnterpriseFinancingGuarantee(String enterpriseFinancingGuarantee) {
        this.enterpriseFinancingGuarantee = enterpriseFinancingGuarantee;
    }

    public String getEnterpriseFinancingComment() {
        return enterpriseFinancingComment;
    }

    public void setEnterpriseFinancingComment(String enterpriseFinancingComment) {
        this.enterpriseFinancingComment = enterpriseFinancingComment;
    }

    public String getEnterpriseFinancingIsExamine() {
        return enterpriseFinancingIsExamine;
    }

    public void setEnterpriseFinancingIsExamine(String enterpriseFinancingIsExamine) {
        this.enterpriseFinancingIsExamine = enterpriseFinancingIsExamine;
    }

    public String getEnterpriseFinancingExamine03() {
        return enterpriseFinancingExamine03;
    }

    public void setEnterpriseFinancingExamine03(String enterpriseFinancingExamine03) {
        this.enterpriseFinancingExamine03 = enterpriseFinancingExamine03;
    }

    public String getEnterpriseFinancingRemarks() {
        return enterpriseFinancingRemarks;
    }

    public void setEnterpriseFinancingRemarks(String enterpriseFinancingRemarks) {
        this.enterpriseFinancingRemarks = enterpriseFinancingRemarks;
    }

    public String getEnterpriseFinancingIndustry() {
        return enterpriseFinancingIndustry;
    }

    public void setEnterpriseFinancingIndustry(String enterpriseFinancingIndustry) {
        this.enterpriseFinancingIndustry = enterpriseFinancingIndustry;
    }

    public String getEnterpriseFinancingOrganizationCode() {
        return enterpriseFinancingOrganizationCode;
    }

    public void setEnterpriseFinancingOrganizationCode(String enterpriseFinancingOrganizationCode) {
        this.enterpriseFinancingOrganizationCode = enterpriseFinancingOrganizationCode;
    }

    public String getEnterpriseFinancingOfficeAddress() {
        return enterpriseFinancingOfficeAddress;
    }

    public void setEnterpriseFinancingOfficeAddress(String enterpriseFinancingOfficeAddress) {
        this.enterpriseFinancingOfficeAddress = enterpriseFinancingOfficeAddress;
    }

    public String getEnterpriseFinancingProductionAddress() {
        return enterpriseFinancingProductionAddress;
    }

    public void setEnterpriseFinancingProductionAddress(String enterpriseFinancingProductionAddress) {
        this.enterpriseFinancingProductionAddress = enterpriseFinancingProductionAddress;
    }

    public String getEnterpriseFinancingCorporation() {
        return enterpriseFinancingCorporation;
    }

    public void setEnterpriseFinancingCorporation(String enterpriseFinancingCorporation) {
        this.enterpriseFinancingCorporation = enterpriseFinancingCorporation;
    }

    public String getEnterpriseFinancingCorporationCode() {
        return enterpriseFinancingCorporationCode;
    }

    public void setEnterpriseFinancingCorporationCode(String enterpriseFinancingCorporationCode) {
        this.enterpriseFinancingCorporationCode = enterpriseFinancingCorporationCode;
    }

    public String getEnterpriseFinancingRegisteredCapital() {
        return enterpriseFinancingRegisteredCapital;
    }

    public void setEnterpriseFinancingRegisteredCapital(String enterpriseFinancingRegisteredCapital) {
        this.enterpriseFinancingRegisteredCapital = enterpriseFinancingRegisteredCapital;
    }

    public String getEnterpriseFinancingUnit() {
        return enterpriseFinancingUnit;
    }

    public void setEnterpriseFinancingUnit(String enterpriseFinancingUnit) {
        this.enterpriseFinancingUnit = enterpriseFinancingUnit;
    }

    public String getEnterpriseFinancingBusinessLicence() {
        return enterpriseFinancingBusinessLicence;
    }

    public void setEnterpriseFinancingBusinessLicence(String enterpriseFinancingBusinessLicence) {
        this.enterpriseFinancingBusinessLicence = enterpriseFinancingBusinessLicence;
    }

    public String getEnterpriseFinancingTaxRegistration() {
        return enterpriseFinancingTaxRegistration;
    }

    public void setEnterpriseFinancingTaxRegistration(String enterpriseFinancingTaxRegistration) {
        this.enterpriseFinancingTaxRegistration = enterpriseFinancingTaxRegistration;
    }

    public String getEnterpriseFinancingTotalAssets() {
        return enterpriseFinancingTotalAssets;
    }

    public void setEnterpriseFinancingTotalAssets(String enterpriseFinancingTotalAssets) {
        this.enterpriseFinancingTotalAssets = enterpriseFinancingTotalAssets;
    }

    public String getEnterpriseFinancingTotalLiability() {
        return enterpriseFinancingTotalLiability;
    }

    public void setEnterpriseFinancingTotalLiability(String enterpriseFinancingTotalLiability) {
        this.enterpriseFinancingTotalLiability = enterpriseFinancingTotalLiability;
    }

    public String getEnterpriseFinancingBusinessIncome() {
        return enterpriseFinancingBusinessIncome;
    }

    public void setEnterpriseFinancingBusinessIncome(String enterpriseFinancingBusinessIncome) {
        this.enterpriseFinancingBusinessIncome = enterpriseFinancingBusinessIncome;
    }

    public String getEnterpriseFinancingBusinessScope() {
        return enterpriseFinancingBusinessScope;
    }

    public void setEnterpriseFinancingBusinessScope(String enterpriseFinancingBusinessScope) {
        this.enterpriseFinancingBusinessScope = enterpriseFinancingBusinessScope;
    }

    public String getEnterpriseFinancingProfit() {
        return enterpriseFinancingProfit;
    }

    public void setEnterpriseFinancingProfit(String enterpriseFinancingProfit) {
        this.enterpriseFinancingProfit = enterpriseFinancingProfit;
    }

    public String getEnterpriseFinancingTax() {
        return enterpriseFinancingTax;
    }

    public void setEnterpriseFinancingTax(String enterpriseFinancingTax) {
        this.enterpriseFinancingTax = enterpriseFinancingTax;
    }

    public String getEnterpriseFinancingLoanBalance() {
        return enterpriseFinancingLoanBalance;
    }

    public void setEnterpriseFinancingLoanBalance(String enterpriseFinancingLoanBalance) {
        this.enterpriseFinancingLoanBalance = enterpriseFinancingLoanBalance;
    }

    public String getEnterpriseFinancingBail() {
        return enterpriseFinancingBail;
    }

    public void setEnterpriseFinancingBail(String enterpriseFinancingBail) {
        this.enterpriseFinancingBail = enterpriseFinancingBail;
    }

    public String getEnterpriseFinancingBailTime() {
        return enterpriseFinancingBailTime;
    }

    public void setEnterpriseFinancingBailTime(String enterpriseFinancingBailTime) {
        this.enterpriseFinancingBailTime = enterpriseFinancingBailTime;
    }

    public String getEnterpriseFinancingBusinessControler() {
        return enterpriseFinancingBusinessControler;
    }

    public void setEnterpriseFinancingBusinessControler(String enterpriseFinancingBusinessControler) {
        this.enterpriseFinancingBusinessControler = enterpriseFinancingBusinessControler;
    }

    public String getEnterpriseFinancingControlerTelephone() {
        return enterpriseFinancingControlerTelephone;
    }

    public void setEnterpriseFinancingControlerTelephone(String enterpriseFinancingControlerTelephone) {
        this.enterpriseFinancingControlerTelephone = enterpriseFinancingControlerTelephone;
    }

    public String getEnterpriseFinancingBusinessLinkman() {
        return enterpriseFinancingBusinessLinkman;
    }

    public void setEnterpriseFinancingBusinessLinkman(String enterpriseFinancingBusinessLinkman) {
        this.enterpriseFinancingBusinessLinkman = enterpriseFinancingBusinessLinkman;
    }

    public String getEnterpriseFinancingLinkmanPost() {
        return enterpriseFinancingLinkmanPost;
    }

    public void setEnterpriseFinancingLinkmanPost(String enterpriseFinancingLinkmanPost) {
        this.enterpriseFinancingLinkmanPost = enterpriseFinancingLinkmanPost;
    }

    public String getEnterpriseFinancingLinkmanTelephone() {
        return enterpriseFinancingLinkmanTelephone;
    }

    public void setEnterpriseFinancingLinkmanTelephone(String enterpriseFinancingLinkmanTelephone) {
        this.enterpriseFinancingLinkmanTelephone = enterpriseFinancingLinkmanTelephone;
    }

    public String getEnterpriseFinancingFax() {
        return enterpriseFinancingFax;
    }

    public void setEnterpriseFinancingFax(String enterpriseFinancingFax) {
        this.enterpriseFinancingFax = enterpriseFinancingFax;
    }

    public String getEnterpriseFinancingScale() {
        return enterpriseFinancingScale;
    }

    public void setEnterpriseFinancingScale(String enterpriseFinancingScale) {
        this.enterpriseFinancingScale = enterpriseFinancingScale;
    }

    public String getEnterpriseFinancingCredit() {
        return enterpriseFinancingCredit;
    }

    public void setEnterpriseFinancingCredit(String enterpriseFinancingCredit) {
        this.enterpriseFinancingCredit = enterpriseFinancingCredit;
    }

    public String getEnterpriseFinancingEmployees() {
        return enterpriseFinancingEmployees;
    }

    public void setEnterpriseFinancingEmployees(String enterpriseFinancingEmployees) {
        this.enterpriseFinancingEmployees = enterpriseFinancingEmployees;
    }

    public String getEnterpriseFinancingCapacity() {
        return enterpriseFinancingCapacity;
    }

    public void setEnterpriseFinancingCapacity(String enterpriseFinancingCapacity) {
        this.enterpriseFinancingCapacity = enterpriseFinancingCapacity;
    }

    public String getEnterpriseFinancingInventory() {
        return enterpriseFinancingInventory;
    }

    public void setEnterpriseFinancingInventory(String enterpriseFinancingInventory) {
        this.enterpriseFinancingInventory = enterpriseFinancingInventory;
    }

    public String getEnterpriseFinancingRegisteredAddress() {
        return enterpriseFinancingRegisteredAddress;
    }

    public void setEnterpriseFinancingRegisteredAddress(String enterpriseFinancingRegisteredAddress) {
        this.enterpriseFinancingRegisteredAddress = enterpriseFinancingRegisteredAddress;
    }

    public Integer getEnterpriseFinancingCreateBy() {
        return enterpriseFinancingCreateBy;
    }

    public void setEnterpriseFinancingCreateBy(Integer enterpriseFinancingCreateBy) {
        this.enterpriseFinancingCreateBy = enterpriseFinancingCreateBy;
    }

    public Integer getEnterpriseFinancingUpdateBy() {
        return enterpriseFinancingUpdateBy;
    }

    public void setEnterpriseFinancingUpdateBy(Integer enterpriseFinancingUpdateBy) {
        this.enterpriseFinancingUpdateBy = enterpriseFinancingUpdateBy;
    }

    public Date getEnterpriseFinancingUpdateTime() {
        return enterpriseFinancingUpdateTime;
    }

    public void setEnterpriseFinancingUpdateTime(Date enterpriseFinancingUpdateTime) {
        this.enterpriseFinancingUpdateTime = enterpriseFinancingUpdateTime;
    }

    public Date getEnterpriseFinancingCreateTime() {
        return enterpriseFinancingCreateTime;
    }

    public void setEnterpriseFinancingCreateTime(Date enterpriseFinancingCreateTime) {
        this.enterpriseFinancingCreateTime = enterpriseFinancingCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.enterpriseFinancingId;
    }

    @Override
    public String toString() {
        return "EnterpriseFinancing{" +
        "enterpriseFinancingId=" + enterpriseFinancingId +
        ", enterpriseFinancingProjectName=" + enterpriseFinancingProjectName +
        ", enterpriseFinancingOffice=" + enterpriseFinancingOffice +
        ", enterpriseFinancingUser=" + enterpriseFinancingUser +
        ", enterpriseFinancingManager=" + enterpriseFinancingManager +
        ", enterpriseFinancingBusiness=" + enterpriseFinancingBusiness +
        ", enterpriseFinancingBank=" + enterpriseFinancingBank +
        ", enterpriseFinancingBankXmjl=" + enterpriseFinancingBankXmjl +
        ", enterpriseFinancingBankTel=" + enterpriseFinancingBankTel +
        ", enterpriseFinancingGuaranteeGs=" + enterpriseFinancingGuaranteeGs +
        ", enterpriseFinancingGuaranteeXmjl=" + enterpriseFinancingGuaranteeXmjl +
        ", enterpriseFinancingGuaranteeTel=" + enterpriseFinancingGuaranteeTel +
        ", enterpriseFinancingTypes=" + enterpriseFinancingTypes +
        ", enterpriseFinancingStatus=" + enterpriseFinancingStatus +
        ", enterpriseFinancingLoanCharacter=" + enterpriseFinancingLoanCharacter +
        ", enterpriseFinancingGuarantee=" + enterpriseFinancingGuarantee +
        ", enterpriseFinancingComment=" + enterpriseFinancingComment +
        ", enterpriseFinancingIsExamine=" + enterpriseFinancingIsExamine +
        ", enterpriseFinancingExamine03=" + enterpriseFinancingExamine03 +
        ", enterpriseFinancingRemarks=" + enterpriseFinancingRemarks +
        ", enterpriseFinancingIndustry=" + enterpriseFinancingIndustry +
        ", enterpriseFinancingOrganizationCode=" + enterpriseFinancingOrganizationCode +
        ", enterpriseFinancingOfficeAddress=" + enterpriseFinancingOfficeAddress +
        ", enterpriseFinancingProductionAddress=" + enterpriseFinancingProductionAddress +
        ", enterpriseFinancingCorporation=" + enterpriseFinancingCorporation +
        ", enterpriseFinancingCorporationCode=" + enterpriseFinancingCorporationCode +
        ", enterpriseFinancingRegisteredCapital=" + enterpriseFinancingRegisteredCapital +
        ", enterpriseFinancingUnit=" + enterpriseFinancingUnit +
        ", enterpriseFinancingBusinessLicence=" + enterpriseFinancingBusinessLicence +
        ", enterpriseFinancingTaxRegistration=" + enterpriseFinancingTaxRegistration +
        ", enterpriseFinancingTotalAssets=" + enterpriseFinancingTotalAssets +
        ", enterpriseFinancingTotalLiability=" + enterpriseFinancingTotalLiability +
        ", enterpriseFinancingBusinessIncome=" + enterpriseFinancingBusinessIncome +
        ", enterpriseFinancingBusinessScope=" + enterpriseFinancingBusinessScope +
        ", enterpriseFinancingProfit=" + enterpriseFinancingProfit +
        ", enterpriseFinancingTax=" + enterpriseFinancingTax +
        ", enterpriseFinancingLoanBalance=" + enterpriseFinancingLoanBalance +
        ", enterpriseFinancingBail=" + enterpriseFinancingBail +
        ", enterpriseFinancingBailTime=" + enterpriseFinancingBailTime +
        ", enterpriseFinancingBusinessControler=" + enterpriseFinancingBusinessControler +
        ", enterpriseFinancingControlerTelephone=" + enterpriseFinancingControlerTelephone +
        ", enterpriseFinancingBusinessLinkman=" + enterpriseFinancingBusinessLinkman +
        ", enterpriseFinancingLinkmanPost=" + enterpriseFinancingLinkmanPost +
        ", enterpriseFinancingLinkmanTelephone=" + enterpriseFinancingLinkmanTelephone +
        ", enterpriseFinancingFax=" + enterpriseFinancingFax +
        ", enterpriseFinancingScale=" + enterpriseFinancingScale +
        ", enterpriseFinancingCredit=" + enterpriseFinancingCredit +
        ", enterpriseFinancingEmployees=" + enterpriseFinancingEmployees +
        ", enterpriseFinancingCapacity=" + enterpriseFinancingCapacity +
        ", enterpriseFinancingInventory=" + enterpriseFinancingInventory +
        ", enterpriseFinancingRegisteredAddress=" + enterpriseFinancingRegisteredAddress +
        ", enterpriseFinancingCreateBy=" + enterpriseFinancingCreateBy +
        ", enterpriseFinancingUpdateBy=" + enterpriseFinancingUpdateBy +
        ", enterpriseFinancingUpdateTime=" + enterpriseFinancingUpdateTime +
        ", enterpriseFinancingCreateTime=" + enterpriseFinancingCreateTime +
        "}";
    }
}
