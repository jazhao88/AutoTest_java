package com.mooc.httpclient.cookie;

import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookie() throws IOException { //获取cookie
        //读取配置文件
        String result;
        this.store = new BasicCookieStore();
        String testUrl = this.url + bundle.getString("getCookies.uri");
        //测试逻辑代码
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        //CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(testUrl);
        CloseableHttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        List<Cookie> cookieList = this.store.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name = " + name + "\ncookie value = " + value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testPostMethod() throws IOException{
        String testUrl = this.url + bundle.getString("test.post.with.cookies");
        //声明一个client对象，用来进行方法的执行
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name","huhansan");
        jsonObj.put("age","18");
        //设置请求头信息
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(jsonObj.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行相应结果的存储
        String result;
        //设置cookies信息
        //执行post方法
        CloseableHttpResponse response = client.execute(post);
        //获取相应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，判断返回结果是否符合预期
        //将返回的习相远结果字符串转换成json对象
        JSONObject resultJson = new JSONObject(result);
        String success = resultJson.get("huhansan").toString();
        String status = resultJson.get("status").toString();
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
