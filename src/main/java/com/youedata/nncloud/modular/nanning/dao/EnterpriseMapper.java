package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.Enterprise;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.EnterpriseSearchVo;
import com.youedata.nncloud.modular.nanning.model.vo.NatureVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 企业信息表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author sunjian
 * @since 2018-11-27
 */
@Transactional
@Component
public interface EnterpriseMapper extends BaseMapper<Enterprise> {

    /**
     * 获取工业企业汇总列表
     * @param enterpriseName
     * @param enterpriseIndustry
     * @param enterpriseRegion
     * @param enterpriseBusinessType
     * @param enterpriseType
     * @param page
     * @return
     */
    List<Enterprise> getList(@Param("enterpriseName") String enterpriseName,
                             @Param("enterpriseIndustry") String enterpriseIndustry,
                             @Param("enterpriseRegion") String enterpriseRegion,
                             @Param("enterpriseBusinessType") String enterpriseBusinessType,
                             @Param("enterpriseType") String enterpriseType,
                             @Param("page") Page page);



    List<Enterprise> getAllList();

    /**
     * 获取企业信息详情
     * @param enterpriseId
     * @return
     */
    Enterprise getById(@Param("enterpriseId") Integer enterpriseId);

    /**
     * 我的企业
     * @param enterpriseUserId
     * @return
     */
    Enterprise getByUserId(@Param("enterpriseUserId") Integer enterpriseUserId);
    /**
     * 通过userId查询信息
     */
   Enterprise findUserId(@Param("enterpriseUserId") Integer enterpriseUserId);
    /**
	  * 通过Id查询信息
	  */
    Enterprise findById(@Param("enterpriseId") Integer enterpriseId);

    /**
     * 获取所有企业的行业
     * @return
     */
    List<String> getAllIndustry();

    /**
     * 模糊搜索
     * @return
     */
    List<EnterpriseSearchVo > searchByName(@Param("name")String name);
    /**
     * 获取工商注册类型列表
     */
    List<NatureVo> listRegister(@Param("natureId")Integer natureId);
    /**
     * 获取单位性质列表
     */
    List<NatureVo> getNature();
}
