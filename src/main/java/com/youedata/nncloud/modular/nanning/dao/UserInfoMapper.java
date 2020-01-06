package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.UserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-09-12
 */
@Transactional
@Component
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * 获取用户列表
     * @param userName
     * @param createTime
     * @param certificationStatus
     * @param certificationType
     * @param userStatus
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<UserInfo> getList(@Param("userName") String userName,
                           @Param("createTime") String createTime,
                           @Param("endTime")String endTime,
                           @Param("certificationStatus") String certificationStatus,
                           @Param("certificationType") String certificationType,
                           @Param("userStatus") String userStatus,
                           @Param("page") Page page,
                           @Param("orderByField") String orderByField,
                           @Param("isAsc") boolean isAsc);

    /**
     * 查询用户详情
     * @param userId
     * @return
     */
    UserInfo getById(@Param("userId") Integer userId);

    /**
     * 查询政府用户
     * @param userName
     * @param userInfoWorker
     * @param beginTime
     * @param endTime
     * @param userInfoStatus
     * @param page
     * @param orderByField
     * @param isAsc
     * @return
     */
    List<UserInfo> getGovList(@Param("userName") String userName,
                              @Param("userInfoWorker") String userInfoWorker,
                              @Param("beginTime") String beginTime,
                              @Param("endTime") String endTime,
                              @Param("userInfoStatus") String userInfoStatus,
                              @Param("page") Page page,
                              @Param("orderByField") String orderByField,
                              @Param("isAsc") boolean isAsc);

    /**
     * 注册查看重名
     *
     * @param userInfoName
     * @return
     */
    List<Map<String, Object>> selectByName(@Param("userInfoName") String userInfoName);

    /**
     * 验证小于该id的重名
     *
     * @param userInfoId
     * @return
     */
    List selectOneBefId(@Param("userInfoId") Integer userInfoId, @Param("userInfoName") String userInfoName);

    /**
     * 查询单个用户
     * @param userInfoName
     * @return
     */
    UserInfo selectone(@Param("userInfoName") String userInfoName);

    List<UserInfo> listByTypeAndStatus(@Param("userInfoType") String userInfoType, @Param("userInfoCertificationStatus") String userInfoCertificationStatus);

    /**
     * 根据id查name
     * @param userInfoId
     * @return
     */
    String selectNameById(@Param("userInfoId") Integer userInfoId);

    /**
     * 根据名称查询一个用户所有信息
     * @param accountName
     * @return
     */
    UserInfo selectOneByName(String accountName);
}
