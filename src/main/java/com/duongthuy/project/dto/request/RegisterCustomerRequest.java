package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class RegisterCustomerRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private String roleCode;
}
