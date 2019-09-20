package com.code.utils;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClientUtil {
    public static CookieStore store;//用于存储cookie
    public static CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(store).build();//创建一个可关闭的HttpClient对象

    /**
     * 不带请求头的get方法
     * @param url
     * @return 返回响应对象
     */
    public static CloseableHttpResponse get(String url) throws IOException {
        //创建一个HttpGet的请求对象
        HttpGet httpGet= new HttpGet(url);
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }

    /**
     * 带请求头的get方法
     * @param url
     * @param headerMap
     * @return 返回响应对象
     * @throws IOException
     */
    public static CloseableHttpResponse get(String url, HashMap<String,String> headerMap) throws IOException {
        //创建一个HttpGet的请求对象
        HttpGet httpGet= new HttpGet(url);
        //加载请求头到httpget对象
        for (Map.Entry<String,String>entry : headerMap.entrySet()){
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        return httpResponse;
    }
    public static CloseableHttpResponse post(String url, String entityString, HashMap<String,String> headerMap) throws IOException {
        //创建一个HttpPost的请求对象
        HttpPost httpPost= new HttpPost(url);
        //设置参数
        StringEntity entity = new StringEntity(entityString,"utf-8");
        httpPost.setEntity(entity);
        //加载请求头到httpPost对象
        for (Map.Entry<String,String>entry : headerMap.entrySet()){
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        //执行请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        return httpResponse;
    }
}
