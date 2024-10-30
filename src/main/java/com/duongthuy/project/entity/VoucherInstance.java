package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "voucher_instances")
@Getter
@Setter
@NoArgsConstructor
public class VoucherInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_instance_id")
    private Integer id;

    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "voucher_code", length = 50)
    private String voucherCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "purchase_at")
    private Timestamp purchaseAt;

    @Column(name = "used_at")
    private Timestamp usedAt;

    @Column(name = "status", length = 45)
    private String status;
}
