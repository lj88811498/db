package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 工业报表详情表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class IndustryDetails extends Model<IndustryDetails> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "industry_details_id", type = IdType.AUTO)
    private Integer industryDetailsId;
    /**
     * 小标题名
     */
    private String industryDetailsName;
    /**
     * 年月时间(如:2018年4月)
     */
    private Integer industryDetailsYear1;
    /**
     * 年月时间(如:2017年4月)
     */
    private Integer industryDetailsYear2;
    /**
     * 本月增数
     */
    private String industryDetailsIncreasingNumber;
    /**
     * 年月时间累积(如:2018年1-4月累积)
     */
    private Integer industryDetailsAccumulate1;
    /**
     * 年月时间累积(如:2017年1-4月累积)
     */
    private Integer industryDetailsAccumulate2;
    /**
     * 累积增数
     */
    private String industryDetailsCumulativeIncrease;
    /**
     * 年月时间预计(如:2017年1-4月预计)
     */
    private String industryDetailsEstimate;
    /**
     * 关联工业报表id
     */
    private Integer industryDetailsIndustryId;
    /**
     * 类型:如(1:工业总产值(当年价格) 2: 工业总产值(当年价格)按工业行业小分类)3:主要工业产品产量 4:补充资料
     */
    private String industryDetailsType;
    /**
     * 创建时间
     */
    private Date industryDetailsTime;
    /**
     * 单位
     */
    private String industryDetailsCompany;


    public Integer getIndustryDetailsId() {
        return industryDetailsId;
    }

    public void setIndustryDetailsId(Integer industryDetailsId) {
        this.industryDetailsId = industryDetailsId;
    }

    public String getIndustryDetailsName() {
        return industryDetailsName;
    }

    public void setIndustryDetailsName(String industryDetailsName) {
        this.industryDetailsName = industryDetailsName;
    }

    public Integer getIndustryDetailsYear1() {
        return industryDetailsYear1;
    }

    public void setIndustryDetailsYear1(Integer industryDetailsYear1) {
        this.industryDetailsYear1 = industryDetailsYear1;
    }

    public Integer getIndustryDetailsYear2() {
        return industryDetailsYear2;
    }

    public void setIndustryDetailsYear2(Integer industryDetailsYear2) {
        this.industryDetailsYear2 = industryDetailsYear2;
    }

    public String getIndustryDetailsIncreasingNumber() {
        return industryDetailsIncreasingNumber;
    }

    public void setIndustryDetailsIncreasingNumber(String industryDetailsIncreasingNumber) {
        this.industryDetailsIncreasingNumber = industryDetailsIncreasingNumber;
    }

    public Integer getIndustryDetailsAccumulate1() {
        return industryDetailsAccumulate1;
    }

    public void setIndustryDetailsAccumulate1(Integer industryDetailsAccumulate1) {
        this.industryDetailsAccumulate1 = industryDetailsAccumulate1;
    }

    public Integer getIndustryDetailsAccumulate2() {
        return industryDetailsAccumulate2;
    }

    public void setIndustryDetailsAccumulate2(Integer industryDetailsAccumulate2) {
        this.industryDetailsAccumulate2 = industryDetailsAccumulate2;
    }

    public String getIndustryDetailsCumulativeIncrease() {
        return industryDetailsCumulativeIncrease;
    }

    public void setIndustryDetailsCumulativeIncrease(String industryDetailsCumulativeIncrease) {
        this.industryDetailsCumulativeIncrease = industryDetailsCumulativeIncrease;
    }

    public String getIndustryDetailsEstimate() {
        return industryDetailsEstimate;
    }

    public void setIndustryDetailsEstimate(String industryDetailsEstimate) {
        this.industryDetailsEstimate = industryDetailsEstimate;
    }

    public Integer getIndustryDetailsIndustryId() {
        return industryDetailsIndustryId;
    }

    public void setIndustryDetailsIndustryId(Integer industryDetailsIndustryId) {
        this.industryDetailsIndustryId = industryDetailsIndustryId;
    }

    public String getIndustryDetailsType() {
        return industryDetailsType;
    }

    public void setIndustryDetailsType(String industryDetailsType) {
        this.industryDetailsType = industryDetailsType;
    }

    public Date getIndustryDetailsTime() {
        return industryDetailsTime;
    }

    public void setIndustryDetailsTime(Date industryDetailsTime) {
        this.industryDetailsTime = industryDetailsTime;
    }
    
    public String getIndustryDetailsCompany() {
		return industryDetailsCompany;
	}

	public void setIndustryDetailsCompany(String industryDetailsCompany) {
		this.industryDetailsCompany = industryDetailsCompany;
	}

	@Override
    protected Serializable pkVal() {
        return this.industryDetailsId;
    }
	
	//本年
	private String newYear;
	//旧年
	private String oldYear;
	//新累计
	private String newAccumulate;
	//旧年累计
	private String oldAccumulate;
	//月预计
	private String estimate;
	
	public String getNewYear() {
		return newYear;
	}

	public void setNewYear(String newYear) {
		this.newYear = newYear;
	}

	public String getOldYear() {
		return oldYear;
	}

	public void setOldYear(String oldYear) {
		this.oldYear = oldYear;
	}

	public String getNewAccumulate() {
		return newAccumulate;
	}

	public void setNewAccumulate(String newAccumulate) {
		this.newAccumulate = newAccumulate;
	}

	public String getOldAccumulate() {
		return oldAccumulate;
	}

	public void setOldAccumulate(String oldAccumulate) {
		this.oldAccumulate = oldAccumulate;
	}

	public String getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}

	@Override
	public String toString() {
		return "IndustryDetails [industryDetailsId=" + industryDetailsId + ", industryDetailsName="
				+ industryDetailsName + ", industryDetailsYear1=" + industryDetailsYear1 + ", industryDetailsYear2="
				+ industryDetailsYear2 + ", industryDetailsIncreasingNumber=" + industryDetailsIncreasingNumber
				+ ", industryDetailsAccumulate1=" + industryDetailsAccumulate1 + ", industryDetailsAccumulate2="
				+ industryDetailsAccumulate2 + ", industryDetailsCumulativeIncrease="
				+ industryDetailsCumulativeIncrease + ", industryDetailsEstimate=" + industryDetailsEstimate
				+ ", industryDetailsIndustryId=" + industryDetailsIndustryId + ", industryDetailsType="
				+ industryDetailsType + ", industryDetailsTime=" + industryDetailsTime + ", industryDetailsCompany="
				+ industryDetailsCompany + "]";
	}
}
