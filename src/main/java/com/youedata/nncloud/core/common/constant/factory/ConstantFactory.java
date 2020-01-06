package com.youedata.nncloud.core.common.constant.factory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.youedata.nncloud.core.common.constant.cache.Cache;
import com.youedata.nncloud.core.common.constant.cache.CacheKey;
import com.youedata.nncloud.core.common.constant.state.ManagerStatus;
import com.youedata.nncloud.core.common.constant.state.MenuStatus;
import com.youedata.nncloud.core.log.LogObjectHolder;
import com.youedata.nncloud.core.support.StrKit;
import com.youedata.nncloud.core.util.Convert;
import com.youedata.nncloud.core.util.GlobalHashMap;
import com.youedata.nncloud.core.util.SpringContextHolder;
import com.youedata.nncloud.core.util.ToolUtil;
import com.youedata.nncloud.modular.nanning.dao.*;
import com.youedata.nncloud.modular.nanning.model.*;
import com.youedata.nncloud.modular.system.dao.*;
import com.youedata.nncloud.modular.system.model.*;
import com.youedata.nncloud.modular.system.model.Dept;
import com.youedata.nncloud.modular.system.model.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量的生产工厂
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    private SysRoleMapper roleMapper = SpringContextHolder.getBean(SysRoleMapper.class);
    private SysDeptMapper deptMapper = SpringContextHolder.getBean(SysDeptMapper.class);
    private DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);
    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private MenuMapper menuMapper = SpringContextHolder.getBean(MenuMapper.class);
    private NoticeMapper noticeMapper = SpringContextHolder.getBean(NoticeMapper.class);
    private UserInfoMapper userInfoMapper = SpringContextHolder.getBean(UserInfoMapper.class);
    private QuestionMapper questionMapper = SpringContextHolder.getBean(QuestionMapper.class);
    private RoleMapper roleNanningMapper = SpringContextHolder.getBean(RoleMapper.class);
    private QuestionCommonMapper questionCommonMapper = SpringContextHolder.getBean(QuestionCommonMapper.class);
    private GovernmentOnlineMapper governmentOnlineMapper = SpringContextHolder.getBean(GovernmentOnlineMapper.class);
    private TitleEvaluationMapper titleEvaluationMapper = SpringContextHolder.getBean(TitleEvaluationMapper.class);
    private ReportConfigurationMapper reportConfigurationMapper = SpringContextHolder.getBean(ReportConfigurationMapper.class);
    private WebMenuMapper webMenuMapper = SpringContextHolder.getBean(WebMenuMapper.class);
    private WebMessageMapper webMessageMapper = SpringContextHolder.getBean(WebMessageMapper.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    @Override
    public String getUserNameById(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    @Override
    public String getUserAccountById(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色ids获取角色名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.ROLES_NAME + "'+#roleIds")
    public String getRoleName(String roleIds) {
        Integer[] roles = Convert.toIntArray(roleIds);
        StringBuilder sb = new StringBuilder();
        for (int role : roles) {
            Role roleObj = roleMapper.selectById(role);
            if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
                sb.append(roleObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 通过角色id获取角色名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_NAME + "'+#roleId")
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    /**
     * 通过角色id获取角色英文名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_TIP + "'+#roleId")
    public String getSingleRoleTip(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getTips();
        }
        return "";
    }

    /**
     * 获取部门名称
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.DEPT_NAME + "'+#deptId")
    public String getDeptName(Integer deptId) {
        Dept dept = deptMapper.selectById(deptId);
        if (ToolUtil.isNotEmpty(dept) && ToolUtil.isNotEmpty(dept.getFullname())) {
            return dept.getFullname();
        }
        return "";
    }

    /**
     * 获取菜单的名称们(多个)
     */
    @Override
    public String getMenuNames(String menuIds) {
        Integer[] menus = Convert.toIntArray(menuIds);
        StringBuilder sb = new StringBuilder();
        for (int menu : menus) {
            Menu menuObj = menuMapper.selectById(menu);
            if (ToolUtil.isNotEmpty(menuObj) && ToolUtil.isNotEmpty(menuObj.getName())) {
                sb.append(menuObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 获取菜单名称
     */
    @Override
    public String getMenuName(Long menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            return "";
        } else {
            Menu menu = menuMapper.selectById(menuId);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取菜单名称通过编号
     */
    @Override
    public String getMenuNameByCode(String code) {
        if (ToolUtil.isEmpty(code)) {
            return "";
        } else {
            Menu param = new Menu();
            param.setCode(code);
            Menu menu = menuMapper.selectOne(param);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取字典名称
     */
    @Override
    public String getDictName(Integer dictId) {
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Dict dict = dictMapper.selectById(dictId);
            if (dict == null) {
                return "";
            } else {
                return dict.getName();
            }
        }
    }

    /**
     * 获取通知标题
     */
    @Override
    public String getNoticeTitle(Integer dictId) {
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Notice notice = noticeMapper.selectById(dictId);
            if (notice == null) {
                return "";
            } else {
                return notice.getTitle();
            }
        }
    }

    /**
     * 根据字典名称和字典中的值获取对应的名称
     */
    @Override
    public String getDictsByName(String name, Integer val) {
        Dict temp = new Dict();
        temp.setName(name);
        Dict dict = dictMapper.selectOne(temp);
        if (dict == null) {
            return "";
        } else {
            Wrapper<Dict> wrapper = new EntityWrapper<>();
            wrapper = wrapper.eq("pid", dict.getId());
            List<Dict> dicts = dictMapper.selectList(wrapper);
            for (Dict item : dicts) {
                if (item.getNum() != null && item.getNum().equals(val)) {
                    return item.getName();
                }
            }
            return "";
        }
    }

    /**
     * 获取性别名称
     */
    @Override
    public String getSexName(Integer sex) {
        return getDictsByName("性别", sex);
    }

    /**
     * 获取用户登录状态
     */
    @Override
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }

    /**
     * 获取菜单状态
     */
    @Override
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }

    /**
     * 查询字典
     */
    @Override
    public List<Dict> findInDict(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            return null;
        } else {
            EntityWrapper<Dict> wrapper = new EntityWrapper<>();
            List<Dict> dicts = dictMapper.selectList(wrapper.eq("pid", id));
            if (dicts == null || dicts.size() == 0) {
                return null;
            } else {
                return dicts;
            }
        }
    }

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    @Override
    public String getCacheObject(String para) {
        return LogObjectHolder.me().get().toString();
    }

    /**
     * 获取子部门id
     */
    @Override
    public List<Integer> getSubDeptId(Integer deptid) {
        Wrapper<Dept> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + deptid + "]%");
        List<Dept> depts = this.deptMapper.selectList(wrapper);

        ArrayList<Integer> deptids = new ArrayList<>();

        if(depts != null && depts.size() > 0){
            for (Dept dept : depts) {
                deptids.add(dept.getId());
            }
        }

        return deptids;
    }

    /**
     * 获取所有父部门id
     */
    @Override
    public List<Integer> getParentDeptIds(Integer deptid) {
        Dept dept = deptMapper.selectById(deptid);
        String pids = dept.getPids();
        String[] split = pids.split(",");
        ArrayList<Integer> parentDeptIds = new ArrayList<>();
        for (String s : split) {
            parentDeptIds.add(Integer.valueOf(StrKit.removeSuffix(StrKit.removePrefix(s, "["), "]")));
        }
        return parentDeptIds;
    }

    @Override
    public String getUserInfoNameById(Integer userInfoId) {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        return "重置密码" + "用户名 = " +userInfo.getUserInfoName();
    }

    @Override
    public String getUserInfoNameByName(String userInfoName) {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserInfoName(userInfoName);
//        UserInfo userInfo1 = userInfoMapper.selectOne(userInfo);
//        List list = userInfoMapper.selectOneBefId(userInfo1.getUserInfoId(), userInfo1.getUserInfoName());
//        if(list.size()==0 ){
            return "注册新用户" + "用户名 = " +userInfoName;
//        }else {
//            return "注册失败:" + "用户名：" + userInfoName +"已存在";
//        }
    }

    @Override
    public String getUserInfoCode(String userInfoCode,String userInfoIndex) {
        String code = GlobalHashMap.getMapCode(userInfoIndex);
        if(!userInfoCode.equals(code)){
            return "验证码不正确";
        }else {
            return "";
        }

    }

    @Override
    public String getUserInfoNamePwd(String userInfoNamePwd,String userInfoNamePwdNew) {
        String pwdNew = this.getUserInfoNamePwdNew(userInfoNamePwdNew);
        if(!userInfoNamePwd.equals(pwdNew)){
               return "两次密码不一致";
        }else {
            return "";
        }

    }

    @Override
    public String getUserInfoNamePwdNew(String userInfoNamePwdNew) {
        return userInfoNamePwdNew;
    }

    @Override
    public String getGovUser(String userInfoId) {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);

        return "修改用户信息" + "用户名：" +userInfo.getUserInfoName();
    }

    @Override
    public String changePwd(String userInfoId) {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        return "修改用户密码" + "用户名：" +userInfo.getUserInfoName();
    }

    @Override
    public String getUserStatus(String userInfoId) {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        return "修改用户状态" + "用户名：" +userInfo.getUserInfoName();
    }

    /**
     * 获取常见问题标题
     * @param questionCommonTitle
     * @return
     */
    @Override
    public String getQuestionTitle(String questionCommonTitle) {

        return "新增常见问题" + "标题：" +questionCommonTitle;
    }

    /**
     * 根据id获取标题
     * @param questionCommonId
     * @return
     */
    @Override
    public String getQuestionTitleById(Integer questionCommonId) {
        QuestionCommon questionCommon = questionCommonMapper.selectById(questionCommonId);
        return "删除一条常见问题" + " " + "标题 ：" +questionCommon.getQuestionCommonTitle();
    }

    @Override
    public String getQuestionNameById(Integer questionId) {
        Question question = questionMapper.selectOneById(questionId);
        return "修改问题反馈" + "  "+"标题 :" +" "+ question.getQuestionTitle();
    }

    @Override
    public String getGovNameById(Integer governmentOnlineId) {
        GovernmentOnline governmentOnline = governmentOnlineMapper.selectById(governmentOnlineId);
        return "删除了一条政府在线" + " " + "内容 ：" +governmentOnline.getGovernmentOnlineName();
    }

    @Override
    public String getGovName(String governmentOnlineName) {
        return "新增一条政府在线 "+ " " + "标题 ：" + governmentOnlineName;
    }

    @Override
    public String getTitleEvaTitle(String titleEvaluationTitle) {
        return "新增一条职称评审 " + " " + "标题 ：" + titleEvaluationTitle;
    }

    @Override
    public String getTitleEvaTitleById(Integer titleEvaluationId) {
        TitleEvaluation titleEvaluation = titleEvaluationMapper.selectById(titleEvaluationId);
        return "删除一条职称评审" + " " + "内容 ：" +titleEvaluation.getTitleEvaluationContent();
    }

    @Override
    public String getRoleNameNanning(String roleName) {
        return "新增角色 " + " " + "角色名称 ：" + roleName;
    }

    @Override
    public String getRoleNameNanningById(Integer roleId) {
        com.youedata.nncloud.modular.nanning.model.Role role = roleNanningMapper.selectById(roleId);
        return "删除角色" + " " + "角色名称 ：" +role.getRoleName();
    }

    @Override
    public String getReportNameById(Integer reportConfigurationId) {
        ReportConfiguration reportConfiguration = reportConfigurationMapper.selectById(reportConfigurationId);
        return "删除一条填报配置" + " " + "名称 ：" +reportConfiguration.getReportConfigurationName();
    }

    @Override
    public String getReportName(String name) {
        return "新增填报配置" + " " + "报表名称 ：" + name;
    }

    @Override
    public String getMenuName(String menuName) {
        return "新增菜单" + " " + "菜单名称 ：" + menuName;
    }

    @Override
    public String getMenuNameById(Integer menuId) {
        WebMenu webMenu = webMenuMapper.selectById(menuId);
        return "删除一个菜单" + " " + "名称 ：" +webMenu.getWebMenuName();
    }

    @Override
    public String getWebMessageName(String webMessageContext) {
        return "新增系统消息" + " " + "消息内容 ：" + webMessageContext;
    }

    @Override
    public String getWebMessageNameById(Integer webMessageId) {
        WebMessage webMessage = webMessageMapper.selectById(webMessageId);
        return "删除一条系统消息" + " " + "内容 ：" +webMessage.getWebMessageContext();
    }
}
