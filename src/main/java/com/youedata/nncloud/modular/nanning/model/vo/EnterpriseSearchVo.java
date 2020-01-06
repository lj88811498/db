package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Objects;

public class EnterpriseSearchVo {
    /**
     * id
     */
    private Integer enterpriseId;
    /**
     * 企业名称
     */
    private String enterpriseName;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnterpriseSearchVo)) return false;
        EnterpriseSearchVo that = (EnterpriseSearchVo) o;
        return Objects.equals(enterpriseId, that.enterpriseId) &&
                Objects.equals(enterpriseName, that.enterpriseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterpriseId, enterpriseName);
    }

    @Override
    public String toString() {
        return "EnterpriseSearchVo{" +
                "enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                '}';
    }
}
