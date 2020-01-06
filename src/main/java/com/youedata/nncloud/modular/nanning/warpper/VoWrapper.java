//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.youedata.nncloud.modular.nanning.warpper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;

public class VoWrapper<T> extends Wrapper<T> {
    protected T entity = null;

    public VoWrapper() {
    }

    public VoWrapper(T entity) {
        this.entity = entity;
    }

    public VoWrapper(T entity, String sqlSelect) {
        this.entity = entity;
        this.sqlSelect = sqlSelect;
    }

    public T getEntity() {
        return this.entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getSqlSegment() {
        String sqlWhere = this.sql.toString();
        if (StringUtils.isEmpty(sqlWhere)) {
            return null;
        } else {
            return this.isWhere != null ? (this.isWhere.booleanValue() ? sqlWhere : sqlWhere.replaceFirst("WHERE", this.AND_OR)) : sqlWhere.replaceFirst("WHERE", this.AND_OR);
        }
    }
}
