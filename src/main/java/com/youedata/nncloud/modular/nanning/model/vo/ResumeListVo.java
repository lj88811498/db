package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Date;
import java.util.Objects;

public class ResumeListVo {
    /**
     * user_id
     */
    private Integer resumeUserId;
    /**
     * 姓名
     */
    private String resumeName;
    /**
     * 毕业院校
     */
    private String resumeSchool;
    /**
     * 行业意向(0:不限，1:机械装备制造，2:电子信息，3:铝深加工，4:食品加工，5:生物制药，6:清洁能源，7:其他行业)
     */
    private Integer resumeIndustryIntention;
    /**
     * 职位意向(0:不限，1:经营管理类，2:行政/人事/后勤类，3:财务/税务/审计类，4:生产制造/工工管理类，5:市场/销售类，6:客服/计算机服务类，7:计算机/互联网类，8:科研/咨询类，9:证券/金融/投资类，10:其他类)
     */
    private Integer resumeJobIntention;
    /**
     * 工作经验(0:1年以下，1:1年以上，2:2年以上，3:3年以上…，20:20年以上)
     */
    private Integer resumeWorkExperience;
    /**
     * 修改时间
     */
    private Date resumeUpdateTime;

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

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool;
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

    public Integer getResumeWorkExperience() {
        return resumeWorkExperience;
    }

    public void setResumeWorkExperience(Integer resumeWorkExperience) {
        this.resumeWorkExperience = resumeWorkExperience;
    }

    public Date getResumeUpdateTime() {
        return resumeUpdateTime;
    }

    public void setResumeUpdateTime(Date resumeUpdateTime) {
        this.resumeUpdateTime = resumeUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResumeListVo)) return false;
        ResumeListVo that = (ResumeListVo) o;
        return Objects.equals(resumeUserId, that.resumeUserId) &&
                Objects.equals(resumeName, that.resumeName) &&
                Objects.equals(resumeSchool, that.resumeSchool) &&
                Objects.equals(resumeIndustryIntention, that.resumeIndustryIntention) &&
                Objects.equals(resumeJobIntention, that.resumeJobIntention) &&
                Objects.equals(resumeWorkExperience, that.resumeWorkExperience) &&
                Objects.equals(resumeUpdateTime, that.resumeUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resumeUserId, resumeName, resumeSchool, resumeIndustryIntention, resumeJobIntention, resumeWorkExperience, resumeUpdateTime);
    }

    @Override
    public String toString() {
        return "ResumeListVo{" +
                "resumeUserId=" + resumeUserId +
                ", resumeName='" + resumeName + '\'' +
                ", resumeSchool='" + resumeSchool + '\'' +
                ", resumeIndustryIntention=" + resumeIndustryIntention +
                ", resumeJobIntention=" + resumeJobIntention +
                ", resumeWorkExperience=" + resumeWorkExperience +
                ", resumeUpdateTime=" + resumeUpdateTime +
                '}';
    }
}
