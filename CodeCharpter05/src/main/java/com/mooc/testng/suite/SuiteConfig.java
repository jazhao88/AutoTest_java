package com.mooc.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("\nBeforeSuite运行啦");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite运行啦");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
}
