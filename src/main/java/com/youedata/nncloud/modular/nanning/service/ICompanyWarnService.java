package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.CompanyWarn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 重点企业预警Service
 *
 * @author fxh
 * @Date 2018-12-13 13:58:41
 */
public interface ICompanyWarnService extends IService<CompanyWarn>{

    List<CompanyWarn> list(@Param("userId")String userId, @Param("yearMonth")String yearMonth, @Param("sort")int sort);


    void calculate(@Param("yearMonth")String yearMonth);
}
