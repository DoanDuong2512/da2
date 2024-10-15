package com.duongthuy.project.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {
    private Long userId;

    @Size(max = 50)
    private String username;

    @Email
    @Size(max = 100)
    private String email;

    @Size(max = 100)
    private String fullName;

    @Size(max = 15)
    private String phone;

    @Size(max = 255)
    private String password;

    @Size(max = 45)
    private String contactInfo;

    @Size(max = 45)
    private String supplierType;

    private String supplierIntro;

    private String supplierAddress;
}
