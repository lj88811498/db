package com.youedata.nncloud.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.youedata.nncloud.modular.nanning.anno.Too;

@Component
public class UrlsUtil {
	private static Logger log = LoggerFactory.getLogger(UrlsUtil.class);
	
	private static ConversionService conversionService;
	
	@Autowired
	public void setConversionService(ConversionService conversionService){
		UrlsUtil.conversionService = conversionService;
	}
	
	/**
	 * 通过url路径获取信息
	 * @param url
	 * @return
	 */
	public static List loadJson(String url) {
		List jsonArray = new ArrayList<>();
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            JSONObject jsonObject = JSONObject.parseObject(json.toString());
	        if(Integer.parseInt(jsonObject.get("staute").toString())==200){
	        	jsonArray = (List) jsonObject.get("list");
	        }
            in.close();
        } catch (MalformedURLException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return jsonArray;
    }
	/**
	 * 获取实体类的信息
	 * @return
	 */
	public static Map<String, String> lineFeed(Class cla) {
		Map<String, String> reMap = new HashMap<>();
		Field[] fields = cla.getDeclaredFields();
		for (Field field : fields) {
			Too ann = field.getAnnotation(Too.class);
			if(ann != null){
				String value = ann.value();
				String name = field.getName();
				reMap.put(value, name);
			}
		}
		return reMap;
	}
	/**
	 * 通过反射机制
	 * @param pro
	 * @param cla
	 * @return
	 * @throws Exception 
	 */
	public static Object radiation(Object pro, Class cla) throws Exception {
		//获取实体类的信息
		Map<String, String> map = lineFeed(cla);
		
		BeanWrapper beanWrapper = new BeanWrapperImpl(pro);
		Object instance = null;
		try {
			Constructor constructor = cla.getConstructor();
			instance = constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new Exception("创建对象异常");
		}
		Set<String> keySet = map.keySet();
		for (String auxiliary : keySet) {
			// VO 的字段名 + value
			Object propertyValue = beanWrapper.getPropertyValue(auxiliary);
			Class<?> propertyType = beanWrapper.getPropertyType(auxiliary);

			// Entity 的字段名
			String newFieldName = map.get(auxiliary);
			Field field = ReflectionUtils.findField(cla, newFieldName);
			Class<?> targetType = field.getType();
			
			//通过conversionService效验
			Object targetPropertyValue = propertyValue;
			if (propertyType != targetType) {
				targetPropertyValue = conversionService.convert(propertyValue, targetType);
			}
			
			field.setAccessible(true);
			// enterprise.setFieldName(targetPropertyValue);
			try {
				field.set(instance, targetPropertyValue);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
				throw new Exception("放射机制异常");
			}
		}
		return instance;
	}
}
