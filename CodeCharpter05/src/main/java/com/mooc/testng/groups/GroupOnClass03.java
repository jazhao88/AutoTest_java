package com.mooc.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass03 {
    public void teacher1(){
        System.out.println("GroupsOnClass03中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass03中的teacher2运行");
    }
}
