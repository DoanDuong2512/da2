package com.duongthuy.project.controller;

import com.duongthuy.project.dto.request.RedeemVoucherRequest;
import com.duongthuy.project.dto.response.VoucherInstanceResponse;
import com.duongthuy.project.entity.VoucherRedemption;
import com.duongthuy.project.service.VoucherRedemptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voucher-redemptions")
@RequiredArgsConstructor
public class VoucherRedemptionController {
    private final VoucherRedemptionService voucherRedemptionService;

    @PostMapping("/redemp")
    public ResponseEntity<VoucherInstanceResponse> redeemVoucher(@RequestBody RedeemVoucherRequest request) {
        return ResponseEntity.ok(voucherRedemptionService.redeemVoucher(request));
    }
    @GetMapping("/redeemed")
    public ResponseEntity<List<VoucherRedemption>> getAllRedeemedVouchers() {
        return ResponseEntity.ok(voucherRedemptionService.getAllRedeemedVouchers());
    }
}
