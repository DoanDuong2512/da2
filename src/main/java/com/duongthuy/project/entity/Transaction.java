package com.duongthuy.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId; // ID giao dịch

    @Column(name = "transaction_date")
    private LocalDate transactionDate; // Ngày giao dịch
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    @Column(name = "amount_paid")
    private BigDecimal amountPaid; // Số tiền đã thanh toán

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private User supplier; // ID nhà cung cấp

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer; // ID khách hàng

    @Column(name = "payment_method")
    private String paymentMethod; // Phương thức thanh toán

    public void setSupplierId(Integer id) {
        if (this.supplier == null) {
            this.supplier = new User();
        }
        this.supplier.setId(id);
    }

    public void setCustomerId(Integer id) {
        if (this.customer == null) {
            this.customer = new User();
        }
        this.customer.setId(id);
    }
    public Integer getId(Integer id) {
        return this.transactionId;
    }
}
