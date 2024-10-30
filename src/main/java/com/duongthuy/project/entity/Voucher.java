package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "category_category_id")
    private VoucherCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
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
    private BigDecimal averageRating;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "discount_percent")
    private BigDecimal discountPercent;

    @Column(name = "max_discount_amount")
    private BigDecimal maxDiscountAmount;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @Column(name = "is_active")
    private Boolean isActive; // Use Boolean instead of TINYINT(1)
}

