package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 系统通知
 * </p>
 *
 * @author Monkey
 * @since 2018-11-28
 */
@ApiModel
public class WebMessage extends Model<WebMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "web_message_id", type = IdType.AUTO)
    private Integer webMessageId;
    /**
     * user_id
     */
    private Integer webMessageUserId;
    /**
     * 消息内容
     */
    private String webMessageContext;
    /**
     * 发送时间
     */
    private Date webMessageSendTime;
    /**
     * 用户类型(0：未认证，1：认证企业，2：认证个人，3：政府用户)多个选项以英文逗号分隔
     */
    private String webMessageUserKind;
    /**
     * 状态(0：草稿，1：发布)
     */
    private Integer webMessageState;
    /**
     * 创建人
     */
    private Integer webMessageCreateBy;
    /**
     * 修改人
     */
    private Integer webMessageUpdateBy;
    /**
     * 修改时间
     */
    private Date webMessageUpdateTime;
    /**
     * 创建时间
     */
    private Date webMessageCreateTime;


    public Integer getWebMessageId() {
        return webMessageId;
    }

    public void setWebMessageId(Integer webMessageId) {
        this.webMessageId = webMessageId;
    }

    public Integer getWebMessageUserId() {
        return webMessageUserId;
    }

    public void setWebMessageUserId(Integer webMessageUserId) {
        this.webMessageUserId = webMessageUserId;
    }

    public String getWebMessageContext() {
        return webMessageContext;
    }

    public void setWebMessageContext(String webMessageContext) {
        this.webMessageContext = webMessageContext;
    }

    public Date getWebMessageSendTime() {
        return webMessageSendTime;
    }

    public void setWebMessageSendTime(Date webMessageSendTime) {
        this.webMessageSendTime = webMessageSendTime;
    }

    public String getWebMessageUserKind() {
        return webMessageUserKind;
    }

    public void setWebMessageUserKind(String webMessageUserKind) {
        this.webMessageUserKind = webMessageUserKind;
    }

    public Integer getWebMessageState() {
        return webMessageState;
    }

    public void setWebMessageState(Integer webMessageState) {
        this.webMessageState = webMessageState;
    }

    public Integer getWebMessageCreateBy() {
        return webMessageCreateBy;
    }

    public void setWebMessageCreateBy(Integer webMessageCreateBy) {
        this.webMessageCreateBy = webMessageCreateBy;
    }

    public Integer getWebMessageUpdateBy() {
        return webMessageUpdateBy;
    }

    public void setWebMessageUpdateBy(Integer webMessageUpdateBy) {
        this.webMessageUpdateBy = webMessageUpdateBy;
    }

    public Date getWebMessageUpdateTime() {
        return webMessageUpdateTime;
    }

    public void setWebMessageUpdateTime(Date webMessageUpdateTime) {
        this.webMessageUpdateTime = webMessageUpdateTime;
    }

    public Date getWebMessageCreateTime() {
        return webMessageCreateTime;
    }

    public void setWebMessageCreateTime(Date webMessageCreateTime) {
        this.webMessageCreateTime = webMessageCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.webMessageId;
    }

    @Override
    public String toString() {
        return "WebMessage{" +
        "webMessageId=" + webMessageId +
        ", webMessageUserId=" + webMessageUserId +
        ", webMessageContext=" + webMessageContext +
        ", webMessageSendTime=" + webMessageSendTime +
        ", webMessageUserKind=" + webMessageUserKind +
        ", webMessageState=" + webMessageState +
        ", webMessageCreateBy=" + webMessageCreateBy +
        ", webMessageUpdateBy=" + webMessageUpdateBy +
        ", webMessageUpdateTime=" + webMessageUpdateTime +
        ", webMessageCreateTime=" + webMessageCreateTime +
        "}";
    }
}
