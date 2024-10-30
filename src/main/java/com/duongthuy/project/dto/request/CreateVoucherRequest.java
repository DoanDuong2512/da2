package com.duongthuy.project.dto.request;

import com.duongthuy.project.entity.User;
import com.duongthuy.project.entity.VoucherCategory;

import java.math.BigDecimal;

public class CreateVoucherRequest {
    private Integer id;

    private VoucherCategory category;

    private User supplier;

    private String usageConditions;

    private BigDecimal minOrderAmount;

    private String product;

    private String productIntro;

    private String description;

    private String redemptionLocation;

    private Integer ratingsCount;
}
