package com.youedata.nncloud.modular.nanning.model.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.Objects;

public class WebMessageListVo {
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
     * 账号
     */
    private String userInfoName;
    /**
     * 状态(0：草稿，1：发布)
     */
    private Integer webMessageState;
    /**
     * 修改时间
     */
    private Date webMessageUpdateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getUserInfoName() {
        return userInfoName;
    }

    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName;
    }

    public Integer getWebMessageState() {
        return webMessageState;
    }

    public void setWebMessageState(Integer webMessageState) {
        this.webMessageState = webMessageState;
    }

    public Date getWebMessageUpdateTime() {
        return webMessageUpdateTime;
    }

    public void setWebMessageUpdateTime(Date webMessageUpdateTime) {
        this.webMessageUpdateTime = webMessageUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebMessageListVo)) return false;
        WebMessageListVo that = (WebMessageListVo) o;
        return Objects.equals(webMessageId, that.webMessageId) &&
                Objects.equals(webMessageUserId, that.webMessageUserId) &&
                Objects.equals(webMessageContext, that.webMessageContext) &&
                Objects.equals(webMessageSendTime, that.webMessageSendTime) &&
                Objects.equals(userInfoName, that.userInfoName) &&
                Objects.equals(webMessageState, that.webMessageState) &&
                Objects.equals(webMessageUpdateTime, that.webMessageUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webMessageId, webMessageUserId, webMessageContext, webMessageSendTime, userInfoName, webMessageState, webMessageUpdateTime);
    }

    @Override
    public String toString() {
        return "WebMessageListVo{" +
                "webMessageId=" + webMessageId +
                ", webMessageUserId=" + webMessageUserId +
                ", webMessageContext='" + webMessageContext + '\'' +
                ", webMessageSendTime=" + webMessageSendTime +
                ", userInfoName='" + userInfoName + '\'' +
                ", webMessageState=" + webMessageState +
                ", webMessageUpdateTime=" + webMessageUpdateTime +
                '}';
    }
}
