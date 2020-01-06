package com.youedata.nncloud.modular.nanning.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;


/**
 * <p>
 * 账号认证
 * </p>
 *
 * @author Monkey
 * @since 2018-11-09
 */
@ApiModel
public class Ident extends Model<Ident> {
    public Ident() {
    }

    ;

    public Ident(Integer identId, Integer identUserId, String identType, String identEnterpriseName, String identEnterpriseCode, String identContact, String identTelephone, String identStatus, Integer identCreateBy, Date identCreateTime) {
        this.identId = identId;
        this.identUserId = identUserId;
        this.identType = identType;
        this.identEnterpriseName = identEnterpriseName;
        this.identEnterpriseCode = identEnterpriseCode;
        this.identContact = identContact;
        this.identTelephone = identTelephone;
        this.identStatus = identStatus;
        this.identCreateBy = identCreateBy;
        this.identCreateTime = identCreateTime;
    }

    public Ident(Integer identUserId, String identType, String identEnterpriseName, String identEnterpriseCode, String identContact, String identTelephone, String identStatus, Integer identCreateBy, Date identCreateTime) {
        this.identUserId = identUserId;
        this.identType = identType;
        this.identEnterpriseName = identEnterpriseName;
        this.identEnterpriseCode = identEnterpriseCode;
        this.identContact = identContact;
        this.identTelephone = identTelephone;
        this.identStatus = identStatus;
        this.identCreateBy = identCreateBy;
        this.identCreateTime = identCreateTime;
    }

    public Ident(Integer identUserId) {
        this.identUserId = identUserId;
    }


    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ident_id", type = IdType.AUTO)
    private Integer identId;
    /**
     * 用户id
     */
    private Integer identUserId;
    /**
     * 认证类型:1企业认证，2个人认证
     */
    private String identType;
    /**
     * 认证名称（企业名称/个人名称）
     */
    private String identEnterpriseName;
    /**
     * 统一社会信用代码/身份证号码'
     */
    private String identEnterpriseCode;
    /**
     * 证照原件/证照正面
     */
    private String identPictureHandheld;
    /**
     * 手持证件照
     */
    private String identPictureSource;
    /**
     * 证照复印件/证照反面'
     */
    private String identPictureCopy;
    /**
     * 联系人
     */
    private String identContact;
    /**
     * 联系电话
     */
    private String identTelephone;
    /**
     * 企业注册地址
     */
    private String identRegisteredAddress;
    /**
     * 企业办公地址
     */
    private String identOfficeAddress;
    /**
     * 企业法人代表
     */
    private String identLegalPerson;
    /**
     * 公司座机
     */
    private String identLandlines;

    /**
     * 审核状态：0审核中，1已通过，2未通过
     */
    private String identStatus;
    /**
     * 修改人
     */
    private Integer identCreateBy;
    /**
     * 修改人
     */
    private Integer identUpdateBy;
    /**
     * 修改时间
     */
    private Date identUpdateTime;
    /**
     * 创建时间
     */
    private Date identCreateTime;


    public Integer getIdentId() {
        return identId;
    }

    public void setIdentId(Integer identId) {
        this.identId = identId;
    }

    public Integer getIdentUserId() {
        return identUserId;
    }

    public void setIdentUserId(Integer identUserId) {
        this.identUserId = identUserId;
    }

    public String getIdentType() {
        return identType;
    }

    public void setIdentType(String identType) {
        this.identType = identType;
    }

    public String getIdentEnterpriseName() {
        return identEnterpriseName;
    }

    public void setIdentEnterpriseName(String identEnterpriseName) {
        this.identEnterpriseName = identEnterpriseName;
    }

    public String getIdentEnterpriseCode() {
        return identEnterpriseCode;
    }

    public void setIdentEnterpriseCode(String identEnterpriseCode) {
        this.identEnterpriseCode = identEnterpriseCode;
    }

