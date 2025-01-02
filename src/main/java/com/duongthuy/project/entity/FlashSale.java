package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "flash_sales")
public class FlashSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flash_sale_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "available_vouchers")
    private Integer availableVouchers;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;
}