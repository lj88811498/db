package com.youedata.nncloud.modular.nanning.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.core.util.JsonUtil;
import com.youedata.nncloud.modular.nanning.model.Ident;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.youedata.nncloud.modular.nanning.model.vo.CodeVo;
import com.youedata.nncloud.modular.nanning.model.vo.DataosUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 用户信息Service
 *
 * @author monkey
 * @Date 2018-09-12 10:11:32
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * @return com.youedata.nncloud.modular.nanning.model.UserInfo
     * @author: Monkey
     * @param: []
     * @date: Created in  2018/9/17 16:49.
     */
    UserInfo selectOne(String userInfoType, String userInfoName, String userInfoNamePwd) throws Exception;

    /**
     * 修改密码
     *
     * @param userInfoNamePwdNew
     * @param userInfoId
     * @author lich
     * @author lich
     */
    void changePsaaword(Integer userInfoId, String userInfoNamePwd, String userInfoNamePwdNew) throws Exception;

    /**
     * 账户列表信息查询
     * *@author lich
     *
     * @param userInfoName
     * @return
     */
    JSONObject accounts(String userInfoName, String fields) throws Exception;

    /**
     * 账户详细信息查询
     *
     * @return
     */
    JSONObject accountDetail();

    /**
     * 账户信息修改
     *
     * @return
     */
    JSONObject accountUpdate(String telephone, String email, String extendedProperties, String accountPasswd, String oldPasswd);

    /**
     * 删除账户
     *
     * @return
     */
    JSONObject accountDelete();

    /**
     * 用户退出
     *
     * @return
     */
    JSONObject logout();

    /**
     * 验证token
     *
     * @param accessToken
     * @return
     * @author lich
     */
    Object checkAccessToken(String accessToken) throws Exception;

    /**
     * 注册
     *
     * @param accountName
     * @param telephone
     * @param email
     * @param extendedProperties
     * @param accountPasswd
     * @param parendId
     * @return
     * @author lich
     */
    JSONObject registerDataOs(String accountName, String telephone, String email, String extendedProperties, String accountPasswd, String parendId) throws Exception;

    /**
     * 登录
     *
     * @param accountName
     * @param accountPasswd
     * @param loginIP
     * @return
     * @author lich
     */
    DataosUser login(String accountName, String accountPasswd, String loginIP, Integer expireTime) throws Exception;

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
    Page getList(String userName, String createTime,String userInfoCreateTimeEnd, String certificationStatus, String certificationType, String userStatus, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     */
    UserInfo getById(Integer userId);

    /**
     * 上传头像
     *
     * @param file
     * @param userId
     * @return
     */
    Object uploadImg(MultipartFile file, Integer userId) throws Exception;

    /**
     * 获取验证码地址
     *
     * @return
     */
    CodeVo getCodePath();

    /**
     * 修改用户昵称
     *
     * @param userInfoId
     * @param userInfoNickname
     */
    JSONObject updateNickName(Integer userInfoId, String userInfoNickname);

    /**
     * 查询政府用户
     *
     * @param userName
     * @param userInfoWorker
     * @param beginTime
     * @param endTime
     * @param userStatus
     * @param orderByField
     * @param isAsc
     * @param size
     * @param curPage
     * @return
     */
    Page getGovList(String userName, String userInfoWorker, String beginTime, String endTime, String userStatus, String orderByField, boolean isAsc, int size, int curPage);

    /**
     * 新增政府用户
     */
    JSONObject addGovAccount(UserInfo userInfo, Integer roleId) throws Exception;

    /**
     * 根据userid查详细信息及角色名称
     *
     * @param userInfoId
     * @return
     */
    Map<String, Object> getAccountDetailAndRoleName(Integer userInfoId);

    /**
     * 注册用户
     *
     * @param userInfo
     */
    String register(UserInfo userInfo);

    /**
     * 修改政府用户
     *
     * @param userInfo
     * @return
     */
    JSONObject updateGovUser(UserInfo userInfo, Integer userInfoRoleId) throws Exception;

    /**
     * 重置密码
     *
     * @param userInfoId
     * @return
     */
    JSONObject reSetPwd(Integer userInfoId) throws Exception;

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @param userInfoPicture
     */
    void updateUserInfo(UserInfo userInfo, MultipartFile userInfoPicture) throws Exception;


    /**
     * @Description: 根据类型和状态查询用户
     * @return:
     * @Author: fxh
     * @Date: 2018/11/28
     **/
    List<UserInfo> listByTypeAndStatus(String userInfoType, String userInfoCertificationStatus);
}
