package com.youedata.nncloud.modular.nanning.model;

import com.youedata.nncloud.modular.nanning.anno.Too;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 财务报表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Finance extends Model<Finance> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "finance_id", type = IdType.AUTO)
    private Integer financeId;
    /**
     * 企业id
     */
    @Too(value="enterprise_id")
    private String financeEnterpriseId;
    /**
     * 财务名称
     */
    @Too(value="title")
    private String financeName;
    /**
     * 财务状况(年月日期)
     */
    @Too(value="report_month")
    private Integer financeYear;
    /**
     * 单位负责人
     */

    @Too(value="report_corporation")
    private String financeCompany;
    /**
     * 统计负责人
     */
    @Too(value="report_totalname")
    private String financeStatistics;
    /**
     * 填报人
     */
    @Too(value="report_createname")
    private String financeApplicant;
    /**
     * 手机号码
     */
    @Too(value="report_mobile")
    private String financePhone;
    /**
     * 填报情况描述
     */
    @Too(value="remarks")
    private String financeExplain;
    /**
     * 状态 0:待提交 1:待审核 2:已审核 3:已反审
     */
    @Too(value="status")
    private String financeStatus;
    /**
     * 创建时间
     */
    private Date financeTime;
    
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

	public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Integer getFinanceYear() {
        return financeYear;
    }

    public void setFinanceYear(Integer financeYear) {
        this.financeYear = financeYear;
    }

    public String getFinanceCompany() {
        return financeCompany;
    }

    public void setFinanceCompany(String financeCompany) {
        this.financeCompany = financeCompany;
    }

    public String getFinanceStatistics() {
        return financeStatistics;
    }

    public void setFinanceStatistics(String financeStatistics) {
        this.financeStatistics = financeStatistics;
    }

    public String getFinanceApplicant() {
        return financeApplicant;
    }

    public void setFinanceApplicant(String financeApplicant) {
        this.financeApplicant = financeApplicant;
    }

    public String getFinancePhone() {
        return financePhone;
    }

    public void setFinancePhone(String financePhone) {
        this.financePhone = financePhone;
    }

    public String getFinanceExplain() {
        return financeExplain;
    }

    public void setFinanceExplain(String financeExplain) {
        this.financeExplain = financeExplain;
    }

    public String getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(String financeStatus) {
        this.financeStatus = financeStatus;
    }

    public Date getFinanceTime() {
        return financeTime;
    }

    public void setFinanceTime(Date financeTime) {
        this.financeTime = financeTime;
    }

	public String getFinanceEnterpriseId() {
		return financeEnterpriseId;
	}

	public void setFinanceEnterpriseId(String financeEnterpriseId) {
		this.financeEnterpriseId = financeEnterpriseId;
	}

	public String getFinanceName() {
		return financeName;
	}

	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}

	@Override
    protected Serializable pkVal() {
        return this.financeId;
    }

	@Override
	public String toString() {
		return "Finance [financeId=" + financeId + ", financeEnterpriseId=" + financeEnterpriseId + ", financeName="
				+ financeName + ", financeYear=" + financeYear + ", financeCompany=" + financeCompany
				+ ", financeStatistics=" + financeStatistics + ", financeApplicant=" + financeApplicant
				+ ", financePhone=" + financePhone + ", financeExplain=" + financeExplain + ", financeStatus="
				+ financeStatus + ", financeTime=" + financeTime + "]";
	}

}
