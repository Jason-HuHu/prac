package com.huxl.rpc.seralization.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author huxl
 * @createDate 2017/10/30 15:59
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //url前面加上http协议头，标明该请求为http请求
        String url = "http://www.baidu.com";

        //组装请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        //接收响应
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        byte[] bytes = EntityUtils.toByteArray(httpEntity);
        String result = new String(bytes, "utf-8");
        System.out.println(result);
    }
}
