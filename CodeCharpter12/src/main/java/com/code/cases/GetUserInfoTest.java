package com.code.cases;

import com.code.config.TestConfig;
import com.code.model.GetUserInfoCase;
import com.code.model.User;
import com.code.utils.ClientUtil;
import com.code.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "根据用户id获取用户信息接口测试")
    public void getUserInfo() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
        //--------写完接口的测试代码
        JSONArray resultJson = getResult(getUserInfoCase);
        User user = session.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        List users = new ArrayList();
        users.add(user);
        JSONArray expectJson = new JSONArray(users);
        Assert.assertEquals(resultJson.toString(),expectJson.toString());
    }

    private JSONArray getResult(GetUserInfoCase getUserInfoCase){
        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("id", getUserInfoCase.getUserId());
        //设置请求头信息
        HashMap<String,String>headers = new HashMap<>();
        headers.put("Content-type","application/json");
        System.out.println("getUserInfo的参数=========" + param.toString());
        //调用接口
        try {
            String result = ClientUtil.post(TestConfig.getUserInfoUrl,param.toString(), headers);
            JSONArray resultJson = new JSONArray(result);
            return resultJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
