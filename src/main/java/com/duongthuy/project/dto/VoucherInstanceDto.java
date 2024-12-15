package com.duongthuy.project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VoucherInstanceDto {
    private Integer voucherInstanceId;
    private Integer voucherId;
    private Integer userId;
    private String voucherCode;
    private LocalDateTime purchaseAt;
    private String status;
}
