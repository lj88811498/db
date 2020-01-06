package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.Industry;
import com.youedata.nncloud.modular.nanning.model.IndustryDetails;
import com.youedata.nncloud.modular.nanning.model.vo.RoleVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 工业报表; InnoDB free: 3072 kB Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-27
 */
@Transactional
@Component
public interface IndustryMapper extends BaseMapper<Industry> {
	 /**
	  * 查询工业报表列表
	  * @param page
	  * @return
	  */
	 List<Industry> getList(@Param("page") Page page, @Param("industryEnterpriseId") String industryEnterpriseId, @Param("industryName") String industryName, @Param("enterpriseName") String enterpriseName, @Param("startTime") String startTime, @Param("endTime") String endTime);
	 /**
     * 根据工业报表id获取信息
     * @param roleId
     * @return
     */
	 Industry getById(@Param("industryId") Integer industryId);

	/**
	 * 根据企业id和年月时间获取主键id
	 * @param industryEnterpriseId
	 * @param industryYear
	 * @return
	 */
	 Integer getId(@Param("industryEnterpriseId") String industryEnterpriseId, @Param("industryYear") Integer industryYear);
}
