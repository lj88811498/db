package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Ident;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账号认证 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-09
 */
@Transactional
@Component
public interface IdentMapper extends BaseMapper<Ident> {

    Ident selectByUserId(@Param("userId") Integer identUserId);

    List<Map<String,String>> selectList(@Param("type")String identType,
                         @Param("userName")String userInfoName,
                         @Param("status")String identStatus,
                         @Param("beginTime")String identCreateTimeBegin,
                         @Param("endTime")String identCreateTimeEnd,
                         @Param("name")String identEnterpriseName,
                         @Param("code")String identEnterpriseCode,
                         @Param("contact")String identContact,
                         @Param("phone")String identTelephone,
                         @Param("page")Page page);

}
