package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.config.properties.GunsProperties;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.modular.nanning.dao.IdentMapper;
import com.youedata.nncloud.modular.nanning.dao.MessageMapper;
import com.youedata.nncloud.modular.nanning.dao.UserInfoMapper;
import com.youedata.nncloud.modular.nanning.model.Ident;
import com.youedata.nncloud.modular.nanning.model.Message;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.youedata.nncloud.modular.nanning.service.IIdentService;
import com.youedata.nncloud.modular.nanning.service.IQuestionService;
import com.youedata.nncloud.modular.nanning.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 账号认证Service
 *
 * @author monkey
 * @Date 2018-11-09 15:19:35
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IdentServiceImpl extends ServiceImpl<BaseMapper<Ident>, Ident> implements IIdentService {

    @Autowired
    private IdentMapper identMapper;
    @Autowired
    private GunsProperties gunsProperties;
    @Autowired
    private IQuestionService iQuestionService;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询用户验证信息
     *
     * @param identUserId
     * @return
     * @author lich
     */
    @Override
    public Ident selectOne(Integer identUserId) throws Exception {
        Ident ident = identMapper.selectByUserId(identUserId);
        if (ident == null) {
            return null;
            //            throw new Exception("认证信息不存在！");
        }

        ident.setIdentPictureSource(gunsProperties.getFileServerPath() + ident.getIdentPictureSource());
        ident.setIdentPictureCopy(gunsProperties.getFileServerPath() + ident.getIdentPictureCopy());
        ident.setIdentPictureHandheld(gunsProperties.getFileServerPath() + ident.getIdentPictureHandheld());
        return ident;
    }

    /**
     * 修改认证联系人
     *
     * @param identUserId
     * @param identContact
     * @param identTelephone
     */
    @Override
    public void updateContact(Integer identUserId, String identContact, String identTelephone) throws Exception {
        Ident ident = identMapper.selectByUserId(identUserId);
        if (ident == null) {
            throw new Exception("认证信息不存在！");
        }
        ident.setIdentContact(identContact);
        ident.setIdentTelephone(identTelephone);
        ident.updateById();
    }

    /**
     * 添加认证信息
     *
     * @param ident
     * @param identPicture
     * @param identPictureCopy
     */
    @Override
    public void authentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld) throws Exception {
        System.out.println("Service参数打印：identPicture="+identPicture+"\n identPictureCopy="+identPictureCopy+"\n identPictureHandheld="+identPictureHandheld);
        ident.insert();
        MultipartFile[] files = {identPicture, identPictureCopy, identPictureHandheld};
        String[] path;
        try {
            path = iQuestionService.addFiles(files, 0);
        } catch (Exception e) {
            throw new Exception("图片上传异常");
       }

        ident.setIdentPictureSource(path[0]);
        ident.setIdentPictureCopy(path[1]);
        ident.setIdentPictureHandheld(path[2]);

        UserInfo userInfo = userInfoService.selectById(ident.getIdentUserId());
        userInfo.setUserInfoCertificationType(ident.getIdentType());
        userInfo.setUserInfoCertificationStatus("0");
        userInfo.updateById();

        ident.setIdentStatus("0");
        ident.updateById();
        addNewsToMessage(ident, userInfo);
    }

    /**
     * 修改认证信息
     *
     * @param ident
     * @param identPicture
     * @param identPictureCopy
     */
    @Override
    public void updateAuthentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld) throws Exception {
        MultipartFile[] files = {identPicture, identPictureCopy, identPictureHandheld};
        String[] path;
        try {
            path = iQuestionService.addFiles(files, 0);
        } catch (Exception e) {
            throw new Exception("图片上传异常");
        }
        ident.setIdentPictureSource(path[0]);
        ident.setIdentPictureCopy(path[1]);
        ident.setIdentPictureHandheld(path[2]);
        ident.updateById();
    }

    /**
     * app端修改认证信息
     *
     * @param ident
     * @param identPicture
     * @param identPictureCopy
     */
    @Override
    public void appUpdateAuthentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld) throws Exception {
        MultipartFile[] files = {identPicture, identPictureCopy, identPictureHandheld};
        String[] path;
        try {
            path = iQuestionService.addFiles(files, 0);
        } catch (Exception e) {
            throw new Exception("图片上传异常");
        }
        ident.setIdentPictureSource(path[0]);
        ident.setIdentPictureCopy(path[1]);
        ident.setIdentPictureHandheld(path[2]);
        ident.setIdentStatus("0");
        identMapper.update(ident,new EntityWrapper<Ident>().eq("ident_user_id",ident.getIdentUserId()));

        //认证消息入库
        UserInfo userInfo = userInfoMapper.selectById(ident.getIdentUserId());
        if (userInfo == null) {
            throw new Exception("用户不存在！");
        }
        addNewsToMessage(ident, userInfo);
        userInfo.setUserInfoCertificationStatus("0");
        userInfo.updateById();
    }

    /**
     * 认证信息审核
     *
     * @param identId,identStatus
     */
    @Override
    public void review(Integer identId, String identStatus, String identRegisteredAddress, String identOfficeAddress, String identLegalPerson, String identLandlines) throws Exception {
        Ident ident = identMapper.selectById(identId);
        UserInfo userInfo = userInfoMapper.selectById(ident.getIdentUserId());
        if (ident == null) {
            throw new Exception("认证信息不存在！");
        }
        ident.setIdentStatus(identStatus);
        ident.setIdentUpdateBy(1);
        ident.setIdentRegisteredAddress(identRegisteredAddress);
        ident.setIdentOfficeAddress(identOfficeAddress);
        ident.setIdentLegalPerson(identLegalPerson);
        ident.setIdentLandlines(identLandlines);
        ident.setIdentUpdateTime(new Date());
        identMapper.updateById(ident);
        //认证消息入库
        addNewsToMessage(ident, userInfo);
        if (userInfo == null) {
            throw new Exception("用户不存在！");
        }
        userInfo.setUserInfoCertificationStatus(identStatus);
        userInfo.updateById();
    }


    /**
     * 提交审核
     *
     * @param userId
     * @throws Exception
     */
    @Override
    public void submit(String userId) throws Exception {
        Ident ident = identMapper.selectById(Integer.valueOf(userId));
        if (ident == null) {
            throw new Exception("认证信息不存在！");
        }
        UserInfo userInfo = userInfoMapper.selectById(ident.getIdentUserId());
        if (userInfo == null) {
            throw new Exception("用户不存在！");
        }
        ident.setIdentStatus("0");
        identMapper.updateById(ident);
        addNewsToMessage(ident, userInfo);


        userInfo.setUserInfoCertificationStatus("0");
        userInfo.updateById();
    }

    /**
     * 查询列表
     *
     * @param userInfoName
     * @param identCreateTimeBegin
     * @param identCreateTimeEnd
     * @param identEnterpriseName
     * @param identEnterpriseCode
     * @param identContact
     * @param identTelephone
     * @param size
     * @param curPage
     * @return
     * @throws Exception
     */
    @Override
    public Page selectList(String identType, String userInfoName, String identStatus, String identCreateTimeBegin, String identCreateTimeEnd, String identEnterpriseName, String identEnterpriseCode, String identContact, String identTelephone, int size, int curPage) throws Exception {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        List<Map<String, String>> result = identMapper.selectList(identType, userInfoName, identStatus, identCreateTimeBegin, identCreateTimeEnd, identEnterpriseName, identEnterpriseCode, identContact, identTelephone, page);
        page.setRecords(result);
        return page;
    }


    /**
     * 认证消息入库
     *
     * @param ident
     * @param userInfo
     */
    private void addNewsToMessage(Ident ident, UserInfo userInfo) throws Exception {
        Message message = new Message();
        message.setMessageType("4");
        message.setMessageUserId(userInfo.getUserInfoId());
        message.setMessageCreateTime(new Date());
        message.setMessageReadFlag("0");
        String messageContent = "";

        switch (ident.getIdentStatus()) {
            case "0":
                messageContent = "已收到您的认证申请，请等待工作人员处理";
                break;
            case "1":
                if (userInfo.getUserInfoType().equals("0")) {
                    messageContent = "恭喜您通过个人认证";
                } else {
                    messageContent = "恭喜您通过企业认证";
                }
                break;
            case "2":
                messageContent = "抱歉您的认证申请未通过";
                break;
            default:
                throw new Exception("认证消息入库失败，请检查参数");
        }
        message.setMessageContent(messageContent);
        message.insert();

    }


}
