package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 区县得分排名表
 * </p>
 *
 * @author Monkey
 * @since 2018-12-12
 */
@ApiModel
public class District extends Model<District> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "district_id", type = IdType.AUTO)
    private Integer districtId;
    /**
     * 区县名称
     */
    private String districtName;
    /**
     * 分数
     */
    private Integer districtScore;
    /**
     * 创建时间
     */
    private Date districtTime;


    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getDistrictScore() {
        return districtScore;
    }

    public void setDistrictScore(Integer districtScore) {
        this.districtScore = districtScore;
    }

    public Date getDistrictTime() {
        return districtTime;
    }

    public void setDistrictTime(Date districtTime) {
        this.districtTime = districtTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.districtId;
    }

    @Override
    public String toString() {
        return "District{" +
        "districtId=" + districtId +
        ", districtName=" + districtName +
        ", districtScore=" + districtScore +
        ", districtTime=" + districtTime +
        "}";
    }
}
