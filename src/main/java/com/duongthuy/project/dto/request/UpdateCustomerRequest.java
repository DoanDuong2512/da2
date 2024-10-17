package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String password;
    private String email;
    private String phone;
    private String fullName;
}
