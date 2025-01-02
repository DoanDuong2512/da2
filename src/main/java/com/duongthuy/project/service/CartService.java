package com.duongthuy.project.service;

import com.duongthuy.project.entity.*;
import com.duongthuy.project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemVoucherRepository cartItemVoucherRepository;
    private final VoucherInstanceRepository voucherInstanceRepository;

    @Transactional
    public String addVoucherToCart(Integer cartId, Integer voucherId) {
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));

            VoucherInstance voucherInstance = voucherInstanceRepository.findById(voucherId)
                    .orElseThrow(() -> new RuntimeException("Voucher not found"));

            boolean voucherExists = cart.getCartItems().stream()
                    .flatMap(cartItem -> cartItem.getCartItemVouchers().stream())
                    .anyMatch(cartItemVoucher -> cartItemVoucher.getVoucher().getId().equals(voucherInstance.getVoucher().getId()));

            if (voucherExists) {
                return "Voucher is already in your cart";
            }

            CartItem cartItem = new CartItem();
            cartItem.setQuantity(1);
            cartItem.setAddedAt(LocalDateTime.now());
            cartItem.setCart(cart);
            cartItem = cartItemRepository.save(cartItem);

            CartItemVoucher cartItemVoucher = new CartItemVoucher();
            cartItemVoucher.setVoucher(voucherInstance.getVoucher());
            cartItemVoucher.setCartItem(cartItem);
            cartItemVoucherRepository.save(cartItemVoucher);

            cart.setUpdatedAt(LocalDateTime.now());
            cartRepository.save(cart);

            return "Add voucher to cart success";
        }
    }