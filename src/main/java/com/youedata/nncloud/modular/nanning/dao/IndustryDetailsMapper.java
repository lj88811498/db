package com.youedata.nncloud.modular.nanning.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工业报表详情表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface IndustryDetailsMapper extends BaseMapper<IndustryDetails> {
    /**
     * 通过工业报表id和标题类型查询信息
     *
     * @param industryDetailsIndustryId
     * @param industryDetailsType
     * @return
     */
    List<IndustryDetails> getIndustryDetails(@Param("industryDetailsIndustryId") Integer industryDetailsIndustryId, @Param("industryDetailsType") String industryDetailsType, @Param("page") Page page);

    /**
     * 根据关联id和type
     *
     * @param industryDetailsIndustryId
     * @param industryDetailsType
     * @return
     */
    IndustryDetails getIndustryDetailsByIdAndType(@Param("industryDetailsIndustryId") Integer industryDetailsIndustryId, @Param("industryDetailsType") String industryDetailsType);

    /**
     * 工业总产值list
     *
     * @param companyId
     * @return
     */
    List<Map<String, String>> getTotal(@Param("companyId") Integer companyId);

    /**
     * 行业小分类list
     *
     * @param companyId
     * @return
     */
    List<Map<String, String>> getClassification(@Param("companyId") Integer companyId,
                                                @Param("year") Integer year,
                                                @Param("yearBegin") Integer yearBegin);

    /**
     * 行业小分类名称
     * @param companyId
     * @param year
     * @param
     * @return
     */
    List<Map<String,String>> getClassificationName(@Param("companyId") Integer companyId,
                                                   @Param("year") Integer year,
                                                   @Param("yearBegin") Integer yearBegin);


    /**
     * 主要产品list
     *
     * @param companyId
     * @return
     */
    List<Map<String, String>> getProducts(@Param("companyId") Integer companyId,
                                          @Param("year") Integer year,
                                          @Param("yearBegin") Integer yearBegin);

    /**
     * 主要产品名称
     *
     * @param companyId
     * @return
     */
    List<Map<String,String>> getProductsName(@Param("companyId") Integer companyId,
                                             @Param("year") Integer year,
                                             @Param("yearBegin") Integer yearBegin);
}
