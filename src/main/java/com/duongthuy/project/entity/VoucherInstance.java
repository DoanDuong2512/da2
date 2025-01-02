// VoucherInstance.java
package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "voucher_instances")
public class VoucherInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_instance_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    private User user;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "purchase_at")
    private Timestamp purchaseAt;

    @Column(name = "status")
    private String status;

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}