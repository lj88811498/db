package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 申报附件
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeclarationAttachment extends Model<DeclarationAttachment> {

    private static final long serialVersionUID = 1L;

    /**
     * 附件id
     */
    @TableId(value = "declaration_attachment_id", type = IdType.AUTO)
    private Integer declarationAttachmentId;
    /**
     * 关联申报id
     */
    private Integer declarationAttachmentRelId;
    /**
     * 附件规则id
     */
    private Integer declarationAttachmentRuleId;

    /**
     * 文件名称
     */
    private String declarationAttachmentName;
    /**
     * 文件地址
     */
    private String declarationAttachmentUrl;
    /**
     * 创建人
     */
    private Integer declarationAttachmentCreateBy;
    /**
     * 创建时间
     */
    private Date declarationAttachmentCreateTime;
    /**
     * 功能类型
     */
    private String declarationAttachmentType;


    public Integer getDeclarationAttachmentId() {
        return declarationAttachmentId;
    }

    public void setDeclarationAttachmentId(Integer declarationAttachmentId) {
        this.declarationAttachmentId = declarationAttachmentId;
    }

    public Integer getDeclarationAttachmentRelId() {
        return declarationAttachmentRelId;
    }

    public void setDeclarationAttachmentRelId(Integer declarationAttachmentRelId) {
        this.declarationAttachmentRelId = declarationAttachmentRelId;
    }

    public String getDeclarationAttachmentName() {
        return declarationAttachmentName;
    }

    public void setDeclarationAttachmentName(String declarationAttachmentName) {
        this.declarationAttachmentName = declarationAttachmentName;
    }

    public String getDeclarationAttachmentUrl() {
        return declarationAttachmentUrl;
    }

    public void setDeclarationAttachmentUrl(String declarationAttachmentUrl) {
        this.declarationAttachmentUrl = declarationAttachmentUrl;
    }

    public Integer getDeclarationAttachmentCreateBy() {
        return declarationAttachmentCreateBy;
    }

    public void setDeclarationAttachmentCreateBy(Integer declarationAttachmentCreateBy) {
        this.declarationAttachmentCreateBy = declarationAttachmentCreateBy;
    }

    public Date getDeclarationAttachmentCreateTime() {
        return declarationAttachmentCreateTime;
    }

    public void setDeclarationAttachmentCreateTime(Date declarationAttachmentCreateTime) {
        this.declarationAttachmentCreateTime = declarationAttachmentCreateTime;
    }

    public String getDeclarationAttachmentType() {
        return declarationAttachmentType;
    }

    public void setDeclarationAttachmentType(String declarationAttachmentType) {
        this.declarationAttachmentType = declarationAttachmentType;
    }

    @Override
    protected Serializable pkVal() {
        return this.declarationAttachmentId;
    }


    public Integer getDeclarationAttachmentRuleId() {
        return declarationAttachmentRuleId;
    }

    public void setDeclarationAttachmentRuleId(Integer declarationAttachmentRuleId) {
        this.declarationAttachmentRuleId = declarationAttachmentRuleId;
    }

    @Override
    public String toString() {
        return "DeclarationAttachment{" +
                "declarationAttachmentId=" + declarationAttachmentId +
                ", declarationAttachmentRelId=" + declarationAttachmentRelId +
                ", declarationAttachmentRuleId=" + declarationAttachmentRuleId +
                ", declarationAttachmentName='" + declarationAttachmentName + '\'' +
                ", declarationAttachmentUrl='" + declarationAttachmentUrl + '\'' +
                ", declarationAttachmentCreateBy=" + declarationAttachmentCreateBy +
                ", declarationAttachmentCreateTime=" + declarationAttachmentCreateTime +
                ", declarationAttachmentType='" + declarationAttachmentType + '\'' +
                '}';
    }
}
