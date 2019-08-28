package com.mooc.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase01(){
        System.out.printf("\ntestCase01TreadId:%s\n",Thread.currentThread().getId());
        System.out.println("这是测试用例01");
    }
    @Test
    public void testCase02(){
        System.out.printf("\ntestCase01TreadId:%s\n",Thread.currentThread().getId());
        System.out.println("这是测试用例02");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass这是在类运行之前的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass这是在类运行之后的方法");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}
