package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.RoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询角色列表
     * @return
     */
    List<Map<String,Object>> selectRole();

    /**
     * 根据userid获取rolename
     * @param userInfoId
     * @return
     */
    Map<String,Object> getRoleName(@Param("userInfoId") Integer userInfoId);

    /**
     * 获取角色列表
     * @param roleName
     * @param roleStatus
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<RoleVo> getList(@Param("roleName") String roleName,
                         @Param("roleStatus") String roleStatus,
                         @Param("page") Page page,
                         @Param("orderByField") String orderByField,
                         @Param("isAsc") boolean isAsc);

    /**
     * 根据id获取角色
     * @param roleId
     * @return
     */
    Role getById(@Param("roleId") Integer roleId);

    /**
     * 添加返回id
     * @param role
     * @return
     */
    Integer insertGetId(Role role);

}
