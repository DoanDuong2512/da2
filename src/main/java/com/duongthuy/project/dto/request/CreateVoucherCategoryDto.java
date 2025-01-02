package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class CreateVoucherCategoryDto {
    private String voucherCategoryName;
    private String categoryDescription;
}