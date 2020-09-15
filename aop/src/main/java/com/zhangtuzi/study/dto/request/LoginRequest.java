package com.zhangtuzi.study.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String name;
    private String pwd;
}
