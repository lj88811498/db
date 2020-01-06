package com.youedata.nncloud.modular.nanning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 个人求职
 * </p>
 *
 * @author Monkey
 * @since 2018-11-23
 */
@ApiModel
public class Resume extends Model<Resume> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "resume_id", type = IdType.AUTO)
    private Integer resumeId;
    /**
     * user_id
     */
    private Integer resumeUserId;
    /**
     * 姓名
     */
    private String resumeName;
    /**
     * 性别(0:男，1:女)
     */
    private Integer resumeSex;
    /**
     * 生日 (格式:2018-11-23)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date resumeBirthday;
    /**
     * 婚姻状况(0:已婚，1:未婚，2:其他)
     */
    private Integer resumeMarriage;
    /**
     * 身高
     */
    private String resumeHeight;
    /**
     * 体重
     */
    private String resumeBodyWeight;
    /**
     * 居住地
     */
    private String resumePlace;
    /**
     * 联系方式
     */
    private String resumeContact;
    /**
     * 联系手机
     */
    private String resumePhone;
    /**
     * 电子邮件
     */
    private String resumeEmail;
    /**
     * 学历(0:初中，1:高中，2:中专，3:大专，4:本科，5:硕士，6:博士)
     */
    private Integer resumeEducation;
    /**
     * 毕业院校
     */
    private String resumeSchool;
    /**
     * 专业
     */
    private String resumeProfession;
    /**
     * 工作性质(0:不限，1:全职，2:兼职，3:实习)
     */
    private Integer resumeWorkNature;
    /**
     * 工作经验(0:1年以下，1:1年以上，2:2年以上，3:3年以上…，20:20年以上)
     */
    private Integer resumeWorkExperience;
    /**
     * 行业意向(0:不限，1:机械装备制造，2:电子信息，3:铝深加工，4:食品加工，5:生物制药，6:清洁能源，7:其他行业)
     */
    private Integer resumeIndustryIntention;
    /**
     * 职位意向(0:不限，1:经营管理类，2:行政/人事/后勤类，3:财务/税务/审计类，4:生产制造/工工管理类，5:市场/销售类，6:客服/计算机服务类，7:计算机/互联网类，8:科研/咨询类，9:证券/金融/投资类，10:其他类)
     */
    private Integer resumeJobIntention;
    /**
     * 专业技能
     */
    private String resumeProfessionalSkill;
    /**
     * 期望薪资
     */
    private String resumeSalary;
    /**
     * 求职状态(0:目前正在找工作,1:观望有好机会会考虑,2:目前不想换工作)
     */
    private Integer resumeJobStatus;
    /**
     * 自我介绍（500字以内）
     */
    private String resumeIntroduction;
    /**
     * 创建人
     */
    private Integer resumeCreateBy;
    /**
     * 修改人
     */
    private Integer resumeUpdateBy;
    /**
     * 修改时间
     */
    private Date resumeUpdateTime;
    /**
     * 创建时间
     */
    private Date resumeCreateTime;


    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getResumeUserId() {
        return resumeUserId;
    }

    public void setResumeUserId(Integer resumeUserId) {
        this.resumeUserId = resumeUserId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public Date getResumeBirthday() {
        return resumeBirthday;
    }

    public void setResumeBirthday(Date resumeBirthday) {
        this.resumeBirthday = resumeBirthday;
    }

    public Integer getResumeMarriage() {
        return resumeMarriage;
    }

    public void setResumeMarriage(Integer resumeMarriage) {
        this.resumeMarriage = resumeMarriage;
    }

    public String getResumeHeight() {
        return resumeHeight;
    }

    public void setResumeHeight(String resumeHeight) {
        this.resumeHeight = resumeHeight;
    }

    public String getResumeBodyWeight() {
        return resumeBodyWeight;
    }

    public void setResumeBodyWeight(String resumeBodyWeight) {
        this.resumeBodyWeight = resumeBodyWeight;
    }

    public String getResumePlace() {
        return resumePlace;
    }

    public void setResumePlace(String resumePlace) {
        this.resumePlace = resumePlace;
    }

    public String getResumeContact() {
        return resumeContact;
    }

    public void setResumeContact(String resumeContact) {
        this.resumeContact = resumeContact;
    }

    public String getResumePhone() {
        return resumePhone;
    }

    public void setResumePhone(String resumePhone) {
        this.resumePhone = resumePhone;
    }

    public String getResumeEmail() {
        return resumeEmail;
    }

    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail;
    }

    public Integer getResumeEducation() {
        return resumeEducation;
    }

    public void setResumeEducation(Integer resumeEducation) {
        this.resumeEducation = resumeEducation;
    }

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool;
    }

    public String getResumeProfession() {
        return resumeProfession;
    }

    public void setResumeProfession(String resumeProfession) {
        this.resumeProfession = resumeProfession;
    }

    public Integer getResumeWorkNature() {
        return resumeWorkNature;
    }

    public void setResumeWorkNature(Integer resumeWorkNature) {
        this.resumeWorkNature = resumeWorkNature;
    }

    public Integer getResumeWorkExperience() {
        return resumeWorkExperience;
    }

    public void setResumeWorkExperience(Integer resumeWorkExperience) {
        this.resumeWorkExperience = resumeWorkExperience;
    }

    public Integer getResumeIndustryIntention() {
        return resumeIndustryIntention;
    }

    public void setResumeIndustryIntention(Integer resumeIndustryIntention) {
        this.resumeIndustryIntention = resumeIndustryIntention;
    }

    public Integer getResumeJobIntention() {
        return resumeJobIntention;
    }

    public void setResumeJobIntention(Integer resumeJobIntention) {
        this.resumeJobIntention = resumeJobIntention;
    }

    public String getResumeProfessionalSkill() {
        return resumeProfessionalSkill;
    }

    public void setResumeProfessionalSkill(String resumeProfessionalSkill) {
        this.resumeProfessionalSkill = resumeProfessionalSkill;
    }

    public String getResumeSalary() {
        return resumeSalary;
    }

    public void setResumeSalary(String resumeSalary) {
        this.resumeSalary = resumeSalary;
    }

    public Integer getResumeJobStatus() {
        return resumeJobStatus;
    }

    public void setResumeJobStatus(Integer resumeJobStatus) {
        this.resumeJobStatus = resumeJobStatus;
    }

    public String getResumeIntroduction() {
        return resumeIntroduction;
    }

    public void setResumeIntroduction(String resumeIntroduction) {
        this.resumeIntroduction = resumeIntroduction;
    }

    public Integer getResumeCreateBy() {
        return resumeCreateBy;
    }

    public void setResumeCreateBy(Integer resumeCreateBy) {
        this.resumeCreateBy = resumeCreateBy;
    }

    public Integer getResumeUpdateBy() {
        return resumeUpdateBy;
    }

    public void setResumeUpdateBy(Integer resumeUpdateBy) {
        this.resumeUpdateBy = resumeUpdateBy;
    }

    public Date getResumeUpdateTime() {
        return resumeUpdateTime;
    }

    public void setResumeUpdateTime(Date resumeUpdateTime) {
        this.resumeUpdateTime = resumeUpdateTime;
    }

    public Date getResumeCreateTime() {
        return resumeCreateTime;
    }

    public void setResumeCreateTime(Date resumeCreateTime) {
        this.resumeCreateTime = resumeCreateTime;
    }

    public Integer getResumeSex() {
        return resumeSex;
    }

    public void setResumeSex(Integer resumeSex) {
        this.resumeSex = resumeSex;
    }

    @Override
    protected Serializable pkVal() {
        return this.resumeId;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resumeId=" + resumeId +
                ", resumeUserId=" + resumeUserId +
                ", resumeName='" + resumeName + '\'' +
                ", resumeSex=" + resumeSex +
                ", resumeBirthday=" + resumeBirthday +
                ", resumeMarriage=" + resumeMarriage +
                ", resumeHeight='" + resumeHeight + '\'' +
                ", resumeBodyWeight='" + resumeBodyWeight + '\'' +
                ", resumePlace='" + resumePlace + '\'' +
                ", resumeContact='" + resumeContact + '\'' +
                ", resumePhone='" + resumePhone + '\'' +
                ", resumeEmail='" + resumeEmail + '\'' +
                ", resumeEducation=" + resumeEducation +
                ", resumeSchool='" + resumeSchool + '\'' +
                ", resumeProfession='" + resumeProfession + '\'' +
                ", resumeWorkNature=" + resumeWorkNature +
                ", resumeWorkExperience=" + resumeWorkExperience +
                ", resumeIndustryIntention=" + resumeIndustryIntention +
                ", resumeJobIntention=" + resumeJobIntention +
                ", resumeProfessionalSkill='" + resumeProfessionalSkill + '\'' +
                ", resumeSalary='" + resumeSalary + '\'' +
                ", resumeJobStatus=" + resumeJobStatus +
                ", resumeIntroduction='" + resumeIntroduction + '\'' +
                ", resumeCreateBy=" + resumeCreateBy +
                ", resumeUpdateBy=" + resumeUpdateBy +
                ", resumeUpdateTime=" + resumeUpdateTime +
                ", resumeCreateTime=" + resumeCreateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(resumeId, resume.resumeId) &&
                Objects.equals(resumeUserId, resume.resumeUserId) &&
                Objects.equals(resumeName, resume.resumeName) &&
                Objects.equals(resumeSex, resume.resumeSex) &&
                Objects.equals(resumeBirthday, resume.resumeBirthday) &&
                Objects.equals(resumeMarriage, resume.resumeMarriage) &&
                Objects.equals(resumeHeight, resume.resumeHeight) &&
                Objects.equals(resumeBodyWeight, resume.resumeBodyWeight) &&
                Objects.equals(resumePlace, resume.resumePlace) &&
                Objects.equals(resumeContact, resume.resumeContact) &&
                Objects.equals(resumePhone, resume.resumePhone) &&
                Objects.equals(resumeEmail, resume.resumeEmail) &&
                Objects.equals(resumeEducation, resume.resumeEducation) &&
                Objects.equals(resumeSchool, resume.resumeSchool) &&
                Objects.equals(resumeProfession, resume.resumeProfession) &&
                Objects.equals(resumeWorkNature, resume.resumeWorkNature) &&
                Objects.equals(resumeWorkExperience, resume.resumeWorkExperience) &&
                Objects.equals(resumeIndustryIntention, resume.resumeIndustryIntention) &&
                Objects.equals(resumeJobIntention, resume.resumeJobIntention) &&
                Objects.equals(resumeProfessionalSkill, resume.resumeProfessionalSkill) &&
                Objects.equals(resumeSalary, resume.resumeSalary) &&
                Objects.equals(resumeJobStatus, resume.resumeJobStatus) &&
                Objects.equals(resumeIntroduction, resume.resumeIntroduction) &&
                Objects.equals(resumeCreateBy, resume.resumeCreateBy) &&
                Objects.equals(resumeUpdateBy, resume.resumeUpdateBy) &&
                Objects.equals(resumeUpdateTime, resume.resumeUpdateTime) &&
                Objects.equals(resumeCreateTime, resume.resumeCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resumeId, resumeUserId, resumeName, resumeSex, resumeBirthday, resumeMarriage, resumeHeight, resumeBodyWeight, resumePlace, resumeContact, resumePhone, resumeEmail, resumeEducation, resumeSchool, resumeProfession, resumeWorkNature, resumeWorkExperience, resumeIndustryIntention, resumeJobIntention, resumeProfessionalSkill, resumeSalary, resumeJobStatus, resumeIntroduction, resumeCreateBy, resumeUpdateBy, resumeUpdateTime, resumeCreateTime);
    }
}
