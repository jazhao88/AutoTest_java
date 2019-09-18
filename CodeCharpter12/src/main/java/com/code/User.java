package com.code;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;

    @Override
    public String toString() {
        return "{id:" + id +
                ", userName:" + userName +
                ", age:" + age +
                ", sex:" + sex +
                ", permission:" + permission +
                ", isDelete:" + isDelete +
                '}';
    }
}
