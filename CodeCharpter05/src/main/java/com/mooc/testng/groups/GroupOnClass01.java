package com.mooc.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass01 {
    public void stu1(){
        System.out.println("GroupsOnClass01中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass01中的stu2运行");
    }
}
