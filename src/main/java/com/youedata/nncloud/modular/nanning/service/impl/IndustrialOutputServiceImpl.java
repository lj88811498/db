package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.common.constant.factory.PageFactory;
import com.youedata.nncloud.core.util.DateUtil;
import com.youedata.nncloud.modular.nanning.dao.IndustrialOutputMapper;
import com.youedata.nncloud.modular.nanning.model.IndustrialOutput;
import com.youedata.nncloud.modular.nanning.model.vo.IndustrialOutputVo;
import com.youedata.nncloud.modular.nanning.service.IIndustrialOutputService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;


/**
 * 工业主要产品产量表Service
 *
 * @author HuangKai
 * @Date 2018-12-12 16:49:41
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class IndustrialOutputServiceImpl extends ServiceImpl<BaseMapper<IndustrialOutput>,IndustrialOutput> implements IIndustrialOutputService {
@Autowired
IndustrialOutputMapper industrialOutputMapper;
    @Override
    public Page getList(String date,int size,int curPage)throws  Exception {
        Page page = new PageFactory<Map<String, String>>().defaultPage2(size, curPage);
        String time = null;
        if(org.springframework.util.StringUtils.isEmpty(date)){
            time = DateUtil.getMoth();
        }else{
            time = date.replace("-","");
        }
        List<IndustrialOutput> list = industrialOutputMapper.getList(Integer.parseInt(time));
        List<IndustrialOutputVo> voList =new  ArrayList<IndustrialOutputVo>();
        for (IndustrialOutput industrialOutput: list){
            IndustrialOutputVo vo = new IndustrialOutputVo();
            Map map = new LinkedHashMap<>();
            vo.setIndustrialOutputName(industrialOutput.getIndustrialOutputName());
            vo.setIndustrialOutputUnit(industrialOutput.getIndustrialOutputUnit());
            if(StringUtils.isEmpty(date)){
               date = DateUtil.getMoths();
            }
            Integer moth = Integer.valueOf(date.substring(5,7));
            map.put(moth+"月产量",industrialOutput.getIndustrialOutputCurrent());
            map.put(moth+"月止累计",industrialOutput.getIndustrialOutputGrandTotal());
            map.put("同比±%",industrialOutput.getIndustrialOutputComparison());
            vo.setKeyMap(map);
            voList.add(vo);
        }

        page.setRecords(voList);
        return page;
    }

  /*  public static void main(String[] args){
        Integer moth = Integer.valueOf("2018-12".substring(5,7));
        System.out.println("-----"+moth);
    }*/

}
