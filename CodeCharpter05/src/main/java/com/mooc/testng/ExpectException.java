package com.mooc.testng;

import org.testng.annotations.Test;

public class ExpectException {
    @Test(expectedExceptions = RuntimeException.class)
    public void errorException() {
        System.out.println("这是一个错误的异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void sucessException() {
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}