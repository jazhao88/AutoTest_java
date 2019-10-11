package com.code.cases;

import com.code.config.TestConfig;
import com.code.model.UpdateUserInfoCase;
import com.code.model.User;
import com.code.utils.ClientUtil;
import com.code.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "更改用户姓名")
    public void updateUserInfo () throws InterruptedException {
        //从数据库获取用例，用例id=1
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            //获取用例的执行数据
            UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase",1);
            System.out.println(updateUserInfoCase.toString());
            System.out.println(TestConfig.updateUserInfoUrl);
            //执行接口
            String result = getResult(updateUserInfoCase);
            //验证数据
            Thread.sleep(1000);
            //查询更新的数据
            User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
            Assert.assertEquals(result.toString(),"1");
            Assert.assertNotNull(user);
        } catch (IOException e) {
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws InterruptedException {
        //从数据库获取用例，用例id=1
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase",2);
            System.out.println(updateUserInfoCase.toString());
            System.out.println(TestConfig.updateUserInfoUrl);
            //执行接口
            String result = getResult(updateUserInfoCase);
            //验证数据
            Thread.sleep(1000);
            //查询更新的数据
            User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
            Assert.assertEquals(result.toString(),"1");
            Assert.assertNotNull(user);
        } catch (IOException e) {
            session.rollback();
        }finally {
            session.close();
        }
    }

    /**
     * 获取结果
     * @param updateUserInfoCase
     * @return 返回更新后的结果，更新成功返回1
     */
    private String getResult(UpdateUserInfoCase updateUserInfoCase) {
        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("id", updateUserInfoCase.getUserId());
        param.put("userName", updateUserInfoCase.getUserName());
        param.put("sex", updateUserInfoCase.getSex());
        param.put("age", updateUserInfoCase.getAge());
        param.put("permission", updateUserInfoCase.getPermission());
        param.put("isDelete", updateUserInfoCase.getIsDelete());
        //设置请求头
        HashMap<String,String>headers = new HashMap<>();
        headers.put("Content-type","application/json");
        //调用接口
        String result = null;
        try {
            result = ClientUtil.post(TestConfig.updateUserInfoUrl,param.toString(),headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
