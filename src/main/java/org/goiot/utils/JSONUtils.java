package org.goiot.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by chenxing on 2017/5/30.
 */
public class JSONUtils {
    public static String toJSONResponse(Object object) {
        JSONObject response = new JSONObject();
        response.put("data", object);
        return response.toString();
    }
}
