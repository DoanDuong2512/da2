package com.duongthuy.project.dto.response;

import com.duongthuy.project.entity.VoucherRedemption;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoucherRedemptionResponse {
    private String message;
    private VoucherRedemption voucherRedemption;
}