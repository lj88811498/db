package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 工业报表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Industry extends Model<Industry> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "industry_id", type = IdType.AUTO)
    private Integer industryId;
    /**
     * 企业id
     */
    private String industryEnterpriseId;
    /**
     * 工业名称
     */
    private String industryName;
    /**
     * 年月时间
     */
    private Integer industryYear;
    /**
     * 单位负责人
     */
    private String industryCompany;
    /**
     * 统计负责人
     */
    private String industryStatistics;
    /**
     * 填报人
     */
    private String industryApplicant;
    /**
     * 手机号码
     */
    private String industryPhone;
    /**
     * 填报情况描述
     */
    private String industryExplain;
    /**
     * 状态 0:待提交 1:待审核 2:已审核
     */
    private String industryStatus;
    /**
     * 创建时间
     */
    private Date industryTime;
    
    //企业名称
    private String enterpriseName; 
    //开始时间
    private String startTime;
    //截至时间
    private String endTime;
    
    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getIndustryYear() {
        return industryYear;
    }

    public void setIndustryYear(Integer industryYear) {
        this.industryYear = industryYear;
    }

    public String getIndustryCompany() {
        return industryCompany;
    }

    public void setIndustryCompany(String industryCompany) {
        this.industryCompany = industryCompany;
    }

    public String getIndustryStatistics() {
        return industryStatistics;
    }

    public void setIndustryStatistics(String industryStatistics) {
        this.industryStatistics = industryStatistics;
    }

    public String getIndustryApplicant() {
        return industryApplicant;
    }

    public void setIndustryApplicant(String industryApplicant) {
        this.industryApplicant = industryApplicant;
    }

    public String getIndustryPhone() {
        return industryPhone;
    }

    public void setIndustryPhone(String industryPhone) {
        this.industryPhone = industryPhone;
    }

    public String getIndustryExplain() {
        return industryExplain;
    }

    public void setIndustryExplain(String industryExplain) {
        this.industryExplain = industryExplain;
    }

    public String getIndustryStatus() {
        return industryStatus;
    }

    public void setIndustryStatus(String industryStatus) {
        this.industryStatus = industryStatus;
    }

    public Date getIndustryTime() {
        return industryTime;
    }

    public void setIndustryTime(Date industryTime) {
        this.industryTime = industryTime;
    }

	public String getIndustryEnterpriseId() {
		return industryEnterpriseId;
	}

	public void setIndustryEnterpriseId(String industryEnterpriseId) {
		this.industryEnterpriseId = industryEnterpriseId;
	}

	@Override
    protected Serializable pkVal() {
        return this.industryId;
    }

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	@Override
	public String toString() {
		return "Industry [industryId=" + industryId + ", industryEnterpriseId=" + industryEnterpriseId
				+ ", industryName=" + industryName + ", industryYear=" + industryYear + ", industryCompany="
				+ industryCompany + ", industryStatistics=" + industryStatistics + ", industryApplicant="
				+ industryApplicant + ", industryPhone=" + industryPhone + ", industryExplain=" + industryExplain
				+ ", industryStatus=" + industryStatus + ", industryTime=" + industryTime + ", enterpriseName="
				+ enterpriseName + "]";
	}
}
