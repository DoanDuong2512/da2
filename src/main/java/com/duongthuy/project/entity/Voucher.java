package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
@NoArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private Integer id;

    @JoinColumn(name = "category_category_id", referencedColumnName = "voucher_category_id")
    private VoucherCategory category;

    @JoinColumn(name = "supplier_id", referencedColumnName = "user_id")
    private User supplier;

    @Column(name = "usage_conditions")
    private String usageConditions;

    @Column(name = "min_order_amount")
    private BigDecimal minOrderAmount;

    @Column(name = "product")
    private String product;

    @Column(name = "product_intro")
    private String productIntro;

    @Column(name = "description")
    private String description;

    @Column(name = "redemption_location")
    private String redemptionLocation;

    @Column(name = "ratings_count")
    private Integer ratingsCount;

    @Column(name = "average_rating")
}

