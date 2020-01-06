package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.RoleMenu;
/**
 * 角色菜单管理表Service
 *
 * @author lee
 * @Date 2018-11-26 14:18:45
 */
public interface IRoleMenuService extends IService<RoleMenu>{
    /**
     * 添加权限
     * @param roleId
     * @param ids
     */
    void addAuthority(Integer roleId, String ids);

    /**
     * 更新权限
     * @param roleId
     */
    void updateAuthority(Integer roleId, String ids);

    /**
     * 删除用户权限
     * @param roleId
     */
    void deleteAuthority(Integer roleId);

    /**
     * 删除菜单时同时删除权限
     * @param roleId
     */
    void deleteAuthorityByMenuId(Integer roleId);
}
