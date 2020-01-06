package com.youedata.nncloud.modular.nanning.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Ident;
import org.springframework.web.multipart.MultipartFile;

/**
 * 账号认证Service
 *
 * @author monkey
 * @Date 2018-11-09 15:19:35
 */
public interface IIdentService extends IService<Ident> {
    /**
     * 查询认证信息
     *
     * @param identUserId
     * @return
     */
    Ident selectOne(Integer identUserId) throws Exception;

    /**
     * 修改认证联系人
     *
     * @param identUserId
     * @param identContact
     * @param identTelephone
     * @throws Exception
     */
    void updateContact(Integer identUserId, String identContact, String identTelephone) throws Exception;

    /**
     * 添加用户认证信息
     *
     * @param ident
     * @param identPicture
     * @param identPictureCopy
     */
    void authentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld) throws Exception;

    /**
     * 修改认证信息
     *
     * @param ident
     * @param identPicture
     */
    void updateAuthentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld) throws Exception;

    /**
     * 认证审核
     *
     * @param identId
     * @param identStatus
     */
    void review(Integer identId, String identStatus, String identRegisteredAddress, String identOfficeAddress, String identLegalPerson, String identLandlines) throws Exception;

    /**
     * 提交审核
     *
     * @param userId
     */
    void submit(String userId) throws Exception;

    /**
     * 查询认证信息列表
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
    Page selectList(String identType, String userInfoName, String identStatus, String identCreateTimeBegin, String identCreateTimeEnd, String identEnterpriseName, String identEnterpriseCode, String identContact, String identTelephone, int size, int curPage) throws Exception;

    /**
     * app端修改认证信息
     * @param ident
     * @param identPicture
     * @param identPictureCopy
     * @param identPictureHandheld
     */
    void appUpdateAuthentication(Ident ident, MultipartFile identPicture, MultipartFile identPictureCopy, MultipartFile identPictureHandheld)throws Exception;
}
