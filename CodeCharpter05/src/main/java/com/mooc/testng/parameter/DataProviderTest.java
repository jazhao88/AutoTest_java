package com.mooc.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("简单的传参方法：name=" + name +"; age=" + age);
    }
    @DataProvider(name="data")
    public Object[][] providerData() {
        Object[][] obj = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return obj;
    }
    @Test(dataProvider="methodData")
    public void test01(String name, int age){
        System.out.println("test01的输出：name=" + name + "age=" + age);
    }
    @Test(dataProvider = "methodData")
    public void test02(String name, int age){
        System.out.println("test02的输出：name=" + name + "age=" + age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodData(Method method){
        Object [][] result = null;
        if (method.getName() == "test01"){
            result = new Object[][]{
                    {"张三",20},
                    {"李四",25}
            };
        }else {
            result = new Object[][]{
                    {"王五",50},
                    {"赵六",55}
            };
        }
        return result;
    }
}
