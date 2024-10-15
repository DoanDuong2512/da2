package com.duongthuy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherCategoryDto {
    private Long voucherCategoryId;
    private String voucherCategoryName;
    private String categoryDescription;
}
