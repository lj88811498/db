package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.RoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色菜单管理表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-26
 */
@Transactional
@Component
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    /**
     * 根据roleid删除用户权限
     * @param roleId
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);
    /**
     * 删除菜单时同时删除权限
     * @param menuId
     */
    void deleteAuthorityByMenuId(@Param("menuId") Integer menuId);
}
