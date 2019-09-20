package com.code.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer permission;
    private Integer isDelete;

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
