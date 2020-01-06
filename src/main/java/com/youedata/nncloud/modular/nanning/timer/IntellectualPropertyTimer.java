//package com.youedata.nncloud.modular.nanning.timer;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youedata.nncloud.core.util.UrlsUtil;
//import com.youedata.nncloud.modular.nanning.model.IntellectualProperty;
//import com.youedata.nncloud.modular.nanning.model.vo.IntellectualPropertyVo;
//import com.youedata.nncloud.modular.nanning.service.IIntellectualPropertyService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class IntellectualPropertyTimer {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    private final String API_URL = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=a92daab2b922440f8c1bf5820ee4e6c7&pageIndex=1&pageSize=1000";
//
//    @Autowired
//    private IIntellectualPropertyService service;
//
////    @Scheduled(cron = "0 32 13 * * ?")
//    public void getIntellectualProperty() {
//        try {
//            log.info("知识产权-定时器启动");
//            List<IntellectualPropertyVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL).toString(), IntellectualPropertyVo.class);
//            List<IntellectualProperty> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (IntellectualPropertyVo vo : json) {
//                    //通过反射机制获取对象信息
//                    IntellectualProperty intellectualProperty = (IntellectualProperty) UrlsUtil.radiation(vo, IntellectualProperty.class);
//                    list.add(intellectualProperty);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("知识产权接口信息为空或第三方接口异常");
//            }
//            log.info("知识产权-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//}
