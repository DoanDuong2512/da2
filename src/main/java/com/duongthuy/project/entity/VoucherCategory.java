package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "voucher_categories")
@Data
public class VoucherCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_category_id")
    private Integer id;

    @Column(name = "voucher_category_name")
    private String voucherCategoryName;

    @Column(name = "category_description")
    private String categoryDescription;
}
