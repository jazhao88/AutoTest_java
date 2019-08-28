package com.mooc.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
    @Test
    @Parameters({"name","age"})
    public void paramTest01(String name, int age){
        System.out.println("\n name=" + name +"\n age=" + age);
    }
}
