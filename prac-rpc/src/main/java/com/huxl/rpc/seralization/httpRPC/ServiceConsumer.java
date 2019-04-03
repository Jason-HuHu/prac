package com.huxl.rpc.seralization.httpRPC;


import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huxl
 * @createDate 2017/10/30 17:00
 */
public class ServiceConsumer extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //参数
        String service = "com.huxl.seralization.httpRPC.SayHelloService";
        String format = "json";
        String arg1 = "hello";
        String url = "http://localhost:8080/provider.do?"+"service="
                + service + "&format=" + format + "&arg1=" + arg1;

        //组装请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        //接收响应
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        byte[] bytes = EntityUtils.toByteArray(httpEntity);

        String jsonResult = new String(bytes,"utf-8");
        JsonResult result = JSON.parseObject(jsonResult,JsonResult.class);
        response.getWriter().write(result.getResult().toString());
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
