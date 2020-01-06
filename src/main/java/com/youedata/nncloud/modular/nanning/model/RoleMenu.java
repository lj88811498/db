package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单管理表
 * </p>
 *
 * @author Monkey
 * @since 2018-11-26
 */
@ApiModel
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "role_menu_id", type = IdType.AUTO)
    private Integer roleMenuId;
    /**
     * 角色id
     */
    private Integer roleMenuRoleId;
    /**
     * 菜单id
     */
    private Integer roleMenuMenuId;


    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Integer getRoleMenuRoleId() {
        return roleMenuRoleId;
    }

    public void setRoleMenuRoleId(Integer roleMenuRoleId) {
        this.roleMenuRoleId = roleMenuRoleId;
    }

    public Integer getRoleMenuMenuId() {
        return roleMenuMenuId;
    }

    public void setRoleMenuMenuId(Integer roleMenuMenuId) {
        this.roleMenuMenuId = roleMenuMenuId;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleMenuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        "roleMenuId=" + roleMenuId +
        ", roleMenuRoleId=" + roleMenuRoleId +
        ", roleMenuMenuId=" + roleMenuMenuId +
        "}";
    }
}
