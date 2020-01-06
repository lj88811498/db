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
 * 工业报表详情表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class FinanceDetails extends Model<FinanceDetails> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "finance_details_id", type = IdType.AUTO)
    private Integer financeDetailsId;
    /**
     * 小标题名
     */
    @Too(value="index_name")
    private String financeDetailsName;
    /**
     * 年月时间累积(如:2018年1-4月累积)
     */

    @Too(value="finance_details_accumulate1")
    private Integer financeDetailsAccumulate1;
    /**
     * 年月时间累积(如:2017年1-4月累积)
     */
    @Too(value="finance_details_accumulate2")
    private Integer financeDetailsAccumulate2;
    /**
     * 累积增数
     */

    @Too(value="cur_year_growth_rate")
    private String financeDetailsCumulativeIncrease;
    /**
     * 年月时间预计(如:2017年1-4月预计)
     */
    @Too(value="details_estimate")
    private String financeDetailsEstimate;
    /**
     * 关联财务报表id
     */
    private Integer financeDetailsFinanceId;
    /**
     * 类型:如(1:年初存货 2:期末资产负债 3:损益及分配 4:应交增值税 5:平均用工人数)
     */
    private String financeDetailsType;
    /**
     * 创建时间
     */
    private Date financeDetailsTime;
    /**
     * 单位
     */
    @Too(value="unit")
    private String financeDetailsCompany;
    

    public Integer getFinanceDetailsId() {
        return financeDetailsId;
    }

    public void setFinanceDetailsId(Integer financeDetailsId) {
        this.financeDetailsId = financeDetailsId;
    }

    public String getFinanceDetailsName() {
        return financeDetailsName;
    }

    public void setFinanceDetailsName(String financeDetailsName) {
        this.financeDetailsName = financeDetailsName;
    }

    public Integer getFinanceDetailsAccumulate1() {
        return financeDetailsAccumulate1;
    }

    public void setFinanceDetailsAccumulate1(Integer financeDetailsAccumulate1) {
        this.financeDetailsAccumulate1 = financeDetailsAccumulate1;
    }

    public Integer getFinanceDetailsAccumulate2() {
        return financeDetailsAccumulate2;
    }

    public void setFinanceDetailsAccumulate2(Integer financeDetailsAccumulate2) {
        this.financeDetailsAccumulate2 = financeDetailsAccumulate2;
    }

    public String getFinanceDetailsCumulativeIncrease() {
        return financeDetailsCumulativeIncrease;
    }

    public void setFinanceDetailsCumulativeIncrease(String financeDetailsCumulativeIncrease) {
        this.financeDetailsCumulativeIncrease = financeDetailsCumulativeIncrease;
    }

    public String getFinanceDetailsEstimate() {
        return financeDetailsEstimate;
    }

    public void setFinanceDetailsEstimate(String financeDetailsEstimate) {
        this.financeDetailsEstimate = financeDetailsEstimate;
    }

    public Integer getFinanceDetailsFinanceId() {
        return financeDetailsFinanceId;
    }

    public void setFinanceDetailsFinanceId(Integer financeDetailsFinanceId) {
        this.financeDetailsFinanceId = financeDetailsFinanceId;
    }

    public String getFinanceDetailsType() {
        return financeDetailsType;
    }

    public void setFinanceDetailsType(String financeDetailsType) {
        this.financeDetailsType = financeDetailsType;
    }

    public Date getFinanceDetailsTime() {
        return financeDetailsTime;
    }

    public void setFinanceDetailsTime(Date financeDetailsTime) {
        this.financeDetailsTime = financeDetailsTime;
    }

    public String getFinanceDetailsCompany() {
		return financeDetailsCompany;
	}

	public void setFinanceDetailsCompany(String financeDetailsCompany) {
		this.financeDetailsCompany = financeDetailsCompany;
	}

	@Override
    protected Serializable pkVal() {
        return this.financeDetailsId;
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
		return "FinanceDetails [financeDetailsId=" + financeDetailsId + ", financeDetailsName=" + financeDetailsName
				+ ", financeDetailsAccumulate1=" + financeDetailsAccumulate1 + ", financeDetailsAccumulate2="
				+ financeDetailsAccumulate2 + ", financeDetailsCumulativeIncrease=" + financeDetailsCumulativeIncrease
				+ ", financeDetailsEstimate=" + financeDetailsEstimate + ", financeDetailsFinanceId="
				+ financeDetailsFinanceId + ", financeDetailsType=" + financeDetailsType + ", financeDetailsTime="
				+ financeDetailsTime + ", financeDetailsCompany=" + financeDetailsCompany + "]";
	}
   
}
