package com.youedata.nncloud.core.common.constant.factory;

import com.youedata.nncloud.modular.system.model.Dict;

import java.util.List;

/**
 * 常量生产工厂的接口
 *
 * @author fengshuonan
 * @date 2017-06-14 21:12
 */
public interface IConstantFactory {

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    String getUserNameById(Integer userId);

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    String getUserAccountById(Integer userId);

    /**
     * 通过角色ids获取角色名称
     */
    String getRoleName(String roleIds);

    /**
     * 通过角色id获取角色名称
     */
    String getSingleRoleName(Integer roleId);

    /**
     * 通过角色id获取角色英文名称
     */
    String getSingleRoleTip(Integer roleId);

    /**
     * 获取部门名称
     */
    String getDeptName(Integer deptId);

    /**
     * 获取菜单的名称们(多个)
     */
    String getMenuNames(String menuIds);

    /**
     * 获取菜单名称
     */
    String getMenuName(Long menuId);

    /**
     * 获取菜单名称通过编号
     */
    String getMenuNameByCode(String code);

    /**
     * 获取字典名称
     */
    String getDictName(Integer dictId);

    /**
     * 获取通知标题
     */
    String getNoticeTitle(Integer dictId);

    /**
     * 根据字典名称和字典中的值获取对应的名称
     */
    String getDictsByName(String name, Integer val);

    /**
     * 获取性别名称
     */
    String getSexName(Integer sex);

    /**
     * 获取用户登录状态
     */
    String getStatusName(Integer status);

    /**
     * 获取菜单状态
     */
    String getMenuStatusName(Integer status);

    /**
     * 查询字典
     */
    List<Dict> findInDict(Integer id);

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    String getCacheObject(String para);

    /**
     * 获取子部门id
     */
    List<Integer> getSubDeptId(Integer deptid);

    /**
     * 获取所有父部门id
     */
    List<Integer> getParentDeptIds(Integer deptid);

    /**
     *
     * @param userInfoId
     * @return
     */
    String getUserInfoNameById(Integer userInfoId);

    /**
     *
     * @param userInfoName
     * @return
     */
    String getUserInfoNameByName(String userInfoName);

    /**
     *
     * @return
     */
    String getUserInfoCode(String userInfoCode , String userInfoIndex);

    /**
     *
     * @return
     */
    String getUserInfoNamePwd(String userInfoNamePwd, String userInfoNamePwdNew);

    /**
     *
     * @param userInfoNamePwdNew
     * @return
     */
    String getUserInfoNamePwdNew(String userInfoNamePwdNew);

    /**
     * 修改政府用户
     * @param userInfoTel
     * @return
     */
    String getGovUser(String userInfoTel);

    /**
     * 修改密码的日志
     * @param userInfoId
     * @return
     */
    String changePwd ( String userInfoId);

    /**
     * 修改用户状态（禁用/启用）的日志
     * @param userInfoId
     * @return
     */
    String getUserStatus (String userInfoId);

    /**
     * 获取常见问题名称
     * @param questionCommonTitle
     * @return
     */
    String getQuestionTitle(String questionCommonTitle);

    /**
     * 根据id获取标题
     * @param questionCommonId
     * @return
     */
    String getQuestionTitleById(Integer questionCommonId);

    /**
     * 获取反馈名称
     * @param questionId
     * @return
     */
    String getQuestionNameById(Integer questionId);

    /**
     * 根据id获取政府在线名称
     * @return
     */
    String getGovNameById(Integer governmentOnlineId);

    /**
     * 获取政府在线名称
     * @return
     */
    String getGovName(String governmentOnlineName);

    /**
     * 新增职称评审
     * @param titleEvaluationTitle
     * @return
     */
    String getTitleEvaTitle(String titleEvaluationTitle);

    /**
     * 删除职称评审
     * @return
     */
    String getTitleEvaTitleById(Integer titleEvaluationId);

    /**
     *
     * @param roleName
     * @return
     */
    String getRoleNameNanning(String roleName);

    /**
     * 根据id获取roleName
     * @param roleId
     * @return
     */
    String getRoleNameNanningById(Integer roleId);

    /**
     * 根据id获取填报配置名称
     * @param reportConfigurationId
     * @return
     */
    String getReportNameById(Integer reportConfigurationId);

    /**
     * 获取填报名称
     * @param name
     * @return
     */
    String getReportName(String name);

    /**
     * 获取菜单名称
     * @param menuName
     * @return
     */
    String getMenuName(String menuName);

    /**
     * 根据id获取菜单名称
     * @param menuId
     * @return
     */
    String getMenuNameById(Integer menuId);

    /**
     * 获取系统消息名称
     * @return
     */
    String getWebMessageName(String webMessageContext);

    /**
     * 根据id获取系统消息名称
     * @param webMessageId
     * @return
     */
    String getWebMessageNameById(Integer webMessageId);

}
