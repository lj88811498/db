package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 附件规则
 * </p>
 *
 * @author Monkey
 * @since 2018-12-07
 */
@ApiModel
public class AttachmentRule extends Model<AttachmentRule> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "attachment_rule_id", type = IdType.AUTO)
    private Integer attachmentRuleId;
    /**
     * 项目类型id
     */
    private Integer attachmentRuleProjectId;
    /**
     * 附件名称
     */
    private String attachmentRuleName;
    /**
     * 附件要求
     */
    private String attachmentRuleDemand;
    /**
     * 是否必须（0：否，1：是）
     */
    private String attachmentRuleIsMust;
    /**
     * 备注
     */
    private String attachmentRuleRemark;

    /**
     * 存放图片地址和图片名称
     */
    private List fileList;


    public Integer getAttachmentRuleId() {
        return attachmentRuleId;
    }

    public void setAttachmentRuleId(Integer attachmentRuleId) {
        this.attachmentRuleId = attachmentRuleId;
    }

    public Integer getAttachmentRuleProjectId() {
        return attachmentRuleProjectId;
    }

    public void setAttachmentRuleProjectId(Integer attachmentRuleProjectId) {
        this.attachmentRuleProjectId = attachmentRuleProjectId;
    }

    public String getAttachmentRuleName() {
        return attachmentRuleName;
    }

    public void setAttachmentRuleName(String attachmentRuleName) {
        this.attachmentRuleName = attachmentRuleName;
    }

    public String getAttachmentRuleDemand() {
        return attachmentRuleDemand;
    }

    public void setAttachmentRuleDemand(String attachmentRuleDemand) {
        this.attachmentRuleDemand = attachmentRuleDemand;
    }

    public String getAttachmentRuleIsMust() {
        return attachmentRuleIsMust;
    }

    public void setAttachmentRuleIsMust(String attachmentRuleIsMust) {
        this.attachmentRuleIsMust = attachmentRuleIsMust;
    }

    public String getAttachmentRuleRemark() {
        return attachmentRuleRemark;
    }

    public void setAttachmentRuleRemark(String attachmentRuleRemark) {
        this.attachmentRuleRemark = attachmentRuleRemark;
    }


    @Override
    protected Serializable pkVal() {
        return this.attachmentRuleId;
    }

    @Override
    public String toString() {
        return "AttachmentRule{" +
        "attachmentRuleId=" + attachmentRuleId +
        ", attachmentRuleProjectId=" + attachmentRuleProjectId +
        ", attachmentRuleName=" + attachmentRuleName +
        ", attachmentRuleDemand=" + attachmentRuleDemand +
        ", attachmentRuleIsMust=" + attachmentRuleIsMust +
        ", attachmentRuleRemark=" + attachmentRuleRemark +
        "}";
    }

    public List getFileList() {
        return fileList;
    }

    public void setFileList(List fileList) {
        this.fileList = fileList;
    }
}
