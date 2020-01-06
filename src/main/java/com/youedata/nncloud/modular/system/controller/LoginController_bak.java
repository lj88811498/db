//package com.youedata.nncloud.modular.system.controller;
//
//import com.youedata.nncloud.core.base.controller.BaseController;
//import com.youedata.nncloud.core.log.LogManager;
//import com.youedata.nncloud.core.log.factory.LogTaskFactory;
//import com.youedata.nncloud.core.node.MenuNode;
//import com.youedata.nncloud.core.shiro.ShiroKit;
//import com.youedata.nncloud.core.shiro.ShiroUser;
//import com.youedata.nncloud.core.shiro.factory.IShiro;
//import com.youedata.nncloud.core.shiro.factory.ShiroFactroy;
//import com.youedata.nncloud.core.support.HttpKit;
//import com.youedata.nncloud.core.util.ApiMenuFilter;
//import com.youedata.nncloud.modular.nanning.service.IUserInfoService;
//import com.youedata.nncloud.modular.nanning.shiro.ShiroSettings;
//import com.youedata.nncloud.modular.system.model.User;
//import com.youedata.nncloud.modular.system.service.IMenuService;
//import com.youedata.nncloud.modular.system.service.IUserService;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//import static com.youedata.nncloud.core.support.HttpKit.getIp;
//
///**
// * 登录控制器
// *
// * @author fengshuonan
// * @Date 2017年1月10日 下午8:25:24
// */
//@Controller
//public class LoginController extends BaseController {
//
//    @Autowired
//    private IMenuService menuService;
//
//    @Autowired
//    private IUserService userService;
//
//    @Autowired
//    private IUserInfoService userInfoService;
//
////    @Autowired
////    private ShiroSettings shiroSettings;
//
//    /**
//     * 跳转到主页
//     */
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index(Model model) {
//        try {
//            //autoLogin();
//            //获取菜单列表
////            List<Integer> roleList = ShiroKit.getUser().getRoleList();
////            HttpSession session = HttpKit.getRequest().getSession();
////            List<Integer> roleList = (List<Integer>)session.getAttribute("roleList");
////            if (roleList == null || roleList.size() == 0) {
////                ShiroKit.getSubject().logout();
////                model.addAttribute("tips", "该用户没有角色，无法登陆");
////                //model.addAttribute("local", shiroSettings.getServerUrlPrefix() + shiroSettings.getCasFilterUrlPattern());
////                return "/login.html";
////            }
////            List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
//            List<MenuNode> menus = menuService.selectAll();
//            List<MenuNode> titles = MenuNode.buildTitle(menus);
//            titles = ApiMenuFilter.build(titles);
//
//            model.addAttribute("titles", titles);
//
//            //获取用户头像
////            Integer id = ShiroKit.getUser().getId();
////            UserInfo user = userInfoService.selectById(id);
////            String avatar = user.getAvatar();
////            model.addAttribute("avatar", avatar);
//            return "/index.html";
//        } catch (Exception e) {
//            return "/login.html";
//        }
//
//    }
//
//    /**
//     * 跳转到登录页面
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        //autoLogin();
//        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
//            return REDIRECT + "/";
//        } else {
//            return "/login.html";
//        }
//    }
//    /**
//     * 自动登陆
//     * @Author: Monkey
//     * @Param: []
//     * @Date: Created in  2018/3/27 10:19.
//     * @Returns void
//     */
//
//    private void autoLogin () {
//        String username = "admin";
//        String password = "111111";
//        String remember = "on";
//        Subject currentUser = ShiroKit.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
//
//        if ("on".equals(remember)) {
//            token.setRememberMe(true);
//        } else {
//            token.setRememberMe(false);
//        }
//
//        currentUser.login(token);
//
//        ShiroUser shiroUser = ShiroKit.getUser();
//        super.getSession().setAttribute("shiroUser", shiroUser);
//        super.getSession().setAttribute("username", shiroUser.getAccount());
//
//        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));
//
//        ShiroKit.getSession().setAttribute("sessionFlag", true);
//
//    }
//
//
//
//    /**
//     * 点击登录执行的动作
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginVali(Model model) {
//
//        String username = super.getPara("username").trim();
//        String password = super.getPara("password").trim();
//        String remember = super.getPara("remember");
//
//        //验证验证码是否正确
////        if (KaptchaUtil.getKaptchaOnOff()) {
////            String kaptcha = super.getPara("kaptcha").trim();
////            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
////            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
////                throw new InvalidKaptchaException();
////            }
////        }
//
////        Subject currentUser = ShiroKit.getSubject();
////        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
////
////        if ("on".equals(remember)) {
////            token.setRememberMe(true);
////        } else {
////            token.setRememberMe(false);
////        }
//        User user = null;
//        try {
//            user = userService.getByAccount(username);
//            String salt = user.getSalt();
//            String pwd = user.getPassword();
//            if (!pwd.equals(ShiroKit.md5(password, salt))) {
//                user = null;
//                return REDIRECT + "/login.html";
//            }
////            currentUser.login(token);
//        } catch (Exception e) {
//            return REDIRECT + "/login.html";
//        }
//        IShiro shiroFactory = ShiroFactroy.me();
//        ShiroUser shiroUser = shiroFactory.shiroUser(user);
//
////        ShiroUser shiroUser = ShiroKit.getUser();
//        super.getSession().setAttribute("shiroUser", shiroUser);
//        super.getSession().setAttribute("username", shiroUser.getAccount());
//
//        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));
//
//        ShiroKit.getSession().setAttribute("sessionFlag", true);
//
//        List<MenuNode> menus = menuService.selectAll();
//        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        titles = ApiMenuFilter.build(titles);
//
//        model.addAttribute("titles", titles);
//        return "/index.html";
//    }
//
//    /**
//     * 退出登录
//     */
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logOut() {
////        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
//        ShiroKit.getSubject().logout();
//        return REDIRECT + "/login";
//    }
//
//    @RequestMapping(value = "/api", method = RequestMethod.GET)
//    public String api(Model model) {
//            return "/api.html";
//
//    }
//
//}
