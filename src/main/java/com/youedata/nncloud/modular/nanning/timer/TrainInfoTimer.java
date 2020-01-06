//package com.youedata.nncloud.modular.nanning.timer;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youedata.nncloud.core.util.UrlsUtil;
//import com.youedata.nncloud.modular.nanning.model.TrainInfo;
//import com.youedata.nncloud.modular.nanning.model.vo.TrainInfoVo;
//import com.youedata.nncloud.modular.nanning.service.ITrainInfoService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TrainInfoTimer {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    private final String API_URL = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=e8c8d8a4a6434269aa7fcfd5fd801cd6&pageIndex=1&pageSize=10000";
//
//    @Autowired
//    private ITrainInfoService service;
//
////    @Scheduled(cron = "0 20 17 * * ?")
//    public void getTrainInfo() {
//        try {
//            log.info("培训信息-定时器启动");
//            List<TrainInfoVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL).toString(), TrainInfoVo.class);
//            List<TrainInfo> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (TrainInfoVo vo : json) {
//                    //通过反射机制获取对象信息
//                    TrainInfo trainInfo = (TrainInfo) UrlsUtil.radiation(vo, TrainInfo.class);
//                    list.add(trainInfo);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("培训信息为空或第三方接口异常");
//            }
//            log.info("培训信息-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//}
