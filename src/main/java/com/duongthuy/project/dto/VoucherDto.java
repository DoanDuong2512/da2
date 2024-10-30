package com.duongthuy.project.dto;

import com.duongthuy.project.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class VoucherDto {
    private Integer id; // ID of the voucher

    private VoucherCategoryDto category; // ID of the voucher category

    private UserDto supplier; // ID of the supplier

    private String usageConditions; // Usage conditions

    private BigDecimal minOrderAmount; // Minimum order amount to apply the voucher

    private String product; // Applicable product

    private String productIntro; // Product introduction

    private String description; // Voucher description

//    private String redemptionLocation; // Redemption location of the voucher
//
//    private Integer ratingsCount; // Number of ratings
//
//    private BigDecimal averageRating; // Average rating

    private Integer quantityAvailable; // Quantity available

    private LocalDate startDate; // Start date of the voucher

    private LocalDate endDate; // End date of the voucher

    private BigDecimal discountPercent; // Discount percentage

    private BigDecimal maxDiscountAmount; // Maximum discount amount for the voucher

    private Integer price; // Price of the voucher

    private Integer quantitySold; // Quantity sold

}
