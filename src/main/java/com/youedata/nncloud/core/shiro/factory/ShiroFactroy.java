package com.youedata.nncloud.core.shiro.factory;

import com.youedata.nncloud.core.common.constant.factory.ConstantFactory;
import com.youedata.nncloud.core.common.constant.state.ManagerStatus;
import com.youedata.nncloud.core.shiro.ShiroUser;
import com.youedata.nncloud.core.support.HttpKit;
import com.youedata.nncloud.core.util.Convert;
import com.youedata.nncloud.core.util.SpringContextHolder;
import com.youedata.nncloud.modular.nanning.dao.UserInfoMapper;
import com.youedata.nncloud.modular.nanning.dao.UserRoleMapper;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.youedata.nncloud.modular.system.dao.MenuMapper;
import com.youedata.nncloud.modular.system.dao.UserMapper;
import com.youedata.nncloud.modular.system.model.User;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public UserInfo user(String account) {

//        User user = userMapper.getByAccount(account);
        UserInfo user = userInfoMapper.selectOneByName(account);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
//        if (user.getStatus() != ManagerStatus.OK.getCode()) {
//            throw new LockedAccountException();
//        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptid());
        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));
        shiroUser.setName(user.getName());

        Integer[] roleArray = Convert.toIntArray(user.getRoleid());
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        HttpKit.getRequest().getSession().setAttribute("roleList", roleList);
        return shiroUser;
    }

    /**
     * 根据系统用户获取Shiro的用户
     *
     * @param user 系统用户
     */
    @Override
    public ShiroUser shiroUser(UserInfo user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getUserInfoId());
        shiroUser.setAccount(user.getUserInfoName());
//        shiroUser.setDeptId(user.getDeptid());
//        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));
        shiroUser.setName(user.getUserInfoNickname());
        String roleIds = "";
        List<Object> list = userRoleMapper.selectRoleDept(user.getUserInfoId());
        for (int i = 0; i < list.size(); i ++) {
            Map map = (Map)list.get(i);
            roleIds += map.get("userRoleRoleId") + ",";
        }

        Integer[] roleArray = Convert.toIntArray(roleIds);
        List<Integer> roleList = new ArrayList<Integer>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
        }
        shiroUser.setRoleList(roleList);
        HttpKit.getRequest().getSession().setAttribute("roleList", roleList);
        return shiroUser;
    }


    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return menuMapper.getResUrlsByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return ConstantFactory.me().getSingleRoleTip(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, UserInfo user, String realmName) {
        String credentials = user.getUserInfoNamePwd();

        // 密码加盐处理
        String source = user.getUserInfoSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
