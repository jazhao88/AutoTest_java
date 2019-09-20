package com.code.model;

import lombok.Data;

@Data
public class GetUserListCase {
    private String userName;
    private Integer age;
    private Integer sex;
    private String expected;
}
