package com.youedata.nncloud.modular.nanning.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 政府在线
 * </p>
 *
 * @author Monkey
 * @since 2018-11-14
 */
@ApiModel
public class GovernmentOnline extends Model<GovernmentOnline> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "government_online_id", type = IdType.AUTO)
    private Integer governmentOnlineId;
    /**
     * 单位名称
     */
    private String governmentOnlineName;
    /**
     * 联系电话
     */
    private String governmentOnlinePhone;
    /**
     * 邮箱地址
     */
    private String governmentOnlineEmail;
    /**
     * 公司地址
     */
    private String governmentOnlineAddress;
    /**
     * 公司网址
     */
    private String governmentOnlineWebsite;
    /**
     * 是否被删除：0、否；1、是
     */
    private String governmentOnlineIsDelete;
    /**
     * 状态：0、未发布；1、已发布
     */
    private String governmentOnlineStatus;
    /**
     * 创建人
     */
    private Integer governmentOnlineCreateBy;
    /**
     * 创建时间
     */
    private Date governmentOnlineCreateTime;


    public Integer getGovernmentOnlineId() {
        return governmentOnlineId;
    }

    public void setGovernmentOnlineId(Integer governmentOnlineId) {
        this.governmentOnlineId = governmentOnlineId;
    }

    public String getGovernmentOnlineName() {
        return governmentOnlineName;
    }

    public void setGovernmentOnlineName(String governmentOnlineName) {
        this.governmentOnlineName = governmentOnlineName;
    }

    public String getGovernmentOnlinePhone() {
        return governmentOnlinePhone;
    }

    public void setGovernmentOnlinePhone(String governmentOnlinePhone) {
        this.governmentOnlinePhone = governmentOnlinePhone;
    }

    public String getGovernmentOnlineEmail() {
        return governmentOnlineEmail;
    }

    public void setGovernmentOnlineEmail(String governmentOnlineEmail) {
        this.governmentOnlineEmail = governmentOnlineEmail;
    }

    public String getGovernmentOnlineAddress() {
        return governmentOnlineAddress;
    }

    public void setGovernmentOnlineAddress(String governmentOnlineAddress) {
        this.governmentOnlineAddress = governmentOnlineAddress;
    }

    public String getGovernmentOnlineWebsite() {
        return governmentOnlineWebsite;
    }

    public void setGovernmentOnlineWebsite(String governmentOnlineWebsite) {
        this.governmentOnlineWebsite = governmentOnlineWebsite;
    }

    public String getGovernmentOnlineIsDelete() {
        return governmentOnlineIsDelete;
    }

    public void setGovernmentOnlineIsDelete(String governmentOnlineIsDelete) {
        this.governmentOnlineIsDelete = governmentOnlineIsDelete;
    }

    public String getGovernmentOnlineStatus() {
        return governmentOnlineStatus;
    }

    public void setGovernmentOnlineStatus(String governmentOnlineStatus) {
        this.governmentOnlineStatus = governmentOnlineStatus;
    }

    public Integer getGovernmentOnlineCreateBy() {
        return governmentOnlineCreateBy;
    }

    public void setGovernmentOnlineCreateBy(Integer governmentOnlineCreateBy) {
        this.governmentOnlineCreateBy = governmentOnlineCreateBy;
    }

    public Date getGovernmentOnlineCreateTime() {
        return governmentOnlineCreateTime;
    }

    public void setGovernmentOnlineCreateTime(Date governmentOnlineCreateTime) {
        this.governmentOnlineCreateTime = governmentOnlineCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.governmentOnlineId;
    }

    @Override
    public String toString() {
        return "GovernmentOnline{" +
        "governmentOnlineId=" + governmentOnlineId +
        ", governmentOnlineName=" + governmentOnlineName +
        ", governmentOnlinePhone=" + governmentOnlinePhone +
        ", governmentOnlineEmail=" + governmentOnlineEmail +
        ", governmentOnlineAddress=" + governmentOnlineAddress +
        ", governmentOnlineWebsite=" + governmentOnlineWebsite +
        ", governmentOnlineIsDelete=" + governmentOnlineIsDelete +
        ", governmentOnlineStatus=" + governmentOnlineStatus +
        ", governmentOnlineCreateBy=" + governmentOnlineCreateBy +
        ", governmentOnlineCreateTime=" + governmentOnlineCreateTime +
        "}";
    }
}
