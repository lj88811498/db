package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     *  查询部门和角色
     * @param userRoleUserId
     * @return
     */
    List<Object> selectRoleDept(@Param("userRoleUserId") int userRoleUserId);

    /**
     * 查询用户的角色
     * @param  userInfoName
     * @return
     */
    Integer selectUserRole(@Param("userInfoName") String userInfoName);
}
