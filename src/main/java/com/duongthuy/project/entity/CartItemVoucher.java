package com.duongthuy.project.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class CartItemVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_voucher_id")
    private Integer cartItemVoucherId;

    @ManyToOne
    @JoinColumn(name = "vouchers_voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "cart_items_cart_item_id")
    private CartItem cartItem;
}