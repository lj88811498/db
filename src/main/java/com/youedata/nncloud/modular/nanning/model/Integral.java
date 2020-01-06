package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 积分排名表; InnoDB free: 3072 kB
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@ApiModel
public class Integral extends Model<Integral> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "integral_id", type = IdType.AUTO)
    private Integer integralId;
    /**
     * 企业名称
     */
    private String integralEnterpriseName;
    /**
     * 分数
     */
    private Integer integralSorce;
    /**
     * 创建时间
     */
    private Date integralTime;


    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public String getIntegralEnterpriseName() {
        return integralEnterpriseName;
    }

    public void setIntegralEnterpriseName(String integralEnterpriseName) {
        this.integralEnterpriseName = integralEnterpriseName;
    }

    public Integer getIntegralSorce() {
        return integralSorce;
    }

    public void setIntegralSorce(Integer integralSorce) {
        this.integralSorce = integralSorce;
    }

    public Date getIntegralTime() {
        return integralTime;
    }

    public void setIntegralTime(Date integralTime) {
        this.integralTime = integralTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.integralId;
    }

    @Override
    public String toString() {
        return "Integral{" +
        "integralId=" + integralId +
        ", integralEnterpriseName=" + integralEnterpriseName +
        ", integralSorce=" + integralSorce +
        ", integralTime=" + integralTime +
        "}";
    }
}
