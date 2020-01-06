package com.youedata.nncloud.modular.nanning.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.config.properties.GunsProperties;
import com.youedata.nncloud.core.common.Base64;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.constant.Constant;
import com.youedata.nncloud.core.shiro.ShiroKit;
import com.youedata.nncloud.core.support.BeanKit;
import com.youedata.nncloud.core.util.*;
import com.youedata.nncloud.modular.nanning.dao.RoleMapper;
import com.youedata.nncloud.modular.nanning.dao.UserInfoMapper;
import com.youedata.nncloud.modular.nanning.dao.UserRoleMapper;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.youedata.nncloud.modular.nanning.model.UserRole;
import com.youedata.nncloud.modular.nanning.model.vo.CodeVo;
import com.youedata.nncloud.modular.nanning.model.vo.DataosUser;
import com.youedata.nncloud.modular.nanning.service.IQuestionService;
import com.youedata.nncloud.modular.nanning.service.IUserInfoService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户信息Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class UserInfoServiceImpl extends ServiceImpl<BaseMapper<UserInfo>, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private IQuestionService iQuestionService;
    @Autowired
    private HttpClientUtil clientUtil;

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Value("${dataos.accountName}")
    private String accountName;

    @Value("${dataos.accountPasswd}")
    private String accountPasswd;

    @Value("${dataos.accountPasswd}")
    private  Integer dataOSRoleId;

    /**
     * @param userInfoType
     * @param userInfoName
     * @param userInfoNamePwd
     * @return com.youedata.nncloud.modular.nanning.model.UserInfo
     * @author: Monkey
     * @param: []
     * @date: Created in  2018/9/17 16:49.
     */
    @Override
    public UserInfo selectOne(String userInfoType, String userInfoName, String userInfoNamePwd) throws Exception {
        UserInfo userInfo = new UserInfo(userInfoType, userInfoName);
        UserInfo temp = userInfoMapper.selectOne(userInfo);
        if (temp != null) {
            String password = temp.getUserInfoNamePwd();
            String salt = temp.getUserInfoSalt();
            if (password.equals(ShiroKit.md5(userInfoNamePwd, salt))) {
                temp.setUserInfoUrl(gunsProperties.getFileServerPath() + temp.getUserInfoUrl());
                return temp;
            } else {
                throw new Exception("用户名或密码错误！");
            }
        } else {
            throw new Exception("用户名或密码错误！");
        }
    }


    /**
     * 修改密码
     *
     * @param userInfoId
     * @param userInfoNamePwd
     * @param userInfoNamePwdNew
     * @return
     * @throws Exception
     * @author lich
     */
    @Override
    public void changePsaaword(Integer userInfoId, String userInfoNamePwd, String userInfoNamePwdNew) throws Exception {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        if (userInfo == null) {
            throw new Exception("用户不存在");
        }
        String entry = userInfo.getUserInfoNamePwd();
        String pwd = new String(Base64.decode(entry), "utf-8");
        JSONObject js = this.accountUpdate(null, null, null, userInfoNamePwdNew, pwd);
        js.remove("result");
        if (js.get("code").equals("0")) {
            if (userInfo.getUserInfoNamePwd().equals(ShiroKit.md5(userInfoNamePwd, userInfo.getUserInfoSalt()))) {
                String entryNew = Base64.encode(userInfoNamePwdNew.getBytes());
                userInfo.setUserInfoNamePwd(ShiroKit.md5(userInfoNamePwdNew, userInfo.getUserInfoSalt()));
                userInfo.setUserInfoEntry(entryNew);
                userInfo.updateById();
            } else {
                throw new Exception("原密码输入错误");
            }
        }

    }


    /**
     * 账户列表信息查询
     *
     * @param userInfoName
     * @return
     */
    @Override
    public JSONObject accounts(String userInfoName, String fields) throws Exception {
        //登录获取token
        String token = null;
        if (clientUtil.getToken() == null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("accountName", GlobalHashMap.getUser().getAccountName());
            params.put("accountPasswd", Sha1Util.getSha1(GlobalHashMap.getUser().getAccountPasswd()));
            DataosUser user = clientUtil.Login(params);
            token = user.getAccessToken();
        } else {
            token = clientUtil.getToken();
        }

        Map<String, String> param = new HashMap();
        param.put("accountName", userInfoName);
        param.put("fields", fields);

        String str = clientUtil.accounts(param, token);
        JSONObject result = JSONObject.parseObject(str);
        result.put("code", "0");
        result.put("page", result.get("result"));
        result.remove("result");
        return result;
    }

    /**
     * 账户详细信息查询
     *
     * @return
     */
    @Override
    public JSONObject accountDetail() {
        String token = GlobalHashMap.getToken();
        String accountId = GlobalHashMap.getUserId();
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountId", accountId);
        String body = clientUtil.accountDetail(params, token);
        RecordLogUtil.info(body);

        GlobalHashMap.removeUser();
        JSONObject result = JSONObject.parseObject(body);
        result.put("code", "0");
        result.put("page", result.get("result"));
        result.remove("result");
        return result;
    }

    /**
     * 账户信息修改
     *
     * @param telephone
     * @param email
     * @param extendedProperties
     * @param accountPasswd
     * @param oldPasswd
     * @return
     */
    @Override
    public JSONObject accountUpdate(String telephone, String email, String extendedProperties, String accountPasswd, String oldPasswd) {
        String token = GlobalHashMap.getToken();
        String accountId = GlobalHashMap.getUserId();
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountId", accountId);
        params.put("telephone", telephone);
        params.put("email", email);
        params.put("extendedProperties", extendedProperties);
        if (accountPasswd != null && oldPasswd != null) {
            params.put("accountPasswd", Sha1Util.getSha1(accountPasswd));
            params.put("oldPasswd", Sha1Util.getSha1(oldPasswd));
        }

        String body = clientUtil.accountUpdate(params, token);
        RecordLogUtil.info(body);

        JSONObject result = JSONObject.parseObject(body);
        result.put("code", "0");
        result.put("page", result.get("result"));
        result.remove("result");
        return result;
    }

    /**
     * 删除用户
     *
     * @return
     */
    @Override
    public JSONObject accountDelete() {
        String token = GlobalHashMap.getToken();
        String accountId = GlobalHashMap.getUserId();
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountId", accountId);
        String body = clientUtil.accountDelete(params, token);
        RecordLogUtil.info(body);

        JSONObject result = JSONObject.parseObject(body);
        result.put("code", "0");
        result.put("page", result.get("result"));
        result.remove("result");
        return result;
    }

    /**
     * 用户退出
     *
     * @return
     */
    @Override
    public JSONObject logout() {
        String token = GlobalHashMap.getToken();
        String accountId = GlobalHashMap.getUserId();
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountId", accountId);
        String body = clientUtil.logout(params, token);
        RecordLogUtil.info(body);

        JSONObject result = JSONObject.parseObject(body);
        result.put("code", "0");
        result.put("page", result.get("result"));
        result.remove("result");
        return result;
    }

    /**
     * token验证
     *
     * @param accessToken
     * @return
     * @author lich
     */
    @Override
    public Object checkAccessToken(String accessToken) throws Exception {
        //登录获取token
        JSONObject object = JSONObject.parseObject(clientUtil.checkAccessToken(accessToken));
        if (object.get("code").toString().equals("0")) {
            System.out.println((object.get("result") + "").toString());
            JSONObject result = JSONObject.parseObject(object.get("result") + "");
            DataosUser user = JSON.parseObject(result.get("datas") + "", DataosUser.class);
            GlobalHashMap.setUser(user);
            UserInfo selectone = userInfoMapper.selectOneByName(user.getAccountName());
            if(selectone == null){
                UserInfo userInfo = new UserInfo();
                userInfo.setUserInfoName(user.getAccountName());
                userInfo.setUserInfoType("2");
                userInfo.setUserInfoStatus("1");
                userInfo.insert();

                UserRole userRole = new UserRole();
                userRole.setUserRoleRoleId(dataOSRoleId);
                userRole.setUserRoleUserId(userInfo.getUserInfoId());
                userRole.insert();
                return  null;
            }
            return selectone;
        } else {
            return object;
        }
    }

    /**
     * 注册
     *
     * @return
     * @author lich
     */
    @Override
    public JSONObject registerDataOs(String accountName, String telephone, String email, String extendedProperties, String accountPasswd, String parendId) throws Exception {
        //登录获取token
        String token = GlobalHashMap.getToken();

        Map<String, String> params2 = new HashMap<String, String>();
        params2.put("accountName", accountName);
        params2.put("telephone", telephone);
        params2.put("email", email);
        params2.put("extendedProperties", extendedProperties);
        params2.put("accountPasswd", Sha1Util.getSha1(accountPasswd));
        params2.put("parendId", parendId);
        return JSONObject.parseObject(clientUtil.register(params2, token));
    }

    /**
     * 登录
     *
     * @param accountName
     * @param accountPasswd
     * @param loginIP
     * @return
     */
    @Override
    public DataosUser login(String accountName, String accountPasswd, String loginIP, Integer expireTime) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("accountName", accountName);
        params.put("accountPasswd", Sha1Util.getSha1(accountPasswd));
        params.put("loginIP", loginIP);
        params.put("expireTime", expireTime);
        return clientUtil.Login(params);
    }

    /**
     * 上传头像
     *
     * @param file
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Object uploadImg(MultipartFile file, Integer userId) throws Exception {
        if (null != file) {
            String serverPath = gunsProperties.getFileUploadPath();
            String folderPath = Constant.FILE_SEPARATOR + DateUtil.getDays() + Constant.FILE_SEPARATOR;
            String fileName = file.getOriginalFilename();
            String fileServerPath = gunsProperties.getFileServerPath();
            UserInfo userInfo = new UserInfo();
            UploadUtil.uploadFile(file, serverPath + folderPath, fileName);
            userInfo.setUserInfoId(userId);
            userInfo.setUserInfoUrl(folderPath + fileName);
            userInfoMapper.updateById(userInfo);
            return fileServerPath + folderPath + fileName;
        }
        return null;
    }

    @Override
    public CodeVo getCodePath() {

        String random = RandomUtil.randomUUID();
        String path = gunsProperties.getHeadImagePath() + random;
        CodeVo code = new CodeVo(path, random);

        return code;
    }

    /**
     * 获取用户列表
     *
     * @param userName
     * @param createTime
     * @param certificationStatus
     * @param certificationType
     * @param userStatus
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getList(String userName, String createTime,String endTime, String certificationStatus, String certificationType, String userStatus, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<UserInfo> result = userInfoMapper.getList(userName, createTime,endTime, certificationStatus, certificationType, userStatus, page, orderByField, isAsc);
        page.setRecords(result);
        return page;
    }

    /**
     * 查询过用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo getById(Integer userId) {
        UserInfo userInfo = userInfoMapper.getById(userId);
        return userInfo;
    }

    /**
     * 修改昵称
     *
     * @param userInfoId
     * @param userInfoNickname
     * @return
     */
    @Override
    public JSONObject updateNickName(Integer userInfoId, String userInfoNickname) {
        JSONObject result;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserInfoNickname(userInfoNickname);
        UserInfo userInfo1 = userInfoMapper.selectOne(userInfo);
        if (ToolUtil.isEmpty(userInfo1)) {
            UserInfo userInfo2 = userInfoMapper.selectById(userInfoId);
            userInfo2.setUserInfoNickname(userInfoNickname);
            userInfoMapper.updateById(userInfo2);
        } else {
            result = JsonUtil.createFailJson("该昵称已存在");
            return result;
        }
        return JsonUtil.createOkJson();
    }

    /**
     * 查询政府用户
     *
     * @param userName
     * @param userInfoWorker
     * @param beginTime
     * @param userStatus
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    @Override
    public Page getGovList(String userName, String userInfoWorker, String beginTime, String endTime, String userStatus, String orderByField, boolean isAsc, int size, int curPage) {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<UserInfo> result = userInfoMapper.getGovList(userName, userInfoWorker, beginTime, endTime, userStatus, page, orderByField, isAsc);
        page.setRecords(result);
        return page;
    }

    /**
     * 新增政府用户
     *
     * @param userInfo
     * @param roleId
     */
    @Override
    public JSONObject addGovAccount(UserInfo userInfo, Integer roleId) throws Exception {
        JSONObject js = this.registerDataOs(userInfo.getUserInfoName(), userInfo.getUserInfoTel(), userInfo.getUserInfoEmail(), null, userInfo.getUserInfoNamePwd(), null);
        userInfo.setUserInfoType("2");
        //根据类型及用户名验重
        Map map = checkNameType(userInfo);
        if (js.get("code").equals(0)) {
            List<UserInfo> userInfos = userInfoMapper.selectByMap(map);
            if (userInfos.size() == 0) {
                String entry = userInfo.getUserInfoNamePwd();

                userInfo.setUserInfoSalt(ShiroKit.getRandomSalt(5));
                userInfo.setUserInfoNamePwd(ShiroKit.md5(userInfo.getUserInfoNamePwd(), userInfo.getUserInfoSalt()));
                userInfo.setUserInfoEntry(Base64.encode(entry.getBytes()));
                userInfo.setUserInfoNickname(userInfo.getUserInfoWorker());
                userInfo.setUserInfoStatus("1");
                userInfo.setUserInfoUrl("/head.png");
                userInfoMapper.insert(userInfo);

                UserRole userRole = new UserRole();
                userRole.setUserRoleRoleId(roleId);
                userRole.setUserRoleUserId(userInfo.getUserInfoId());

                userRoleMapper.insert(userRole);
            } else {
                js = JsonUtil.createFailJson("用户已存在");
                //js.put("msg", "用户名已存在");
            }
            return js;

        } else {
            js.put("code", 400);
            return js;
        }

    }

    /**
     * 根据iduserid获取用户信息及角色名称
     *
     * @param userInfoId
     * @return
     */
    @Override
    public Map<String, Object> getAccountDetailAndRoleName(Integer userInfoId) {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        Map<String, Object> map = BeanKit.beanToMap(userInfo);
        map.remove("userInfoNamePwd");
        map.remove("userInfoSalt");
        map.remove("userInfoUpdateTime");
        map.remove("userInfoCreateTime");
        Map<String, Object> roleName = roleMapper.getRoleName(userInfoId);
        map.putAll(roleName);
        return map;
    }

    /**
     * 注册前台用户
     *
     * @param userInfo
     */
    @Override
    public String register(UserInfo userInfo) {
        Map map = checkNameType(userInfo);
        List<Map<String, Object>> list = userInfoMapper.selectByMap(map);

        if (list.size() == 0) {

            userInfo.setUserInfoNickname(userInfo.getUserInfoName());
            userInfo.setUserInfoSalt(ShiroKit.getRandomSalt(5));
            userInfo.setUserInfoNamePwd(ShiroKit.md5(userInfo.getUserInfoNamePwd(), userInfo.getUserInfoSalt()));
            userInfo.setUserInfoStatus("1");
            userInfo.setUserInfoCertificationStatus("3");
            userInfo.setUserInfoUrl("/head.png");
            String entry = userInfo.getUserInfoNamePwd();
            userInfo.setUserInfoEntry(Base64.encode(entry.getBytes()));
            if (userInfo.getUserInfoType().equals("0")) {

                userInfo.setUserInfoCertificationType("0");
            } else {
                userInfo.setUserInfoCertificationType("1");
            }
            userInfoMapper.insert(userInfo);
        } else {
            return "用户名已存在,400";
        }
        return "注册成功,0";
    }

    /**
     * 编辑政府用户
     *
     * @param userInfo
     * @param userInfoRoleId
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject updateGovUser(UserInfo userInfo, Integer userInfoRoleId) throws Exception {
        JSONObject js = this.accountUpdate(userInfo.getUserInfoTel(), userInfo.getUserInfoEmail(), null, null, userInfo.getUserInfoNamePwd());
        if (js.get("code").equals("0")) {
            userInfoMapper.updateById(userInfo);
            UserRole userRole = new UserRole();
            userRole.setUserRoleUserId(userInfo.getUserInfoId());
            UserRole userRole1 = userRoleMapper.selectOne(userRole);
            userRole1.setUserRoleRoleId(userInfoRoleId);
            userRoleMapper.updateById(userRole1);
        } else {

            return js;
        }

        return js;
    }

    /**
     * 重置政府用户密码
     *
     * @param userInfoId
     * @return
     */
    @Override
    public JSONObject reSetPwd(Integer userInfoId) throws Exception {
        UserInfo userInfo = userInfoMapper.selectById(userInfoId);
        String entry = userInfo.getUserInfoEntry();
        String pwd = new String(Base64.decode(entry), "utf-8");

        JSONObject js = this.accountUpdate(null, null, null, "123456", pwd);
        js.remove("result");

        if (js.get("code").equals("0")) {

            userInfo.setUserInfoNamePwd("123456");
            userInfo.setUserInfoSalt(ShiroKit.getRandomSalt(5));
            userInfo.setUserInfoNamePwd(ShiroKit.md5(userInfo.getUserInfoNamePwd(), userInfo.getUserInfoSalt()));

            userInfoMapper.updateById(userInfo);
        } else {

            return js;
        }

        return js;
    }

    /**
     * 根据类别及姓名进行查重
     *
     * @return
     */
    private Map checkNameType(UserInfo userInfo) {
        Map<String, Object> map = new HashedMap();
        map.put("user_info_name", userInfo.getUserInfoName());
        map.put("user_info_type", userInfo.getUserInfoType());
        return map;
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @param userInfoPicture
     */
    @Override
    public void updateUserInfo(UserInfo userInfo, MultipartFile userInfoPicture) throws Exception {
        if (userInfoPicture != null) {
            MultipartFile[] files = {userInfoPicture};
            String[] path = iQuestionService.addFiles(files, 0);
            userInfo.setUserInfoUrl(path[0]);
        }
        this.updateById(userInfo);
    }

    /**
     * @Description: 根据类型和状态查询用户
     * @return:
     * @Author: fxh
     * @Date: 2018/11/29
     **/
    @Override
    public List<UserInfo> listByTypeAndStatus(String userInfoType, String userInfoCertificationStatus) {
        return userInfoMapper.listByTypeAndStatus(userInfoType, userInfoCertificationStatus);
    }
}
