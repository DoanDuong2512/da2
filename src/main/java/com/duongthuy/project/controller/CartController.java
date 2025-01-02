package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.VoucherRequest;
import com.duongthuy.project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{cartId}/add-voucher")
    public ResponseEntity<String> addVoucherToCart(@PathVariable Integer cartId, @RequestBody VoucherRequest voucherRequest) {
        String response = cartService.addVoucherToCart(cartId, voucherRequest.getVoucherId());
        return ResponseEntity.ok(response);
    }
}