package com.wangzai.interceptor;

import com.wangzai.utils.SHA256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 功能描述: 拦截器
 *
 * @auther: zhangw
 * @date: 2018/9/29 10:58
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    private String common_account = "xqtc _account";

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        Gson gson = new GsonBuilder().serializeNulls().enableComplexMapKeySerialization().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//
//        Map parameterMap = request.getParameterMap();
//
//        log.info(" 请求地址为: " + request.getServletPath() + " 请求参数为: " + gson.toJson(parameterMap));
//        try {
////            if (request.getParameter("sign").equals(common_account)) {         //测试绿色通道
////                return true;
////            }
//            //获取请求参数
//            //校验时间
//            String timeParam = request.getParameter("timeStamp");
//            long timeStamp = Long.parseLong(timeParam);
//            Long SystemTime = (new Date().getTime() - timeStamp) / (1000 * 60);
//            if (StringUtils.isEmpty(timeParam) || SystemTime > 1) {
//                response.setStatus(81007);
//                response.sendError(81007, "timeStamp不能为空或已过期！请检查！");
//                return false;
//            }
//            //验证参数
//            String accessKey = request.getParameter("accessKey");
//            if (StringUtils.isEmpty(accessKey)) {
//                //公钥不存在
//                response.setStatus(81001);
//                response.sendError(81001, "accessKey不能为空！");
//                return false;
//            }
//            if (StringUtils.isEmpty(request.getParameter("nonce"))) {
//                //随机数不存在
//                response.setStatus(81002);
//                response.sendError(81002, "nonce不能为空！");
//                return false;
//            }
////            String paramSign = request.getParameter("sign");
////            if (StringUtils.isEmpty(paramSign)) {
////                //签名不存在
////                response.setStatus(81003);
////                response.sendError(81003, "签名不能为空！");
////                return false;
////            }
//
////            String param = keySort(parameterMap);        //排序后的参数字符串
//            BusinessService businessService = SpringBeanUtil.getBean("businessServiceImpl");
//            Business business = businessService.selectOne(accessKey);
//            String systemSign = null;
//            if (business != null) {
////                String secretKey = business.getSecretKey();
////                String signTemplate = (param + "&secretKey=" + secretKey);
////                String xxx = signTemplate.toUpperCase();
////                systemSign = SHA256Util.getSHA256String(xxx);
//                return  true;
//            } else {
//                response.setStatus(81004);
//                response.sendError(81004, "公钥有误,请检查！");
//                return false;
//            }
//            //加密 公钥+私钥+参数
////            if (!systemSign.equals(paramSign) || !StringUtils.isEquals(systemSign, paramSign)) {
////                System.err.println(systemSign + "================签名有误=========================" + paramSign);
////                response.setStatus(81005);
////                response.sendError(81005, "签名有误,请检查！");
////                return false;
////            }
////            return true;
//
//        } catch (Exception e) {
//            log.error(e.toString());
//            response.setStatus(500);
//            response.sendError(500, "请求异常! ");
//            return false;
//        }
        return true;
    }

    public static void main(String[] args) {
//            "sign":["5a7917477bed41f8bea67db129a2a648daa7da3c8b70f1d62f72323a23f52ea9"]}
        Map map = new HashMap();
        map.put("accessKey", "xqtc6f5ce1b4");
        map.put("timeStamp", "1563191843820");
        map.put("unitCode", "");
        map.put("ticketId", "DB20190715310693");
        map.put("branchCode", "3010100");
        map.put("nonce", "260965");
        map.put("ticketType", "0");
        map.put("applyName", "李梦琪");
        map.put("applyPhone", "15789658986");
        map.put("carRentalVehicleNo", "沪A35B2");
        map.put("pointTime", "2019-07-11 14:30:50");
        map.put("serviceType", "21");
        map.put("theTimeStamp", "2019-07-15 19:57:23");
        map.put("reason", "");
        map.put("ariportName", "上海虹桥机场");
        map.put("pickCarTime", "2019-07-15 12:00:00");
        map.put("remark1", "");
        map.put("remark2", "");
        String sign = createSign(map, "3e06TcvI7SqI9Kny");
        System.err.println("sign============" + sign);
        String x = keySort(map);
        String kkk = x + "&secretKey=3e06TcvI7SqI9Kny";
        String xxx = kkk.toUpperCase();
        System.err.println(xxx);
        String sha256 = SHA256Util.getSHA256String(x);
        System.err.println(sha256);
        System.err.println(System.currentTimeMillis());
    }

    public static String key_sort(Map<String, String[]> map) {
        String key_sort = "";
        TreeMap<String, String[]> map2 = new TreeMap<String, String[]>(new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                // 降序排序
                return obj2.compareTo(obj1);
            }
        });
        map2 = new TreeMap<>(map);
        map2.remove("sign");
        Set<String> keySet = map2.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            key_sort = key_sort + key + "=" + map2.get(key)[0] + "&";
        }
        return key_sort.substring(0, key_sort.length() - 1);
    }

    public static String keySort(Map map) {
        String key_sort = "";
        TreeMap map2 = new TreeMap(new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                // 降序排序
                return obj2.compareTo(obj1);
            }
        });
        map2 = new TreeMap<>(map);
        map2.remove("sign");
        Set<String> keySet = map2.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            key_sort = key_sort + key + "=" + map2.get(key) + "&";
        }
        return key_sort.substring(0, key_sort.length() - 1);
    }

    private static String createSign(Map<String, Object> params, String secretKey) {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuilder temp = new StringBuilder();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            temp.append(valueString);
        }
        temp.append("&").append("secretKey").append("=").append(secretKey);
        System.err.println(temp.toString());
        return SHA256Util.getSHA256String(temp.toString().toUpperCase());
    }
}
