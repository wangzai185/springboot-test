package com.wangzai.controller;

import com.wangzai.result.ApiResult;
import com.wangzai.utils.RequestUtil;
import com.wangzai.utils.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 功能描述:公用Controller 公用方法
 *
 * @auther: zhangw
 * @date: 2018/9/29 10:56
 */
public class BaseController {

    public static final int DEFAULT_ROWS = 10;



    public Map<String, Object> converRequestMap(Map<String, String[]> paramMap) {
        return this.converRequestMap(paramMap, new String[]{});
    }

    public Map<String, Object> converRequestMap(Map<String, String[]> paramMap, String[] excludeName) {
        Map<String, Object> rMap = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(excludeName));
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            if (set.contains(entry.getKey())) {
                continue;
            }
            rMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return rMap;
    }

    /**
     * 验证返回结果
     *
     * @param apiResult
     * @return
     */
    public String checkApiResult(ApiResult apiResult) {
        if (apiResult == null) {
            return "remote apiResult is empty";
        }
        if (!apiResult.isSuccess()) {
            return apiResult.getError();
        }

        if (!StringUtils.isEmpty(apiResult.getError())) {
            return apiResult.getError();
        }
        if (apiResult.getData() == null) {
            return "data is null #" + apiResult.getError();
        }
        return null;
    }

    /**
     * 组装查询条件参数 现有：根据名称模糊查询
     *
     * @param request
     * @param pramsMap
     * @param searchParamMap
     * @param modelAndView
     */
    public void mapPrams(HttpServletRequest request, Map<String, String> pramsMap, Map<String, Object> searchParamMap, ModelAndView modelAndView) {
        for (Map.Entry<String, String> entry : pramsMap.entrySet()) {
            String val = RequestUtil.getStringTrans(request, entry.getValue());
            if (!StringUtils.isBlank(val)) {
                searchParamMap.put(entry.getKey(), val);
                modelAndView.addObject(entry.getValue(), val);
            }
        }
    }

    /**
     * id非空判断
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Long checkId(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if (StringUtils.isBlank(id)) {
            throw new Exception("id is empty");
        }
        return Long.valueOf(id);
    }

    /**
     * 参数非空判断
     *
     * @param request
     * @param necessaryParam
     * @return
     * @throws Exception
     */
    public String checkParamMiss(HttpServletRequest request, String[] necessaryParam) throws Exception {
        for (String param : necessaryParam) {
            if (StringUtils.isBlank(request.getParameter(param))) {
                throw new Exception(param + " is missing");
            }
        }
        return null;
    }

}
