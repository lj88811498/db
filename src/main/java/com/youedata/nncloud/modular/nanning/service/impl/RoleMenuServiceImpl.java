package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.util.Convert;
import com.youedata.nncloud.modular.nanning.dao.RoleMenuMapper;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.RoleMenu;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IRoleMenuService;

import javax.annotation.Resource;


/**
 * 角色菜单管理表Service
 *
 * @author lee
 * @Date 2018-11-26 14:18:45
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<BaseMapper<RoleMenu>,RoleMenu> implements IRoleMenuService {
    @Resource
    RoleMenuMapper roleMenuMapper;
    /**
     * 添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void addAuthority(Integer roleId, String ids) {
        // 添加新的权限
        for (int id : Convert.toIntArray(true, Convert.toStrArray(",", ids))) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleMenuRoleId(roleId);
            roleMenu.setRoleMenuMenuId(id);
            this.roleMenuMapper.insert(roleMenu);
        }
    }

    /**
     * 更新权限
     * @param roleId
     */
    @Override
    public void updateAuthority(Integer roleId, String ids) {
        //删除用户权限
        this.roleMenuMapper.deleteByRoleId(roleId);
        // 添加新的权限
        for (int id : Convert.toIntArray(true, Convert.toStrArray(",", ids))) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleMenuRoleId(roleId);
            roleMenu.setRoleMenuMenuId(id);
            this.roleMenuMapper.insert(roleMenu);
        }
    }

    /**
     * //删除用户权限
     * @param roleId
     */
    @Override
    public void deleteAuthority(Integer roleId) {
        this.roleMenuMapper.deleteByRoleId(roleId);
    }
    /**
     * 删除菜单时同时删除权限
     * @param roleId
     */
    @Override
    public void deleteAuthorityByMenuId(Integer roleId) {
        this.roleMenuMapper.deleteAuthorityByMenuId(roleId);
    }
}
