package com.code.cases;

import com.code.config.TestConfig;
import com.code.model.InterfaceName;
import com.code.model.LoginCase;
import com.code.utils.ClientUtil;
import com.code.utils.ConfigFile;
import com.code.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //-------写完接口的测试代码

        //发请求，获取结果
        String result = getResult(loginCase);
        System.out.println(result);
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFalse",description = "登录失败")
    public void loginFalse() throws IOException {
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            LoginCase loginCase = session.selectOne("loginCase",2);
            System.out.println(loginCase.toString());
            System.out.println(TestConfig.loginUrl);

            //发请求，获取结果
            String result = getResult(loginCase);
            System.out.println(result);
            //处理结果，就是判断返回结果是否符合预期
            Assert.assertEquals(loginCase.getExpected(),result);
        }catch (IOException e){
            session.rollback();
        }finally {
            session.close();
        }

    }
    private String getResult(LoginCase loginCase) throws IOException {
        //参数组装
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        //设置头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/json");
        //执行接口
        String result = ClientUtil.post(TestConfig.loginUrl,param.toString(),headerMap);
        return result;
    }


}
