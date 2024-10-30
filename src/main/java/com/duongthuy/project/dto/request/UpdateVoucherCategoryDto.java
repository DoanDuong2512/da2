package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class UpdateVoucherCategoryDto {
    private String voucherCategoryName; // Tên loại voucher
    private String categoryDescription; // Mô tả loại voucher
}