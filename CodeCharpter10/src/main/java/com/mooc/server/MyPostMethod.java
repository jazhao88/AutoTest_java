package com.mooc.server;

import com.mooc.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mockito.internal.matchers.Null;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")//访问所有方法的路径必须加/v1
public class MyPostMethod {
    private static Cookie cookie;

    //用户登录成功获取到cookies，然后在访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true) String password){
        if(userName.equals("zhangsan")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";
        }
        return "用户名或密码错误";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User loginUser){
        //获取cookies
        Cookie[] cookies = request.getCookies();
        User u;
        //验证cookies是否合法
        if (cookies == null){
            return "没有cookie信息";
        }
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    &&loginUser.getUserName().equals("zhangsan")
                    &&loginUser.getPassword().equals("123456")){
                u = new User();
                u.setName("lisi");
                u.setAge("18");
                u.setSex("man");
                return u.toString();
            }
        }
        return "参数不合法";
    }
}

