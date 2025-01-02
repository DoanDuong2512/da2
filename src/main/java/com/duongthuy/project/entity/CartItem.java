package com.duongthuy.project.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Integer cartItemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    @ManyToOne
    @JoinColumn(name = "carts_cart_id")
    private Cart cart;

    @OneToMany(mappedBy = "cartItem")
    private List<CartItemVoucher> cartItemVouchers;
}