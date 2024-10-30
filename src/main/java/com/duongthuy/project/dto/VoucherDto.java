package com.duongthuy.project.dto;

import com.duongthuy.project.entity.Role;
import com.duongthuy.project.entity.User;
import com.duongthuy.project.entity.VoucherCategory;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class VoucherDto {
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
