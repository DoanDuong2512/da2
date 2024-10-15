package com.duongthuy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherDto {
    private Long voucherId;
    private Long categoryId;
    private Long supplierId;
    private String usageConditions;
    private BigDecimal minOrderAmount;
    private String product;
    private String productIntro;
    private String description;
    private String redemptionLocation;
    private Integer ratingsCount;
    private BigDecimal averageRating;
    private Integer quantityAvailable;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal discountPercent;
    private BigDecimal maxDiscountAmount;
    private Integer price;
    private Integer quantitySold;
    private Boolean isActive;
}
