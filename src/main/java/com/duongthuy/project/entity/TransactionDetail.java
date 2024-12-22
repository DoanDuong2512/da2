package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction_details")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_detail_id")
    private Integer id; // ID chi tiết giao dịch

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")
    private Voucher voucher; // ID voucher

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    private Transaction transaction; // ID giao dịch

    @Column(name = "quantity")
    private Integer quantity; // Số lượng voucher

    public void setVoucherId(Integer id) {
        this.voucher = new Voucher();
        this.voucher.setId(id);
    }
    public void setTransactionDetailId(Integer id) {
        this.transaction = new Transaction();
        this.transaction.getId(id);
    }
}
