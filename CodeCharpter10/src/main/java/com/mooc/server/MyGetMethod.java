package com.mooc.server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                return "恭喜你访问getWithCookies成功";
            }
        }
        return "你必须携带cookies信息";
    }
    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式url：ip:port/get/with/param?key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer>getProductsList01(@RequestParam Integer start,
                                              @RequestParam Integer end){
        Map<String, Integer>myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
    /**
     * 第二种需要携带参数才能访问的get请求
     * 第一种实现方式url：ip:port/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public Map<String,Integer>getProductsList02(@RequestParam Integer start,
                                                @RequestParam Integer end){
        Map<String, Integer>myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
}


