package com.mooc.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupsOnMethod {
    @Test(groups = "server")
    public void groupTest01(){
        System.out.println("这是服务端组groupTest01");
    }
    @Test(groups = "server")
    public void groupTest02(){
        System.out.println("这是服务端组groupTest02");
    }
    @Test(groups = "client")
    public void groupTest03(){
        System.out.println("这是客户端组groupTest03");
    }
    @Test(groups = "client")
    public void groupTest04(){
        System.out.println("这是客户端组groupTest04");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组BeforeGroupsOnServer");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组AfterGroupsOnServer");
    }
}
