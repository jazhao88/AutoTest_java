package com.code.cases;

import com.code.config.TestConfig;
import com.code.GetUserInfoCase;
import com.code.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "根据用户id获取用户信息接口测试")
    public void getUserInfo() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
    }
}
