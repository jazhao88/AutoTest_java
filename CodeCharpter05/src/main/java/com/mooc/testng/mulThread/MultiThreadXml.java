package com.mooc.testng.mulThread;

import org.testng.annotations.Test;

public class MultiThreadXml {
    @Test
    public void test01(){
        System.out.printf("\ntest01TreadId:%s\n",Thread.currentThread().getId());
    }
    @Test
    public void test02(){
        System.out.printf("\ntest02TreadId:%s\n",Thread.currentThread().getId());
    }
    @Test
    public void test03(){
        System.out.printf("\ntest03TreadId:%s\n",Thread.currentThread().getId());
    }
}