    public String getIdentPictureSource() {
        return identPictureSource;
    }

    public void setIdentPictureSource(String identPictureSource) {
        this.identPictureSource = identPictureSource;
    }

    public String getIdentPictureCopy() {
        return identPictureCopy;
    }

    public void setIdentPictureCopy(String identPictureCopy) {
        this.identPictureCopy = identPictureCopy;
    }

    public String getIdentContact() {
        return identContact;
    }

    public void setIdentContact(String identContact) {
        this.identContact = identContact;
    }

    public String getIdentTelephone() {
        return identTelephone;
    }

    public void setIdentTelephone(String identTelephone) {
        this.identTelephone = identTelephone;
    }

    public String getIdentStatus() {
        return identStatus;
    }

    public void setIdentStatus(String identStatus) {
        this.identStatus = identStatus;
    }

    public Integer getIdentCreateBy() {
        return identCreateBy;
    }

    public void setIdentCreateBy(Integer identCreateBy) {
        this.identCreateBy = identCreateBy;
    }

    public Integer getIdentUpdateBy() {
        return identUpdateBy;
    }

    public void setIdentUpdateBy(Integer identUpdateBy) {
        this.identUpdateBy = identUpdateBy;
    }

    public Date getIdentUpdateTime() {
        return identUpdateTime;
    }

    public void setIdentUpdateTime(Date identUpdateTime) {
        this.identUpdateTime = identUpdateTime;
    }

    public Date getIdentCreateTime() {
        return identCreateTime;
    }

    public void setIdentCreateTime(Date identCreateTime) {
        this.identCreateTime = identCreateTime;
    }

    public String getIdentPictureHandheld() {
        return identPictureHandheld;
    }

    public String getIdentRegisteredAddress() {
        return identRegisteredAddress;
    }

    public void setIdentRegisteredAddress(String identRegisteredAddress) {
        this.identRegisteredAddress = identRegisteredAddress;
    }

    public String getIdentOfficeAddress() {
        return identOfficeAddress;
    }

    public void setIdentOfficeAddress(String identOfficeAddress) {
        this.identOfficeAddress = identOfficeAddress;
    }

    public String getIdentLegalPerson() {
        return identLegalPerson;
    }

    public void setIdentLegalPerson(String identLegalPerson) {
        this.identLegalPerson = identLegalPerson;
    }

    public String getIdentLandlines() {
        return identLandlines;
    }

    public void setIdentLandlines(String identLandlines) {
        this.identLandlines = identLandlines;
    }

    public void setIdentPictureHandheld(String identPictureHandheld) {
        this.identPictureHandheld = identPictureHandheld;
    }

    @Override
    protected Serializable pkVal() {
        return this.identId;
    }


    @Override
    public String toString() {
        return "Ident{" +
                "identId=" + identId +
                ", identUserId=" + identUserId +
                ", identType='" + identType + '\'' +
                ", identEnterpriseName='" + identEnterpriseName + '\'' +
                ", identEnterpriseCode='" + identEnterpriseCode + '\'' +
                ", identPictureHandheld='" + identPictureHandheld + '\'' +
                ", identPictureSource='" + identPictureSource + '\'' +
                ", identPictureCopy='" + identPictureCopy + '\'' +
                ", identContact='" + identContact + '\'' +
                ", identTelephone='" + identTelephone + '\'' +
                ", identRegisteredAddress='" + identRegisteredAddress + '\'' +
                ", identOfficeAddress='" + identOfficeAddress + '\'' +
                ", identLegalPerson='" + identLegalPerson + '\'' +
                ", identLandlines='" + identLandlines + '\'' +
                ", identStatus='" + identStatus + '\'' +
                ", identCreateBy=" + identCreateBy +
                ", identUpdateBy=" + identUpdateBy +
                ", identUpdateTime=" + identUpdateTime +
                ", identCreateTime=" + identCreateTime +
                '}';
    }
}
