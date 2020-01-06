package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class Flag extends Model<Flag> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Serializable pkVal() {
        return this.flagId;
    }

    /**
     * 主键id
     */
    @TableId(value = "flag_id", type = IdType.AUTO)
    private Integer flagId;

    /**
     * 附件名称
     */
    private String flagPwd;


    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagPwd(String flagPwd) {
        this.flagPwd = flagPwd;
    }

    public String getFlagPwd() {
        return flagPwd;
    }
}
