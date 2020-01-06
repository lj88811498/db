package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.RoleMapper;
import com.youedata.nncloud.modular.nanning.model.vo.RoleVo;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.Role;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IRoleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 角色信息Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class RoleServiceImpl extends ServiceImpl<BaseMapper<Role>,Role> implements IRoleService {
    @Resource
    RoleMapper roleMapper;

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
    @Override
    public Page getList(String roleName, String roleStatus, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<RoleVo> result = roleMapper.getList(roleName, roleStatus, page, orderByField, isAsc);
        page.setRecords(result);
        return page;
    }

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    @Override
    public Role getById(Integer roleId) {
        return roleMapper.getById(roleId);
    }
}
