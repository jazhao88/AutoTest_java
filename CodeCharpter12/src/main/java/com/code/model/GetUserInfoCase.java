package com.code.model;

import lombok.Data;

@Data
public class GetUserInfoCase {
    private Integer userId;
    private String expected;
}
