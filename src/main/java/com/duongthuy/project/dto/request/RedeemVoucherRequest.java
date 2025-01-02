package com.duongthuy.project.dto.request;

import lombok.Data;

@Data
public class RedeemVoucherRequest {
    private String voucherCode;
    private String initialAmount;
}