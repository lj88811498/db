package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.youedata.nncloud.modular.nanning.anno.Too;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 知识产权
 * </p>
 *
 * @author Monkey
 * @since 2019-01-21
 */
@ApiModel
public class IntellectualProperty extends Model<IntellectualProperty> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Too(value="id")
    private String intellectualPropertyId;
    /**
     * 产品名称
     */
    @Too(value="name")
    private String intellectualPropertyName;
    /**
     * 图片
     */
    @Too(value="image")
    private String intellectualPropertyImage;
    /**
     * 审批意见
     */
    @Too(value="audit_comment")
    private String intellectualPropertyAuditComment;
    /**
     * 专利号
     */
    @Too(value="patent_no")
    private String intellectualPropertyPatentNo;
    /**
     * 专利主分类号
     */
    @Too(value="IPC")
    private String intellectualPropertyIpc;
    /**
     * 产品介绍
     */
    @Too(value="content")
    private String intellectualPropertyContent;
    /**
     * 转让状态,1:转让。2:不转让
     */
    @Too(value="status")
    private String intellectualPropertyStatus;
    /**
     * 审批状态,0:未通过。1:通过
     */
    @Too(value="audit_status")
    private String intellectualPropertyAuditStatus;
    /**
     * 创建人
     */
    private Integer intellectualPropertyCreateBy;
    /**
     * 修改人
     */
    private Integer intellectualPropertyUpdateBy;
    /**
     * 修改时间
     */
    private Date intellectualPropertyUpdateTime;
    /**
     * 创建时间
     */
    private Date intellectualPropertyCreateTime;


    public String getIntellectualPropertyId() {
        return intellectualPropertyId;
    }

    public void setIntellectualPropertyId(String intellectualPropertyId) {
        this.intellectualPropertyId = intellectualPropertyId;
    }

    public String getIntellectualPropertyName() {
        return intellectualPropertyName;
    }

    public void setIntellectualPropertyName(String intellectualPropertyName) {
        this.intellectualPropertyName = intellectualPropertyName;
    }

    public String getIntellectualPropertyImage() {
        return intellectualPropertyImage;
    }

    public void setIntellectualPropertyImage(String intellectualPropertyImage) {
        this.intellectualPropertyImage = intellectualPropertyImage;
    }

    public String getIntellectualPropertyAuditComment() {
        return intellectualPropertyAuditComment;
    }

    public void setIntellectualPropertyAuditComment(String intellectualPropertyAuditComment) {
        this.intellectualPropertyAuditComment = intellectualPropertyAuditComment;
    }

    public String getIntellectualPropertyPatentNo() {
        return intellectualPropertyPatentNo;
    }

    public void setIntellectualPropertyPatentNo(String intellectualPropertyPatentNo) {
        this.intellectualPropertyPatentNo = intellectualPropertyPatentNo;
    }

    public String getIntellectualPropertyIpc() {
        return intellectualPropertyIpc;
    }

    public void setIntellectualPropertyIpc(String intellectualPropertyIpc) {
        this.intellectualPropertyIpc = intellectualPropertyIpc;
    }

    public String getIntellectualPropertyContent() {
        return intellectualPropertyContent;
    }

    public void setIntellectualPropertyContent(String intellectualPropertyContent) {
        this.intellectualPropertyContent = intellectualPropertyContent;
    }

    public String getIntellectualPropertyStatus() {
        return intellectualPropertyStatus;
    }

    public void setIntellectualPropertyStatus(String intellectualPropertyStatus) {
        this.intellectualPropertyStatus = intellectualPropertyStatus;
    }

    public String getIntellectualPropertyAuditStatus() {
        return intellectualPropertyAuditStatus;
    }

    public void setIntellectualPropertyAuditStatus(String intellectualPropertyAuditStatus) {
        this.intellectualPropertyAuditStatus = intellectualPropertyAuditStatus;
    }

    public Integer getIntellectualPropertyCreateBy() {
        return intellectualPropertyCreateBy;
    }

    public void setIntellectualPropertyCreateBy(Integer intellectualPropertyCreateBy) {
        this.intellectualPropertyCreateBy = intellectualPropertyCreateBy;
    }

    public Integer getIntellectualPropertyUpdateBy() {
        return intellectualPropertyUpdateBy;
    }

    public void setIntellectualPropertyUpdateBy(Integer intellectualPropertyUpdateBy) {
        this.intellectualPropertyUpdateBy = intellectualPropertyUpdateBy;
    }

    public Date getIntellectualPropertyUpdateTime() {
        return intellectualPropertyUpdateTime;
    }

    public void setIntellectualPropertyUpdateTime(Date intellectualPropertyUpdateTime) {
        this.intellectualPropertyUpdateTime = intellectualPropertyUpdateTime;
    }

    public Date getIntellectualPropertyCreateTime() {
        return intellectualPropertyCreateTime;
    }

    public void setIntellectualPropertyCreateTime(Date intellectualPropertyCreateTime) {
        this.intellectualPropertyCreateTime = intellectualPropertyCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.intellectualPropertyId;
    }

    @Override
    public String toString() {
        return "IntellectualProperty{" +
        "intellectualPropertyId=" + intellectualPropertyId +
        ", intellectualPropertyName=" + intellectualPropertyName +
        ", intellectualPropertyImage=" + intellectualPropertyImage +
        ", intellectualPropertyAuditComment=" + intellectualPropertyAuditComment +
        ", intellectualPropertyPatentNo=" + intellectualPropertyPatentNo +
        ", intellectualPropertyIpc=" + intellectualPropertyIpc +
        ", intellectualPropertyContent=" + intellectualPropertyContent +
        ", intellectualPropertyStatus=" + intellectualPropertyStatus +
        ", intellectualPropertyAuditStatus=" + intellectualPropertyAuditStatus +
        ", intellectualPropertyCreateBy=" + intellectualPropertyCreateBy +
        ", intellectualPropertyUpdateBy=" + intellectualPropertyUpdateBy +
        ", intellectualPropertyUpdateTime=" + intellectualPropertyUpdateTime +
        ", intellectualPropertyCreateTime=" + intellectualPropertyCreateTime +
        "}";
    }
}
