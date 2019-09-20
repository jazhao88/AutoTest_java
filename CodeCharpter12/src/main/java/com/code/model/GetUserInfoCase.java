package com.code.model;

import lombok.Data;

@Data
public class GetUserInfoCase {
    private int userId;
    private String expected;
}
