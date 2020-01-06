package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    /**
     * 主键id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /**
     * 状态:0成功 1失败
     */
    private String logStatus;

    /**
     * 日志
     */
    private String logMsg;

    private String logSql1;

    private String logSql2;

    private String logSql3;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    public String getLogSql1() {
        return logSql1;
    }

    public void setLogSql1(String logSql1) {
        this.logSql1 = logSql1;
    }

    public String getLogSql2() {
        return logSql2;
    }

    public void setLogSql2(String logSql2) {
        this.logSql2 = logSql2;
    }

    public String getLogSql3() {
        return logSql3;
    }

    public void setLogSql3(String logSql3) {
        this.logSql3 = logSql3;
    }

    public Log(String logStatus, String logMsg, String logSql1, String logSql2, String logSql3) {
        this.logStatus = logStatus;
        this.logMsg = logMsg;
        this.logSql1 = logSql1;
        this.logSql2 = logSql2;
        this.logSql3 = logSql3;
    }

    public Log() {

    }
}
