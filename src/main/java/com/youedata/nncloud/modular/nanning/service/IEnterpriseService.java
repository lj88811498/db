package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.Enterprise;
import com.youedata.nncloud.modular.nanning.model.vo.EnterpriseSearchVo;
import com.youedata.nncloud.modular.nanning.model.vo.NatureVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 企业信息表Service
 *
 * @author sunjian
 * @Date 2018-11-27 15:49:37
 */
public interface IEnterpriseService extends IService<Enterprise>{

    /**
     * 获取工业企业汇总列表
     * @param enterpriseName
     * @param enterpriseIndustry
     * @param enterpriseRegion
     * @param enterpriseBusinessType
     * @param enterpriseType
     * @param size
     * @param curPage
     * @return
     */
    Page getList(String enterpriseName, String enterpriseIndustry, String enterpriseRegion, String enterpriseBusinessType, String enterpriseType, int size, int curPage);


    List<Enterprise> getAllList();


    /**
     * 获取企业信息详情
     * @param enterpriseId
     * @return
     */
    Enterprise getById(Integer enterpriseId);

    /**
     * 我的企业
     * @param enterpriseUserId
     * @return
     */
    Enterprise getByUserId(Integer enterpriseUserId);

    /**
     * 获取所有企业的行业
     * @return
     */
    List<String> getAllIndustry();

    /**
     * 模糊搜索
     * @return
     */
    List<EnterpriseSearchVo > searchByName(String name);
    /**
     * 通过userId查询信息
     */
    Enterprise findUserId(Integer enterpriseUserId);
    /**
	  * 通过Id查询信息
	  */
    Enterprise findById(Integer enterpriseId);

    Enterprise selectOne(Integer companyId);
    /**
     * 获取工商注册类型列表
     */
    List<NatureVo> listRegister(Integer natureId);
    /**
     * 获取单位性质列表
     */
    List<NatureVo> getNature();
}
