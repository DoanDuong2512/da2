package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class UpdateSupplierRequest {
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private String contactInfo;
    private String supplierType;
    private String supplierIntro;
    private String supplierAddress;
}
