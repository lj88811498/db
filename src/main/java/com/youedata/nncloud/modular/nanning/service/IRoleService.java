package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Role;
/**
 * 角色信息Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IRoleService extends IService<Role>{
    /**
     * 获取角色列表
     * @param roleName
     * @param roleStatus
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getList(String roleName, String roleStatus, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    Role getById(Integer roleId);

}
