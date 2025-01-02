package com.duongthuy.project.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
public class VoucherRedemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer redemptionId;

    @ManyToOne
    @JoinColumn(name = "voucher_instance_id")
    private VoucherInstance VoucherInstance;

    private LocalDateTime redemptionDate;

    private String initialAmount;

    private String discountAmount;

    private String finalAmount;
}