package com.code.cases;

import com.code.config.TestConfig;
import com.code.model.GetUserListCase;
import com.code.model.User;
import com.code.utils.ClientUtil;
import com.code.utils.DataBaseUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserInfoList() throws IOException, InterruptedException {
        SqlSession session = DataBaseUtil.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //发送请求
        JSONArray resultJson = getJsonResult(getUserListCase);
        Thread.sleep(2000);
        //验证
        List<User> userList = session.selectList(getUserListCase.getExpected(),getUserListCase);
        for(User u : userList){
            System.out.println("list获取的user：" + u.toString());
        }
        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(), resultJson.length());
        for (int i = 0;i<resultJson.length();i++){
            JSONObject expect = (JSONObject)userListJson.get(i);
            JSONObject result = (JSONObject)resultJson.get(i);
            Assert.assertEquals(result.toString(),expect.toString());
        }
    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        //设置参数信息
        JSONObject param = new JSONObject();
        param.put("userName", getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        System.out.println("param====" + param.toString());
        //设置请求头信息 设置header
        HashMap<String,String>headerMap = new HashMap<>();
        headerMap.put("Content-type","application/json");
        //执行
        String result = ClientUtil.post(TestConfig.getUserListUrl,param.toString(),headerMap);
        System.out.println("result=" + result);
        JSONArray resultJson = new JSONArray(result);
        return resultJson;
    }
}
