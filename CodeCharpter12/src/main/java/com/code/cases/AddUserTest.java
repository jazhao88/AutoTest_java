package com.code.cases;

import com.code.model.User;
import com.code.config.TestConfig;
import com.code.model.AddUserCase;
import com.code.utils.ClientUtil;
import com.code.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            AddUserCase addUserCase = session.selectOne("addUserCase",1);
            if (addUserCase != null) {
                System.out.println(addUserCase.toString());
            }
            System.out.println(TestConfig.addUserUrl);
            //-------写完接口的测试代码
            //发请求，获取结果
            String result = getResult(addUserCase);//接口插入数据
            System.out.println(result);
            //验证数据
            Thread.sleep(1000);

            User user = session.selectOne("getAddUser",addUserCase);//从数据库读取插入的数据
            Assert.assertNotNull(user);
            System.out.println(user.toString());
            //处理结果，判断返回结果是否符合预期
            Assert.assertEquals(addUserCase.getExpected(),result);
        }catch (IOException e){
            session.rollback();
        }
        finally {
            session.close();
        }
    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        //参数组装
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        //设置头信息
        HashMap<String,String> headerMap = new HashMap<String,String>();
        headerMap.put("Content-Type","application/json");
        //执行接口
        String result = ClientUtil.post(TestConfig.addUserUrl,param.toString(),headerMap);
        return result;
    }
}
