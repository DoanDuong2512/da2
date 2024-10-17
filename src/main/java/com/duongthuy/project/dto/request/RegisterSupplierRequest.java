package com.duongthuy.project.dto.request;

import com.duongthuy.project.entity.Role;
import lombok.Data;


@Data
public class RegisterSupplierRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private String roleCode;
    private String contactInfo;
    private String supplierType;
    private String supplierIntro;
    private String supplierAddress;
}
