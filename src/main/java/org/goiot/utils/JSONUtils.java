package org.goiot.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxing on 2017/5/30.
 */
public class JSONUtils {

    public static String toJSONResponse(Object object) {
        return JSON.toJSONString(object);
    }

    public static String failedResponse(String message) {
        Map<String, Object> failedResponse = new HashMap(2);
        failedResponse.put("success", false);
        failedResponse.put("message", message);
        return JSON.toJSONString(failedResponse);
    }

    public static String successResponse() {
        Map<String, Object> failedResponse = new HashMap(2);
        failedResponse.put("success", true);
        return JSON.toJSONString(failedResponse);
    }
}
