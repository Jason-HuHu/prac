package com.huxl.rpc.seralization.httpRPC;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author huxl
 * @createDate 2017/10/31 11:30
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        Main main = new Main();
        main.consumer();
    }

    private void consumer() throws IOException{
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
        System.out.println(jsonResult);
    }
}
