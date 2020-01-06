package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * pro投融资项目余额表附表(用于拆分存储到期时间); InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-12-26
 */
@ApiModel
public class InvestSchedule extends Model<InvestSchedule> {

    private static final long serialVersionUID = 1L;

    /**
     * 对应pro投融资项目余额表里的id
     */
    private Integer investScheduleId;
    /**
     * 到期日
     */
    private String investScheduleMatchDate;
    /**
     * 1 : 到期日-平台银行自营, 2 : 到期日-平台配套
     */
    private Integer investScheduleType;
	public Integer getInvestScheduleId() {
		return investScheduleId;
	}
	public void setInvestScheduleId(Integer investScheduleId) {
		this.investScheduleId = investScheduleId;
	}
	public String getInvestScheduleMatchDate() {
		return investScheduleMatchDate;
	}
	public void setInvestScheduleMatchDate(String investScheduleMatchDate) {
		this.investScheduleMatchDate = investScheduleMatchDate;
	}
	public Integer getInvestScheduleType() {
		return investScheduleType;
	}
	public void setInvestScheduleType(Integer investScheduleType) {
		this.investScheduleType = investScheduleType;
	}
	@Override
	public String toString() {
		return "InvestSchedule [investScheduleId=" + investScheduleId + ", investScheduleMatchDate="
				+ investScheduleMatchDate + ", investScheduleType=" + investScheduleType + "]";
	}
	@Override
	protected Serializable pkVal() {
		return null;
	}
}
