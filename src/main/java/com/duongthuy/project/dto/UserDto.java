package com.duongthuy.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long userId;

    @Size(max = 50)
    private String username;

    @Email
    @Size(max = 100)
    private String email;

    @JsonIgnore
    @Size(max = 255)
    private String password;

    @Size(max = 100)
    private String fullName;

    @Size(max = 15)
    private String phone;
    private String roleName;

    @Size(max = 45)
    private String contactInfo;

    @Size(max = 45)
    private String supplierType;

    private String supplierIntro;

    private String supplierAddress;
}
