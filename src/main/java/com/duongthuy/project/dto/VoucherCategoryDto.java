package com.duongthuy.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class VoucherCategoryDto {
    private Integer id; // ID loại voucher
    private String voucherCategoryName; // Tên loại voucher
    private String categoryDescription; // Mô tả loại voucher
}
