package com.duongthuy.project.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

}