package com.mooc.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass02 {
    public void stu1(){
        System.out.println("GroupsOnClass02中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass02中的stu2运行");
    }
}
