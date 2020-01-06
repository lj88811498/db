//package com.youedata.nncloud.modular.nanning.timer;
//
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.youedata.nncloud.core.util.UrlsUtil;
//import com.youedata.nncloud.modular.nanning.model.PublicResource;
//import com.youedata.nncloud.modular.nanning.model.vo.PublicResourceVo;
//import com.youedata.nncloud.modular.nanning.service.IPublicResourceService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class PublicResourceTimer {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//    private final String API_URL = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=9aa2761a04d74f6b9044bb6126b5a3bb&pageSize=100000";
//
//    @Autowired
//    private IPublicResourceService service;
//
////    @Scheduled(cron = "0 0 1 ? * L")
//    public void getPublicResource() {
//        try {
//            log.info("两化融合接口-定时器启动");
//            EntityWrapper<PublicResource> entityWrapper = new EntityWrapper<>();
//            entityWrapper.where("public_resource_id>{0}", 0);
//            service.delete(entityWrapper);
//            List<PublicResourceVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL).toString(), PublicResourceVo.class);
//            List<PublicResource> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (PublicResourceVo publicResourceVo : json) {
//                    //通过反射机制获取对象信息
//                    PublicResource publicResource = (PublicResource) UrlsUtil.radiation(publicResourceVo, PublicResource.class);
//                    list.add(publicResource);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("两化融合接口信息为空或第三方接口异常");
//            }
//            log.info("两化融合接口-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//}
