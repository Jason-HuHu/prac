package com.huxl.seralization.httpRPC;

import com.alibaba.fastjson.JSON;

/**
 * @author huxl
 * @createDate 2017/10/31 10:25
 */
public class JsonUtil {
    public static String getJson(Object obj) {
        return JSON.toJSONString(obj).toString();
    }

    public static JsonResult jsonToObject(String jsonResult) {
        return JSON.parseObject(jsonResult,JsonResult.class);
    }
}
