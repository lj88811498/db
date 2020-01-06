package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Date;

public class RoleVo {
    private Integer roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 类型
     */
    private String roleType;
    /**
     * 状态
     */
    private String roleStatus;
    /**
     * 分配人数
     */
    private String roleAllotNum;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleAllotNum() {
        return roleAllotNum;
    }

    public void setRoleAllotNum(String roleAllotNum) {
        this.roleAllotNum = roleAllotNum;
    }
}
