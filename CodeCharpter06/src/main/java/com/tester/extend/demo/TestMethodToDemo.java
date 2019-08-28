package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodToDemo {
    @Test
    public void test01(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test02(){
        Assert.assertEquals("abc","abd");
    }

    @Test
    public void test03(){
        Assert.assertEquals("abc","abc");
    }
    @Test
    public void logDemo(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我自己的运行时异常");
    }
}
