package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.modular.nanning.dao.RoleMapper;
import com.youedata.nncloud.modular.nanning.dao.UserRoleMapper;
import com.youedata.nncloud.modular.nanning.model.Role;
import com.youedata.nncloud.modular.nanning.model.UserRole;
import com.youedata.nncloud.modular.nanning.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 用户角色Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class UserRoleServiceImpl extends ServiceImpl<BaseMapper<UserRole>,UserRole> implements IUserRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 查询角色列表
     * @return
     */
    @Override
    public List<Map<String, Object>> selectRole() {
        return roleMapper.selectRole();
    }

    /**
     * 添加返回id
     * @param role
     * @return
     */
    @Override
    public Integer insertGetId(Role role) {
        return roleMapper.insertGetId(role);
    }

    /**
     * 查询用户的角色
     *
     * @param userInfoName
     * @return
     */
    @Override
    public Integer selectUserRole(String userInfoName) {
        return userRoleMapper.selectUserRole(userInfoName);
    }

}
