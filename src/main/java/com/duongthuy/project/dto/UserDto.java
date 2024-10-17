package com.duongthuy.project.dto;

import com.duongthuy.project.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;

    private String email;

    private String fullName;

    private String phone;

    private RoleDto role;

    private String contactInfo;

    private String supplierType;

    private String supplierIntro;

    private String supplierAddress;
}
