package com.wangzai.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @ClassName ObjectUtils
 * @Description 对象相关工具类
 * @author zhangw
 * @date Mar 9, 2018 3:36:11 PM
 *
 */
public class ObjectUtils {

    /**
     * 将一个对象中的属性跟值保存在Map<String, Object>中 如果值为null不保存
     * @param obj
     * @return
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, Object> reflexToMap(Object obj) throws Exception {
        
        Class clazz = (Class) obj.getClass(); 
        Field[] fs = clazz.getDeclaredFields();  
        Map<String, Object> map = new HashMap<String, Object>();
        
        for(int i = 0 ; i < fs.length; i++){  
            Field f = fs[i];  
            f.setAccessible(true); //设置些属性是可以访问的  
            Object val = null;
            try {
                val = f.get(obj);//得到此属性的值 
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception();
            }    
            
            if (val != null && !f.getName().equals("serialVersionUID")) {
                map.put(f.getName(), val);
            }
        }
        
        return map;
    }
    
}
