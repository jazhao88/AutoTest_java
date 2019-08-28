package com.mooc.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)//单位是毫秒
    public void testSuccess() throws InterruptedException{
        System.out.println("我是测试超时成功的");
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException{
        System.out.println("我是测试超时失败的");
        Thread.sleep(3000);
    }
}
