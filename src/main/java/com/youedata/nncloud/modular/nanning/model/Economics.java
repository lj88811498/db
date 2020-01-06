package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 工业经济运行动态表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-12-13
 */
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Economics extends Model<Economics> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "economics_id", type = IdType.AUTO)
    private Integer economicsId;
    /**
     * 主营业务收入
     */
    private Double economicsIncome;
    /**
     * 利润
     */
    private Double economicsProfit;
    /**
     * 区县 
     */
    private Integer economicsDistrictId;
    /**
     * 某年某月
     */
    @JsonFormat(pattern = "MM", timezone = "GMT+8")  
    private Date economicsTime;
    /**
     * 企业信息id
     */
    private Integer economicsEnterpriseId;
    /**
     * 创建时间
     */
    private Date economicsCreateTime;
    
    private String startTime;
    
    private String endTime;
    
    //同比收入
    private Object yearOnIncome;
    //同比利润
    private Object yearOnProfit;
    //环比利润
    private Object chainRatioProfit;
    //环比收入
    private Object chainRatioIncome;
    
    private String districtName;
    
    private String economicsIndustryId;
    //月份
    private String month;
    

    public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getEconomicsIndustryId() {
		return economicsIndustryId;
	}

	public void setEconomicsIndustryId(String economicsIndustryId) {
		this.economicsIndustryId = economicsIndustryId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Object getYearOnIncome() {
		return yearOnIncome;
	}

	public void setYearOnIncome(Object yearOnIncome) {
		this.yearOnIncome = yearOnIncome;
	}

	public Object getYearOnProfit() {
		return yearOnProfit;
	}

	public void setYearOnProfit(Object yearOnProfit) {
		this.yearOnProfit = yearOnProfit;
	}

	public Object getChainRatioProfit() {
		return chainRatioProfit;
	}

	public void setChainRatioProfit(Object chainRatioProfit) {
		this.chainRatioProfit = chainRatioProfit;
	}

	public Object getChainRatioIncome() {
		return chainRatioIncome;
	}

	public void setChainRatioIncome(Object chainRatioIncome) {
		this.chainRatioIncome = chainRatioIncome;
	}

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

	public Integer getEconomicsId() {
        return economicsId;
    }

    public void setEconomicsId(Integer economicsId) {
        this.economicsId = economicsId;
    }

    public Double getEconomicsIncome() {
        return economicsIncome;
    }

    public void setEconomicsIncome(Double economicsIncome) {
        this.economicsIncome = economicsIncome;
    }

    public Double getEconomicsProfit() {
        return economicsProfit;
    }

    public void setEconomicsProfit(Double economicsProfit) {
        this.economicsProfit = economicsProfit;
    }

    public Integer getEconomicsDistrictId() {
		return economicsDistrictId;
	}

	public void setEconomicsDistrictId(Integer economicsDistrictId) {
		this.economicsDistrictId = economicsDistrictId;
	}

	public Date getEconomicsTime() {
        return economicsTime;
    }

    public void setEconomicsTime(Date economicsTime) {
        this.economicsTime = economicsTime;
    }

    public Integer getEconomicsEnterpriseId() {
        return economicsEnterpriseId;
    }

    public void setEconomicsEnterpriseId(Integer economicsEnterpriseId) {
        this.economicsEnterpriseId = economicsEnterpriseId;
    }

    public Date getEconomicsCreateTime() {
        return economicsCreateTime;
    }

    public void setEconomicsCreateTime(Date economicsCreateTime) {
        this.economicsCreateTime = economicsCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.economicsId;
    }

	@Override
	public String toString() {
		return "Economics [economicsId=" + economicsId + ", economicsIncome=" + economicsIncome + ", economicsProfit="
				+ economicsProfit + ", economicsDistrictId=" + economicsDistrictId + ", economicsTime=" + economicsTime
				+ ", economicsEnterpriseId=" + economicsEnterpriseId + ", economicsCreateTime=" + economicsCreateTime
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", yearOnIncome=" + yearOnIncome
				+ ", yearOnProfit=" + yearOnProfit + ", chainRatioProfit=" + chainRatioProfit + ", chainRatioIncome="
				+ chainRatioIncome + "]";
	}

}
