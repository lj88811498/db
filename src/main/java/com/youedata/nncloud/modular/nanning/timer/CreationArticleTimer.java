//package com.youedata.nncloud.modular.nanning.timer;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youedata.nncloud.core.util.UrlsUtil;
//import com.youedata.nncloud.modular.nanning.model.CreationArticle;
//import com.youedata.nncloud.modular.nanning.model.vo.CreationArticleVo;
//import com.youedata.nncloud.modular.nanning.service.ICreationArticleService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CreationArticleTimer {
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private ICreationArticleService service;
//
////    @Scheduled(cron = "0 26 10 * * ?")
//    public void getTech() {
//        try {
//            log.info("创新创业-技术前沿-定时器启动");
//            String API_URL_TECH = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=53ccff6b116740a8bb0ae9c4753a0a9c&category_name=" + URLEncoder.encode("技术前沿", "utf-8") + "&pageIndex=1&pageSize=2000";
//            List<CreationArticleVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL_TECH).toString(), CreationArticleVo.class);
//            List<CreationArticle> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (CreationArticleVo vo : json) {
//                    //通过反射机制获取对象信息
//                    CreationArticle creationArticle = (CreationArticle) UrlsUtil.radiation(vo, CreationArticle.class);
//                    list.add(creationArticle);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("创新创业-技术前沿接口信息为空或第三方接口异常");
//            }
//            log.info("创新创业-技术前沿-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//
////    @Scheduled(cron = "0 28 10 * * ?")
//    public void getProduct() {
//        try {
//            log.info("创新创业-产品推荐-定时器启动");
//            String API_URL_PRODUCT = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=53ccff6b116740a8bb0ae9c4753a0a9c&category_name=" + URLEncoder.encode("产品推荐", "utf-8") + "&pageIndex=1&pageSize=1000";
//            List<CreationArticleVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL_PRODUCT).toString(), CreationArticleVo.class);
//            List<CreationArticle> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (CreationArticleVo vo : json) {
//                    //通过反射机制获取对象信息
//                    CreationArticle creationArticle = (CreationArticle) UrlsUtil.radiation(vo, CreationArticle.class);
//                    list.add(creationArticle);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("创新创业-产品推荐接口信息为空或第三方接口异常");
//            }
//            log.info("创新创业-产品推荐-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//
////    @Scheduled(cron = "0 30 10 * * ?")
//    public void getReport() {
//        try {
//            log.info("创新创业-项目申报-定时器启动");
//            String API_URL_REPORT = "http://219.159.152.202:8081/INTERFACE.API/f/api/geii_ibdms?key=53ccff6b116740a8bb0ae9c4753a0a9c&category_name=" + URLEncoder.encode("项目申报", "utf-8") + "&pageIndex=1&pageSize=1000";
//            List<CreationArticleVo> json = JSONObject.parseArray(UrlsUtil.loadJson(API_URL_REPORT).toString(), CreationArticleVo.class);
//            List<CreationArticle> list = new ArrayList<>();
//            if (json.size() > 0) {
//                for (CreationArticleVo vo : json) {
//                    //通过反射机制获取对象信息
//                    CreationArticle creationArticle = (CreationArticle) UrlsUtil.radiation(vo, CreationArticle.class);
//                    list.add(creationArticle);
//                }
//                service.insertBatch(list);
//            } else {
//                log.info("创新创业-项目申报接口信息为空或第三方接口异常");
//            }
//            log.info("创新创业-项目申报-定时器结束");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//}
