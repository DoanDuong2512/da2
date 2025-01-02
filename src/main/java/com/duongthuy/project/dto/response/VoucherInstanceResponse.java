package com.duongthuy.project.dto.response;

import com.duongthuy.project.entity.Voucher;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class VoucherInstanceResponse {
    private String voucherCode;
    private Timestamp purchaseAt;
}