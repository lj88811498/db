package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 重点企业信息——产值表
 * </p>
 *
 * @author sunjian
 * @Date 2018/12/12
 */
@ApiModel
public class OutputValue extends Model<OutputValue> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "district_id", type = IdType.AUTO)
    private Integer outputValueId;

    private Integer outputValueEnterpriseId;

    private Double outputValueDetail;

    private Integer outputValueTime;

    public Integer getOutputValueId() {
        return outputValueId;
    }

    public void setOutputValueId(Integer outputValueId) {
        this.outputValueId = outputValueId;
    }

    public Integer getOutputValueEnterpriseId() {
        return outputValueEnterpriseId;
    }

    public void setOutputValueEnterpriseId(Integer outputValueEnterpriseId) {
        this.outputValueEnterpriseId = outputValueEnterpriseId;
    }

    public Double getOutputValueDetail() {
        return outputValueDetail;
    }

    public void setOutputValueDetail(Double outputValueDetail) {
        this.outputValueDetail = outputValueDetail;
    }

    public Integer getOutputValueTime() {
        return outputValueTime;
    }

    public void setOutputValueTime(Integer outputValueTime) {
        this.outputValueTime = outputValueTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.outputValueId;
    }
}
