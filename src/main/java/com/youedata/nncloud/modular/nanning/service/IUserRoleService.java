package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Role;
import com.youedata.nncloud.modular.nanning.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户角色Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IUserRoleService extends IService<UserRole>{

    /**
     * 查询角色列表
     * @return
     */
    List<Map<String,Object>> selectRole();

    /**
     * 添加返回id
     * @return
     */
    Integer insertGetId(Role role);

    /**
     * 查询用户的角色
     * @param userInfoName
     * @return
     */
    Integer selectUserRole(String userInfoName);
}
